package cpCalendar;

import java.io.IOException;
import java.util.Scanner;
import cpCalendar.printCal;
import cpCalendar.InvalidYearException;
import cpCalendar.InvalidMonthException;

public class Main {
	
	public static void clearScreen() throws IOException, InterruptedException {  
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    System.out.flush();  
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int year = 1990;
		String month = "January";
		int month_index = 0;
		String [] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		try {
			System.out.print("Enter the Year: ");
			year = scan.nextInt();
			if(year<1990||year>2019) {
				throw new InvalidYearException(year);
			}
			System.out.print("Enter the Month: ");
			month = scan.next();
			int check = 0;
			for(int i = 0;i<months.length;i++) {
				if(month.equals(months[i])) {
					check = 1;
					month_index = i;
					break;
				}
			}
			if(check == 0) {
				throw new InvalidMonthException(month);
			}
		}catch(InvalidYearException e) {
			System.out.print("Enter Year Again: ");
			year = scan.nextInt();
			try {
				System.out.print("Enter the Month: ");
				month = scan.next();
				int check = 0;
				for(int i = 0;i<months.length;i++) {
					if(month.equals(months[i])) {
						check = 1;
						month_index = i;
						break;
					}
				}
				if(check == 0) {
					throw new InvalidMonthException(month);
				}
			}catch(InvalidMonthException e1) {
				System.out.print("Enter Month Again: ");
				month = scan.next();
			}
		}catch(InvalidMonthException e) {
			System.out.print("Enter Month Again: ");
			month = scan.next();
		}
		int flag = 1;
		printCal p = new printCal(month, year);
		p.print(month_index, year);
		
		while(flag != 0) {
			System.out.print("Do you want to continue? (0/1) : ");
			flag = scan.nextInt();
			
			if(flag == 1) {
				System.out.println();
				System.out.print("Press a, s, d or w to toggle: ");
			}else {
				break;
			}
			char ch = scan.next().charAt(0);
			if (ch == 'w') {
				clearScreen();
				year = year - 1;
				//clearScreen();
				p.print(month_index,year);
			}else if(ch == 's') {
				clearScreen();
				year = year + 1;
				//clearScreen();
				p.print(month_index,year);
			}else if(ch == 'a') {
				clearScreen();
				if(month.equals("January")) {
					month_index = 11;
					year = year -1;
					p.print(month_index,year);
				}else {
					month_index = month_index - 1;
					p.print(month_index,year);
				}
			//	clearScreen();
			}else if(ch == 'd') {
				clearScreen();
				if(month.equals("December")) {
					month_index = 0;
					year = year +1;
					p.print(month_index,year);
				}else {
					month_index = month_index + 1;
					p.print(month_index,year);
				}
			}
		}
		System.out.println("\n\n\n***** Thanks for using!! *****\n***** Have a Nice Day!! *****");
		scan.close();
	}
}