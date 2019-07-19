package ebookstore;

import java.util.Scanner;

public class Order {

	public void orderbook() {

		System.out.println("\n\n\t\t\t*** Order Book ***");
		System.out.println("\t\t__________________________________");
		System.out.println("\n\tPlease Enter - \n\n");
		Scanner scannerO = new Scanner(System.in);

		System.out.println("\t• Book Title : ");
		String bookTitle = scannerO.nextLine();

		System.out.println("\t• Book Author: ");
		String bookAuthor = scannerO.nextLine();

		System.out.println("\t• How many Books must be Ordered : ");
		int bookQty = scannerO.nextInt();

		String orderInfo = ("\tBook to be Ordered :\n\n Hello Book Supplier \n Please could you email us back a quote on the book order below ?\n\n\t • Title - " + bookTitle + "\n\t • Author - " + bookAuthor + "\n\t • Qty - " + bookQty + "\n\n Please find above the requested book as well as the quantity.\n\n Kind Regards\n A-Z Bookstore");

		scannerO.nextLine();
		System.out.println("\n\t• Please enter the book supplier's email address : \n");
		String email = scannerO.nextLine();

		System.out.println("\n\n\t\t\tSending Email\n\n\t\t\t• Loading •");
		System.out.println("\n\t\t\tEmail Sent!");
		System.out.println("\n\n\tFind Attached The Email Sent Below :\n\n");
		System.out.println("\tEmail Sent To: " + email + "\n");
		System.out.println("\tEmail Contents : ");
		System.out.println(" \n_____________________________________________________________________");
		System.out.println("\n\n" + orderInfo);
		System.out.println(" \n_____________________________________________________________________\n\n\n");	
	}
}