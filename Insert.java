package ebookstore;

import java.util.Scanner;
import java.sql.*;

public class Insert {

    public void insertBook() {

        System.out.println("\n\t\t\t*** Enter Book ***");
        System.out.println("\t\t__________________________________");
        System.out.println("\nPlease Enter - \n\n� Book ID : ");
        Scanner scanner = new Scanner(System.in);
        int bookid = scanner.nextInt();

        scanner.nextLine();
        System.out.println("� Book Title : ");
        String bookTitle = scanner.nextLine();

        System.out.println("� Book Author: ");
        String bookAuthor = scanner.nextLine();

        System.out.println("� Book Qty : ");
        int bookQty = scanner.nextInt();

        String sqlInsert = ("insert into ebookstore values (" + bookid + ", '" + bookTitle + "', '" + bookAuthor + "', " + bookQty + ")");


        try (
            // Step 1: Allocate a database 'Connection' object
            Connection connect = DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/library_db?useSSL=false", "robert", "5563");

            // Step 2: Allocate a 'Statement' object in the Connection
            Statement statement = connect.createStatement();
        ) {
            int countInserted = statement.executeUpdate(sqlInsert);
            System.out.println(countInserted + " Book Inserted.\n");
			
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}