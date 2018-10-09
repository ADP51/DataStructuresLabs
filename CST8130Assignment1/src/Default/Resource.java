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
		MyDateL refer to MyDate class
		Methods: default constructor
		toString (): Prints relevant resource information
		inputResource (): Asks questions to fill out members/values of resources
		isOverDue (): Checks to see if the dueDate is less than the current date returns true/false accordingly
        displayOverDue(): calls isOverdue and prints the relevant info if true.


		*************************************************************************************************************/

public class Resource {
	protected String title;
	protected String borrower;
	protected MyDate dueDate;
	protected float overdueCost;

	public Resource() {

	}

	public boolean inputResource(Scanner input, MyDate date) {
		return true;
	}

	public boolean isOverDue(MyDate today) {
		if (dueDate.isGreaterThan(today)) {
			return true;
		}
		return false;
	}

	public void displayOverDue() {
		System.out.println(borrower + "has an overdue fee of: " + overdueCost + "$");
	}


}
