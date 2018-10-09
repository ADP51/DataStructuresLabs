package Default;

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

	public MyDate(MyDate x){
		this.day = x.day;
		this.month = x.month;
		this.year = x.year;
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
		if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10) {
			if (this.day == 31) {
				this.month++;
				this.day = 1;
			} else {
				this.day++;
			}

		} else if (this.month == 2) {
			if (this.day == 29) {
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
		} else if (this.month == 12) {
			this.year++;
			if (this.day == 31) {
				this.month = 1;
				this.day = 1;
			} else {
				this.day++;
			}
		}
	}

	public boolean isEqual(MyDate param) {
		//check to see if the Object passed has the same values as th Object this method is called on
		if(param.year == this.year) {
			if(param.month == this.month) {
				if(param.day == this.day) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isGreaterThan(MyDate param) {
		//check if year is less than or equal to the year of the object your calling on
		if(param.year <= this.year) {
			//check if the date is in the same year else return true if the year is less than
			if(param.year == this.year) {
				//check to see if the month is less than or equal to
				if (param.month <= this.month) {
					//if the month is equal to then we need to compare the day within the month else return true
					if (param.month == this.month) {
						//check to see if the day of the month is lower than the object called upon and return true / false
						if (param.day < this.day) {
							return true;
						} else {
							return false;
						}
					}
					//this is the return if the month is less than within the same year
					return true;
				}
			}
			//this is the return if the year is less than the object called upon
			return true;
		}
		//return false if the year is not less than or equal to
		return false;
	}

}

