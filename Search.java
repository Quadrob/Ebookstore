package ebookstore;

import java.util.Scanner;
import java.sql.*;

public class Search {

    public void searchbook() {

        System.out.println("\n\t\t\t*** Search Book ***");
        System.out.println("\t\t__________________________________\n\n");
        String strSelect = "";
        Menu search = new Menu();
        int optionNum = (search.searchMenu());
        Scanner upScan = new Scanner(System.in);

        while (optionNum != 0) {

            try (
                // Step 1: Allocate a database 'selConnection' object
                Connection seaconnect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db?useSSL=false", "robert", "5563");
                // Step 2: Allocate a 'selStatement' object in the Connection
                Statement seastatement = seaconnect.createStatement();
            ) {
                if (optionNum == 1) {
                    System.out.println("\nPlease Enter ID : ");
                    int newid = upScan.nextInt();
                    upScan.nextLine();
                    strSelect = ("select * from ebookstore where id = " + newid);

                } else if (optionNum == 2) {
                    System.out.println("\nPlease Enter Title : ");
                    String newTitle = upScan.nextLine();
                    strSelect = ("select * from ebookstore where Title = '" + newTitle + "'");

                } else if (optionNum == 3) {
                    System.out.println("\nPlease Enter Author : ");
                    String newAuthor = upScan.nextLine();
                    strSelect = ("select * from ebookstore where Author = '" + newAuthor + "'");

                } else {
                    System.out.println("*** Incorrect Input ***");
                }
                ResultSet rset = seastatement.executeQuery(strSelect);

                while (rset.next()) {

                    int id = rset.getInt("id");
                    String title = rset.getString("Title");
                    String Author = rset.getString("Author");
                    int qty = rset.getInt("Qty");
                    System.out.println("\n\t\t\tThe Found Book : ");
                    System.out.println(" \n=====================================================================");
                    System.out.println("\nBook ID: " + id + ", Title: " + title + ", Author: " + Author + ", Qty: " + qty + "\n");
                    System.out.println("=====================================================================\n\n");
                }
                optionNum = (search.searchMenu());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }   
        }
    }
}