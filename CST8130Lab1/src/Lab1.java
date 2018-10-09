import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class is the method main for Lab 1 
Author:  Linda Crane and Andrew Palmer
Course: F2018 - CST8130
Lab Section:
                                             
         

*************************************************************************************************************/


public class Lab1 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);

		int max = 0;

		do {
			do {
				System.out.println("How many assessments in this course - must be greater than 0?");
				if (keyboard.hasNextInt()) {
					max = keyboard.nextInt();
					if(max < 0) {
						System.out.println("Invalid input, please enter a number of due dates you want to create:");

					}
				} else {
					System.out.println("Invalid input, please enter a number of due dates you want to create:");
					keyboard.next();
				}
			} while (max == 0 || max < 0);
			DueDates a = new DueDates(max);
			a.inputDueDates(keyboard);
			System.out.println(a);
			a.addOne();
			System.out.println("The due dates with one day added are:");
			System.out.println(a);
			System.out.println("Do you wish to continue? y/n");
		} while (!keyboard.next().equals("n"));

	}
}

