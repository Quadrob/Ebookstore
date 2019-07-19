package ebookstore;

import java.util.Scanner;

public class Menu {

    public int mainMenu() {

        Scanner numberScan = new Scanner(System.in); 
		System.out.println("\n\t\t\t• Main Menu • \n_____________________________________________________________________");
        System.out.println("\n\n\t| 1. Enter a Book.");
        System.out.println("\t| 2. Update a Book.");
        System.out.println("\t| 3. Delete a Book.");
        System.out.println("\t| 4. Search for Books.");
        System.out.println("\t| 5. View all Books.");
        System.out.println("\t| 6. Check Qty of a Book.");
        System.out.println("\t| 7. Order New Book.");
        System.out.println("\n\t| 0. Exit.");
        System.out.println(" \n_____________________________________________________________________");
        System.out.println("\nPlease enter a number for the operation you'd like to perform : ");
        int number = numberScan.nextInt();

        return number;
    }
	
    public int searchMenu() {

        Scanner numberSc = new Scanner(System.in);
        System.out.println("\n\t\t\t• Search Method Menu • \n_____________________________________________________________________");
        System.out.println("\n\t1. Search by Book id.");
        System.out.println("\t2. Search by Book title.");
        System.out.println("\t3. Search by Book author.");
        System.out.println("\n\t0. Exit.");
        System.out.println(" \n_____________________________________________________________________");
        System.out.println("\nPlease enter a number for the method you'd like to use:");
        int searchNum = numberSc.nextInt();

        return searchNum;
    }
	
    public int updateMenu() {

        Scanner numberUp = new Scanner(System.in);
        System.out.println("\n\t\t\t• Update Menu • \n_____________________________________________________________________");
        System.out.println("\n\t1. Update Book id.");
        System.out.println("\t2. Update Book title.");
        System.out.println("\t3. Update Book author.");
        System.out.println("\t4. Update Book qty.");
        System.out.println("\n\t0. Exit.");
        System.out.println(" \n_____________________________________________________________________");
        System.out.println("\nPlease enter a number for the item you'd like to update : ");
        int searchUp = numberUp.nextInt();

        return searchUp;
    }
}