import java.util.Arrays;
import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a due dates for assessments in a course
Author:  Linda Crane and Andrew Palmer
Course: F2018 - CST8130
Lab Section: 312
Data members:  

Methods:                                             
         

*************************************************************************************************************/

public class DueDates {
	private MyDate[] dueDates;
	
	public DueDates() {
		dueDates = new MyDate[10];
	}
	
	public DueDates(int max) {
		dueDates = new MyDate[max];
	}
	
	public boolean inputDueDates(Scanner in) {
		for (int i= 0; i < dueDates.length; i++) {
			dueDates[i] = new MyDate();
			dueDates[i].inputDate(in);
		}
		return true;
	}
	
	public void addOne () {
		//*****  write the code for this method here
		for(MyDate i : dueDates) {
			i.addOne();
		}
	}
	
	public String toString() {
		//*****  write the code for this method here
		System.out.println("The due dates are:");
		int num = 1;
		for(int i = 0; i < dueDates.length; i++) {
			System.out.println(num + ": " + dueDates[i]);
			num++;
		}
		return "";
	}
}

