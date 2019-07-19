package ebookstore;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		int menuNum = 0;
		Menu A = new Menu();

		System.out.println("\n\t\t\tWelcome to A-Z Bookstore ©");
		System.out.println("\t\t_________________________________________");
		System.out.println("\n\n\nPlease Enter Your Details Below - ");
		System.out.println("\n• User Name: ");

		Scanner userScan = new Scanner(System.in);
		String userName = userScan.next();

		System.out.println("\n• Password: ");
		String userPassword = userScan.next();

		if (userName.equals("r") && userPassword.equals("r")) {
			System.out.println("\n\t\t\tWelcome Admin!\n\t\t______________________________\n\n\n ");
			menuNum = A.mainMenu();
		} else {
			System.out.println("\n\t<**** Sorry Incorrect Details ****>");
		}
		while (menuNum != 0) {

			switch (menuNum) {

			case 1:
				Insert B = new Insert();
				B.insertBook();
				menuNum = A.mainMenu();
				break;

			case 2:
				Update C = new Update();
				C.updatebook();
				menuNum = A.mainMenu();
				break;

			case 3:
				Delete D = new Delete();
				D.deletebook();
				menuNum = A.mainMenu();
				break;

			case 4:
				Search E = new Search();
				E.searchbook();
				menuNum = A.mainMenu();
				break;

			case 5:
				Select selectall = new Select();
				String selectAll = ("SELECT * FROM ebookstore");
				String allBooks = (selectall.selectbook(selectAll));
				System.out.println("\n\tAll Books In Library : \n\n" + allBooks);
				System.out.println("\n\tAbove is all the books we currently have in Stock.\n");
				menuNum = A.mainMenu();
				break;

			case 6:
				Qty F = new Qty();
				F.bookQty();
				menuNum = A.mainMenu();
				break;

			case 7:
				Order G = new Order();
				G.orderbook();
				menuNum = A.mainMenu();
				break;
			}
		}
		System.out.println("\nYou are now exiting the program!");
		System.out.println("\n\t\t_______________________\n\n\t\t\tGoodbye");
		System.out.println("\t\t_______________________");
	}
}
