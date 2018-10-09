package Default;

import java.util.Scanner;
/************************************************************************************************************
 Purpose:  This class will model a simple resource being borrowed from a library by keeping title, borrower, duedate, and overdue cost.
 Author:   Andrew Palmer
 Course: F2018 - CST8130
 Lab Section: 312
 Data members:  title String no spaces
 borrower: String
 overDueCost: Float
 author: String
 MyDateL refer to MyDate class
 Methods: default constructor
 toString (): Prints relevant resource information
 inputResource (): Asks questions to fill out members/values of resources
 isOverDue (): Checks to see if the dueDate is less than the current date returns true/false accordingly
 displayOverDue(): calls isOverdue and prints the relevant info if true.


 *************************************************************************************************************/


public class Book extends Resource {
	protected String author;

	public Book() {
		overdueCost = 2;
	}

	@Override
	public boolean inputResource(Scanner input, MyDate date) {
		System.out.println("What is the title: ");
		if (input.hasNext()) {
			title = input.next();
		}
		System.out.println("What is the borrowers name: ");
		if (input.hasNext()) {
			borrower = input.next();
		}
		System.out.println("Enter author name: ");
		if (input.hasNext()) {
			author = input.next();
		}
		dueDate = new MyDate(date);
		for (int i = 0; i < 14; i++) {
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
		return "Author: " + author + " " + borrower + " has " + title + " due on " + dueDate + " and if late $" + overdueCost;
//		author Hemingway LindaCrane has ToKillAMockingBird due on  2018/10/1 and if late 2.0
	}

}
