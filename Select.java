package ebookstore;

import java.sql.*;

public class Select {

	public String selectbook(String select) {

		String book = "";
		try (
				// Step 1: Allocate a database 'selConnection' object
				Connection selconnect = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/library_db?useSSL=false", "robert", "5563");
				// Step 2: Allocate a 'selStatement' object in the Connection
				Statement selstatement = selconnect.createStatement();
				) {
			ResultSet rset = selstatement.executeQuery(select);

			while (rset.next()) {

				int id = rset.getInt("id");
				String title = rset.getString("Title");
				String Author = rset.getString("Author");
				int qty = rset.getInt("Qty");
				book = book + ("\nBook ID: " + id + ", Title: " + title + ", Author: " + Author + ", Qty: " + qty + "\n");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return book;
	}
}