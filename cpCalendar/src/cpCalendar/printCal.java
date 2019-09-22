package cpCalendar;

import java.util.Calendar;
import java.util.StringTokenizer;

public class printCal {
	int year;
	String month;
	printCal(String month, int year){
		this.month = month;
		this.year = year;
	}
	void print(int month_index, int year){
		 	int Y = year;
		 	int M = month_index;
		 	Calendar cal = Calendar.getInstance();
		 	cal.set(Calendar.DATE, 1);
		 	cal.set(Calendar.MONTH, M);
		 	cal.set(Calendar.YEAR, year);
		 	StringTokenizer s = new StringTokenizer(cal.getTime().toString());
		 	String s1 = s.nextToken();
		 	int startDayOfMonth = 0;
		 	String[] arr = {"Sun",  "Mon", "Tue", "Wed", "Thu", "Fri",  "Sat"};
		 	for(int i=0;i<arr.length;i++) {
		 		if(arr[i].equals(s1)) {
		 			startDayOfMonth = i;
		 			break;
		 		}
		 	}
	        int spaces = startDayOfMonth;
	        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September","October", "November", "December"};
	            int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	            if  ((((Y % 4 == 0) && (Y % 100 != 0)) ||  (Y % 400 == 0)) && M == 1)
	                days[M] = 29;
	            System.out.println("          "+ months[M] + " " + Y);
	            System.out.println("_____________________________________");
	            System.out.println("   Sun  Mon Tue   Wed Thu   Fri  Sat");
	               spaces = (spaces)%7;
	            for (int i = 0; i < spaces; i++)
	                System.out.print("     ");
	            for (int i = 1; i <= days[M]; i++) {
	                System.out.printf(" %3d ", i);
	                if (((i + spaces) % 7 == 0) || (i == days[M])) System.out.println();
	            }
	            System.out.println();   
	}
}
