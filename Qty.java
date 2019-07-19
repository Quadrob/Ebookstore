package ebookstore;

import java.util.Scanner;
import java.sql.*;

public class Qty {

	public void bookQty() {

		System.out.println("\n\t\t\t*** Search Qty of Book ***");
		System.out.println("\t\t__________________________________________\n");
		Menu Qty = new Menu();
		int qtySelect = (Qty.searchMenu());
		Scanner qtyScan = new Scanner(System.in);
		String strSelect = "";
		int qty = 0;
		String del = "";

		while (qtySelect != 0) {

			try (
					// Step 1: Allocate a database 'selConnection' object
					Connection qtyconnect = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/library_db?useSSL=false", "robert", "5563");
					// Step 2: Allocate a 'selStatement' object in the Connection
					Statement qtystatement = qtyconnect.createStatement();
					) {
				if (qtySelect == 1) {
					System.out.println("\nPlease Enter ID : ");
					int newid = qtyScan.nextInt();
					qtyScan.nextLine();
					strSelect = ("select Qty from ebookstore where id = " + newid);
					del = ("delete from ebookstore where id = " + newid);

				} else if (qtySelect == 2) {
					System.out.println("\nPlease Enter Title : ");
					String newTitle = qtyScan.nextLine();
					strSelect = ("select Qty from ebookstore where Title = '" + newTitle + "'");
					del = ("delete from ebookstore where Title = '" + newTitle + "'");

				} else if (qtySelect == 3) {
					System.out.println("\nPlease Enter Author : ");
					String newAuthor = qtyScan.nextLine();
					strSelect = ("select Qty from ebookstore where Author = '" + newAuthor + "'");
					del = ("delete from ebookstore where Author = '" + newAuthor + "'");

				} else {
					System.out.println("*** Incorrect Input ***");
				}
				ResultSet rset = qtystatement.executeQuery(strSelect);

				while (rset.next()) {

					qty = rset.getInt("Qty");
					System.out.println("\n The Qty of this book in Stock is : " + qty);
					System.out.println("____________________________________________________________\n\n");
				}
				if (qty == 0) {
					System.out.println("\n\t\t*** The Book is out of Stock ***");
					System.out.println("\t  =========================================================");
					System.out.println("\n\t| 1. Order More Copies of this book.\n\n\t| 0. Delete Book From Database.\n");
					System.out.println("\n\tPlease Enter a number : ");
					int answer = qtyScan.nextInt();
					qtyScan.nextLine();

					if (answer == 1) {
						Order outQty = new Order();
						outQty.orderbook();
					} else {
						int countDeleted = qtystatement.executeUpdate(del);
						System.out.println(countDeleted + " Book Deleted.\n");
					} 
				} else if (qty <= 3) {
					System.out.println("\n\t\t*** The Qty of this Book is very low ***");
					System.out.println("\t  =========================================================");
					System.out.println("\n\t| 1. Order More Copies of this book.\n\n\t| 0. Exit.\n");
					System.out.println("\n\tPlease Enter a number : ");
					int answer = qtyScan.nextInt();
					qtyScan.nextLine();

					if (answer == 1) {
						Order lowQty = new Order();
						lowQty.orderbook();
					}
				} 
				qtySelect = (Qty.searchMenu());
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}