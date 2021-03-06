package Default;

import java.util.Scanner;
/************************************************************************************************************
 Purpose:  This class will model a simple resource being borrowed from a library by keeping title, borrower, duedate, and overdue cost.
 Author:   Andrew Palmer
 Course: F2018 - CST8130
 Lab Section: 312
 Data members:  title String no spaces
 borrower: String
 overdueCost: Float
 edition: MyDate
 MyDateL refer to MyDate class
 Methods: default constructor
 toString (): Prints relevant resource information
 inputResource (): Asks questions to fill out members/values of resources
 isOverDue (): Checks to see if the dueDate is less than the current date returns true/false accordingly
 displayOverDue(): calls isOverdue and prints the relevant info if true.


 *************************************************************************************************************/


public class Magazine extends Resource {
	protected MyDate edition;

	public Magazine() {
		overdueCost = 1;
	}

	@Override
	public boolean inputResource(Scanner input, MyDate date) {
		do {
			System.out.println("What is the title: ");
			if (input.hasNext()) {
				title = input.next();
			}
			System.out.println("What is the borrowers name: ");
			if (input.hasNext()) {
				borrower = input.next();
			}
			System.out.println("What is the Edition date?");
			edition = new MyDate();
			edition.inputDate(input);

		} while (title == null && borrower == null);
		dueDate = new MyDate(date);
		//set the dueDate for a book that is borrowed
		for (int i = 0; i < 7; i++) {
			dueDate.addOne();
		}
		return true;
	}

	public boolean isOverDue(MyDate today) {
		if (today.isGreaterThan(this.dueDate)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Edition: " + edition + " " + borrower + " has " + title + " due on " + dueDate + " and if late $" + overdueCost;
//		edition  2018/9/1 JBlow has Time due on  2018/9/24 and if late 1.0
	}
}
