package ebookstore;

import java.util.Scanner;
import java.sql.*;

public class Delete {

	public void deletebook() {

		Select delSelect = new Select();

		System.out.println("\n\t\t\t*** Delete Book ***");
		System.out.println("\t\t__________________________________");
		System.out.println("\nPlease Enter - \n\n� Book ID : ");
		Scanner delscanner = new Scanner(System.in);
		int bookid = delscanner.nextInt();

		String sqlDelete = ("delete from ebookstore where id = " + bookid);
		String strSelect = ("select * from ebookstore where id = " + bookid);

		try (
				// Step 1: Allocate a database 'selConnection' object
				Connection delconnect = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/library_db?useSSL=false", "robert", "5563");

				// Step 2: Allocate a 'selStatement' object in the Connection
				Statement delstatement = delconnect.createStatement();
				) {
			String selBook = (delSelect.selectbook(strSelect));
			System.out.println("Selected Book : " + selBook);
			int optionNum = (deloption());

			if (optionNum == 1) {
				int countDeleted = delstatement.executeUpdate(sqlDelete);
				System.out.println(countDeleted + " Book Deleted.\n");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static int deloption() {

		System.out.println("\n\t| 1.Delete book\n\n\t| 0.Exit\n\nPlease Enter a Number: ");
		Scanner opScan = new Scanner(System.in);
		int temp = opScan.nextInt();

		return temp;
	}
}