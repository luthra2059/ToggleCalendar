package cpCalendar;

public class InvalidMonthException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMonthException(String month) {
		System.out.println("Invalid Month: "+month);
	}
}
