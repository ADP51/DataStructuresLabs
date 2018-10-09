package Default;

import java.util.Scanner;
/************************************************************************************************************
 Purpose:  This class will model a simple resource being borrowed from a library by keeping title, borrower, duedate, and overdue cost.
 Author:   Andrew Palmer
 Course: F2018 - CST8130
 Lab Section: 312
 Data members:  title String no spaces
 borrower: String
 overDueCost : Float
 type: String
 MyDateL refer to MyDate class
 Methods: default constructor
 toString (): Prints relevant resource information
 inputResource (): Asks questions to fill out members/values of resources
 isOverDue (): Checks to see if the dueDate is less than the current date returns true/false accordingly
 displayOverDue(): calls isOverdue and prints the relevant info if true.
 *************************************************************************************************************/


public class DVD extends Resource {
	protected String type;

	public DVD() {
		overdueCost = 1;
	}

	@Override
	public boolean inputResource(Scanner input, MyDate date) {
		System.out.println("What is the title: ");
		if (input.hasNext()) {
			title = input.next();
		} else {
			System.out.println("No Title Provided.");
		}
		System.out.println("What is the borrowers name: ");
		if (input.hasNext()) {
			borrower = input.next();
		} else {
			System.out.println("No Borrower Provided.");
		}
		System.out.println("What type of DVD is this?");
		if (input.hasNext()) {
			type = input.next();
		} else {
			System.out.println("No type provided.");
		}
		//set the dueDate for a book that is borrowed
		dueDate = new MyDate(date);
		for (int i = 0; i < 3; i++) {
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
		return "Type of DVD: " + type + " " + borrower + " has " + title + " due on " + dueDate + " and if late $" + overdueCost;
		//type of DVD : BlueRay SusanSmith has Incredibles2 dueon  2018/9/20 and if late 1.0
	}
}
