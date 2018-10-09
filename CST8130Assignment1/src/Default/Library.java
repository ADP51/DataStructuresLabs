package Default;

import java.util.Scanner;
/************************************************************************************************************
 Purpose:  This class will model a simple resource being borrowed from a library by keeping title, borrower, duedate, and overdue cost.
 Author:   Andrew Palmer
 Course: F2018 - CST8130
 Lab Section: 312
 Data members:
 resourcesBorrowed[]: Resource - an array of resources that are borrowed from this Library
 numResources: int - used to keep track of the array index for resoucesBorrowed
 max: int - used to set the array size in the constructor
 Methods: default constructor : takes an int as an arg
 toString (): Prints relevant resource information
 inputResource (): Asks questions to fill out members/values of resources and calls the inputResource of the resource
 deleteResource (): Is used to delete a resource from the resourcesBorrowed array
 displayOverDue(): runs through the resourcesBorrowed array and checks if its overdue then returns resources that arre
 *************************************************************************************************************/

public class Library {

	protected Resource resourcesBorrowed[];
	protected int numResources = 0;
	protected int max = 1;

	public Library(int maxResources) {
		max = maxResources;
		resourcesBorrowed = new Resource[max];
	}

	public void inputResource(Scanner in, MyDate today) {
		try {
			System.out.println("What type of resource is this? Book, Magazine, DVD (B,M,D)");
			if (in.hasNext()) {
				String category = in.next();
				if (category.equals("M") || category.equals("m")) {
					resourcesBorrowed[numResources] = new Magazine();
				} else if (category.equals("D") || category.equals("d")) {
					resourcesBorrowed[numResources] = new DVD();
				} else {
					resourcesBorrowed[numResources] = new Book();
				}
				resourcesBorrowed[numResources].inputResource(in, today);
				numResources++;
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Error - array is full!");
		}
	}

	public String toString() {
		int index = 0;
		if (resourcesBorrowed[index] == null) {
			System.out.println("Title: \n");
		} else {
			System.out.println("Resources borrowed: ");
			for (int i = 0; i < numResources; i++) {
				System.out.println(index + ":" + resourcesBorrowed[i]);
				index++;
			}
		}
		return "";
	}

	public void resourcesOverdue(MyDate today) {
		int num = 1;
		boolean overdue = false;
		for (int i = 0; i < numResources; i++) {
			if (resourcesBorrowed[i].isOverDue(today)) {
				System.out.println("Resources overdue as of " + today + " are: ");
				System.out.println(num + ": title: " + resourcesBorrowed[i].title + " borrower: " + resourcesBorrowed[i].borrower + " owes: " + resourcesBorrowed[i].overdueCost + "$.");
				num++;
				overdue = true;
			}
		}
		if (!overdue) {
			System.out.println("Title: ");
		}
		System.out.println("");
	}

	public void deleteResource(Scanner in, MyDate today) {
		int indexDeleted;
		int check = 1;
		//check to see if array is empty
		if (resourcesBorrowed[0] == null) {
			System.out.println("No resources to delete.");
		} else {
			System.out.println(this);
			do {
				System.out.println("Select the index of the resource you would like to delete.");
				try {
					if (in.hasNextInt()) {
						indexDeleted = in.nextInt();
						check = 0;
						if (this.resourcesBorrowed[indexDeleted] == null) {
							System.out.println("There is no resource at that index.");
						} else {
							if (this.resourcesBorrowed[indexDeleted].isOverDue(today)) {
								System.out.println("As displayed above: This resource is overdue- " + this.resourcesBorrowed[indexDeleted].overdueCost + "$ is owed.");
							}
							this.resourcesBorrowed[indexDeleted] = null;
							if (resourcesBorrowed[0] == null && resourcesBorrowed[1] == null) {
								numResources = 0;
							} else {
								resourcesBorrowed[indexDeleted] = resourcesBorrowed[(numResources - 1)];
								System.out.println(resourcesBorrowed[indexDeleted]);
								resourcesBorrowed[(numResources - 1)] = null;
								numResources -= 1;
							}
						}
					} else {
						System.out.println("That index does not exist.");
						in.next();
					}
				} catch (IndexOutOfBoundsException e) {
					System.err.println("That index does not exist.");
				}
			} while (check == 1);
		}
	}

}
