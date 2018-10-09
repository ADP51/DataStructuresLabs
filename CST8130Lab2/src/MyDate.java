import java.io.FileReader;
import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a simple date by keeping day, month and year information.   Leap years are NOT
               accommodated in this class.
Author:  Linda Crane and Andrew Palmer
Course: F2018 - CST8130
Lab Section: 312
Data members:  day : int - value between 1 and 31 inclusive (depending on value in month)
               month: int - value between 1 and 12 inclusive
               year: int - positive value
Methods: default constructor - sets date to Jan 1, 2018
         toString (): String - prints date in year/month/day format
         inputDate(Scanner): boolean - reads a valid date from the Scanner parameter and returns through
                                       boolean success or not
         addOne(): void - adds one to the day field and then adjusts month and year as needed.                                              
         

*************************************************************************************************************/
public class MyDate {
		private int day = 1;
		private int month = 1;
		private int year = 2018;
		
		public MyDate() {
		}
		
		public String toString() {   return new String ("" + year + "/" + month + "/" + day);
		}



		
		public boolean inputDate(Scanner in) {
			month = 0;
			day = 0; 
			year = 0;
			do {
					
				System.out.print ("Enter month - between 1 and 12: ");
				if (in.hasNextInt())
					this.month = in.nextInt();
				else {
					System.out.println ("Invalid month input");
					in.next();
				}
			} while (this.month <= 0 || this.month > 12);
			
			do {
				
				System.out.print ("Enter day - between 1 and 31: ");
				if (in.hasNextInt())
					this.day = in.nextInt();
				else {
					System.out.println ("Invalid day input");
					in.next();
				}
			} while (this.day <= 0 || this.day > 31 || (this.month == 2 && this.day > 29) || (this.day > 30 && (this.month == 9 ||this.month == 4 ||this.month == 6 ||this.month == 11) ) );
			
			do {
				System.out.print ("Enter year: ");
				if (in.hasNextInt())
					this.year = in.nextInt();
				else {
					System.out.println ("Invalid day input");
					in.next();
				}
			} while (this.year <= 0);
				
			return true;		
		}

	public void addOne() {
		// *********    write the code for this method here  **************
		if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
			if (this.day == 31) {
				this.month++;
				this.day = 1;
			} else {
				this.day++;
			}

		} else if (this.month == 2) {
			if (this.day == 28) {
				this.month++;
				this.day = 1;
			} else {
				this.day++;
			}

		} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			if (this.day == 30) {
				this.month++;
				this.day = 1;
			} else {
				this.day++;
			}
		}
	}
		
}

