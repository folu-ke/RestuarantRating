package project2;

public class Inspection {
	public Inspection (Date date, int score, String violation, String risk) throws IllegalArgumentException {
		if (date == null || (score < 0 && score > 100)) {
			String message = "Invalid date or score or both.";
			throw new IllegalArgumentException(message);
			
		}
		
	}

}
