package cpCalendar;

public class InvalidYearException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidYearException(int year) {
		System.out.println("Invalid year: "+year);
	}
	
}
