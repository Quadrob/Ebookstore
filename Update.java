package ebookstore;

import java.util.Scanner;
import java.sql.*;

public class Update {

    public void updatebook() {

        Select upSelect = new Select();
        String strUpdate = "";

        System.out.println("\n\t\t\t*** Update Book ***");
        System.out.println("\t\t__________________________________");
        System.out.println("\nPlease Enter the Book ID of which you'd like to update:\n\nBook ID : ");
        Scanner upScan = new Scanner(System.in);
        int bookid = upScan.nextInt();
        String strSelect = ("select * from ebookstore where id = " + bookid);

        String selBook = (upSelect.selectbook(strSelect));
        System.out.println("\nSelected Book : " + selBook);

        Menu update = new Menu();
        int optionNum = (update.updateMenu());

        while (optionNum != 0) {

            try (
                // Step 1: Allocate a database 'Connection' object
                Connection upconnect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db?useSSL=false", "robert", "5563");
                // Step 2: Allocate a 'Statement' object in the Connection
                Statement upstatement = upconnect.createStatement();
            ) {
                if (optionNum == 2) {
                    System.out.println("\nPlease Enter New Title : ");
                    upScan.nextLine();
                    String newTitle = upScan.nextLine();
                    strUpdate = ("update ebookstore set Title = '" + newTitle + "' where id = " + bookid);

                } else if (optionNum == 3) {
                    System.out.println("\nPlease Enter New Author : ");
                    upScan.nextLine();
                    String newAuthor = upScan.nextLine();
                    strUpdate = ("update ebookstore set Author = '" + newAuthor + "' where id = " + bookid);

                } else if (optionNum == 4) {
                    System.out.println("\nPlease Enter New Qty : ");
                    int newQty = upScan.nextInt();
                    strUpdate = ("update ebookstore set Qty = " + newQty + " where id = " + bookid);

                } else if (optionNum == 1) {
                    System.out.println("\nPlease Enter New ID : ");
                    int newid = upScan.nextInt();
                    strUpdate = ("update ebookstore set id = " + newid + " where id = " + bookid);

                } else {
                    System.out.println("*** Incorrect Input ***");
                }
                int countUpdated = upstatement.executeUpdate(strUpdate);
                System.out.println(countUpdated + " Book Affected.");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            optionNum = (update.updateMenu());
        }
    }
}