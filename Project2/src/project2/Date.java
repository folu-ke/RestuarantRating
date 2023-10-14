package project2;
import java.lang.String;
import org.apache.commons.lang3.Range;



/**
 * The Date class allows input as a string in the formats MM/DD/YYYY or MM/DD/YY
 * or as date parameters (month, day, year). 
 * Throws 
 * @author  Mofoluwake Adesanya
 * @version 10/3/2023
 */
public class Date implements Comparable<Date>{
	// fields for saving parts of the date
	private int day, month, year;
	/**
	 * This constructor takes a date string and check 
	 * @param date
	 * @throws IllegalArgumentException
	 */
	public Date( String date ) throws IllegalArgumentException {		
		parse(date);
		Date(month, day, year);
		
		String dateRgxA = "[0-1][1-2]/[0-3][0-1]/[0-2][0-5]";   // YY
		String dateRgxB = "[0-1][1-2]/[0-3][0-1]/20[0-2][0-5]"; // YYYY
		// check year first
		if ((date.matches(dateRgxA))|| (date.matches(dateRgxB))) {
			try {
				parse(date);
				// Check February first
				if ( month == 2 ){ 
					String tempYr;
					if ( inRange(year, 0, 25) ) {
						// change year to 20XX for leap year operation
						tempYr = "20" + year;
						year = Integer.parseInt(tempYr);
					}
					// check leap year, check day 
					if ( isLeapYear(year) ) {
						if (day > 29) { throw new IllegalArgumentException(message2); }
					}
					else {
						if (day > 28) {	throw new IllegalArgumentException(message2); }
					}
				} 
			}
		// invalid year
			catch (Exception e){ throw new IllegalArgumentException(message2); }			
		}
		else { throw new IllegalArgumentException(message2); }
	}
		
	public Date (int month, int day, int year) throws IllegalArgumentException{
		String message2 = "This date is not valid.";
		if ( !(inRange(month, 0, 12)) || !(inRange(day, 0, 31)) || !(inRange(year, 2000, 2025))) 
		{ 	throw new IllegalArgumentException(message2); }
		// Check February first
		if ( month == 2 ){ 
			// if leap year, check day 
			if ( isLeapYear(year) ) {
				if (day > 29) { throw new IllegalArgumentException(message2); }
			}
			else {
				if (day > 28) {	throw new IllegalArgumentException(message2); }
			}
		}
		else {
			int[] monthDay30 = {4, 6, 9, 11};
			
		}
		parse(toString());
	}

	/**
	 * @return the day
	 */
	private int getDay() {
		return this.day;
	}

	/**
	 * @return the month
	 */
	private int getMonth() {
		return this.month;
	}

	/**
	 * @return the year
	 */
	private int getYear() {
		return this.year;
	}
	/**
	 * The function checks if the given year is a leap year. 
	 * This is important for the month February and is only 
	 * called when checking dates with month "02".
	 * Mathematically, a leap year is a multiple of 400 and 
	 * a multiple of 4 but not 100.
	 * @param int year
	 * @return true if year is a leap year 
	 * 		   false otherwise
	 */
	private static boolean isLeapYear(int year) {
		// divisible by 400? Leap year!
		if (year % 400 == 0) return true;
		// else: divisible by 4 but not 100? 
		// Leap year!
		if ((year % 4 == 0) && (year % 100 != 0))
			return true;
		// False if no condition is met
		return false;
	}
	/**
	 * This function checks if a number is between a specified inclusive range.
	 * @param int number : number to check for
	 * @param int lower  : lower bound of range
	 * @param int upper : upper bound of range
	 * @return true if number is in range [lower, upper] : inclusive
	 */
	public boolean inRange(int number, int lower, int upper) {
		return (number >= lower && number <= upper);
	}
	/**
	 * This function parses the date string to extract month, date and year
	 * and saves each part of it into Date class's month, date and year values.
	 * @param String date from Date(String) constructor
	 */
	public void parse(String date) {
		String[] userValues = date.split("/");
		this.month = Integer.parseInt(userValues[0]);
		this.day = Integer.parseInt(userValues[1]);
		this.year = Integer.parseInt(userValues[2]);
	}
	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		// research how to do this
		return this.compareToIgnoreCase(o);
	}
	/**
	 * This function prints the date in the format MM/DD/YYYY.
	 * If month or/and date are single digits, they are printed as 0M and 0D 
	 * respectively. If year is in format YY, it is printed as 20YY
	 */
	@Override
	public String toString () {
		String MM, DD, YYYY;
		if ( month < 10 )	  MM = "0" + month;
		else if ( day < 10 )  DD = "0" + day;
		else if ( inRange(year, 0, 25) )
			YYYY = "20" + year;	
		else 
			MM = "" + month;
			DD = "" + day;
			YYYY = "" + year;
		return MM + "/" + DD + "/" + YYYY;
	}

} }
