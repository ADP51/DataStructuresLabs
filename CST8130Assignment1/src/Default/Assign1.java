package Default;

import java.util.Scanner;
/********************************************************************************************************
		Purpose:  Contains
		Author:  Andrew Palmer
		Course: F2018 - CST8130
		Lab Section: 312
		Data members:
		keyboard: Scanner
        run: Boolean
        lib: Library
        today: MyDate see MyDate class
		Methods:
		main()
		*************************************************************************************************************/
public class Assign1 {


	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean run = true;
		Library lib = new Library(4);
		MyDate today = new MyDate();
		System.out.println("Enter today's date.");
		today.inputDate(keyboard);

		while (run) {
			System.out.println("Enter 1 to input Resource.");
			System.out.println("Enter 2 to display overdue resources.");
			System.out.println("Enter 3 to display all resources.");
			System.out.println("Enter 4 to delete a resource.");
			System.out.println("Enter 5 to change today's date.");
			System.out.println("Enter 6 to quit");
			if(keyboard.hasNextInt()) {
				int choice = keyboard.nextInt();

				switch (choice) {
					case 1:
						lib.inputResource(keyboard, today);
						break;
					case 2:
						lib.resourcesOverdue(today);
						break;
					case 3:
						System.out.println(lib);
						break;
					case 4:
						lib.deleteResource(keyboard, today);
						break;
					case 5:
						today.inputDate(keyboard);
						break;
					case 6:
						System.out.println("Goodbye!");
						run = false;
						break;
					default:
						System.out.println("Not an option");
						keyboard.next();
						break;
				}
			} else {
				System.out.println("That's not a valid option");
				keyboard.next();
			}
		}
	}
}

