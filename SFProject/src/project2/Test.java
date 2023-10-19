
package project2;
import java.util.*;
import java.io.*;
/**
 * 
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args - textLine a line of text to be
	 * passed
	 * Splits the given line of a CSV file according to commas and double quotes
	 * (double quotes are used to surround multi-word entries so that they may
	 * contain commas) 
	 * @author CSV 
	 * @return an Arraylist object containing all individual entries
	 * found on that line 7
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//if (args.length == 0 ) {
		//	System.err.println("Usage Error: the program expects file name as an argument.\n");
		//	System.exit(1);
		//}
		
		File csvFile = new File("src/SF_restaurant_scores_full.csv"); 
		if (!csvFile.exists()){
			System.err.println("Error: the file "+csvFile.getAbsolutePath()+" does not exist.\n");
			System.exit(1);
		}
		if (!csvFile.canRead()){
			System.err.println("Error: the file "+csvFile.getAbsolutePath()+
											" cannot be opened for reading.\n");
			System.exit(1);
		}
		
		//open the file for reading 
		Scanner inCsv = null; 
		
		
		try {
			inCsv = new Scanner (csvFile ) ;
		} catch (FileNotFoundException e) {
			System.err.println("Error: the file "+csvFile.getAbsolutePath()+
											" cannot be opened for reading.\n");
			System.exit(1);
		}
		
		//read the content of the file 
		String line = null; 
		Scanner parseLine = null; 

		while (inCsv.hasNextLine()) {
			try { 
				line = inCsv.nextLine(); 
				parseLine = new Scanner(line);
				System.out.println(splitCSVLine(line));
			}
			catch (NoSuchElementException ex ) {
				//caused by an incomplete or miss-formatted line in the input file
				System.err.println(line);
				continue; 	
			}
			try {
				// 
			}
			catch (IllegalArgumentException ex ) {
				//ignore this exception and skip to the next line 
			}
		}
		
		
		Scanner userInput  = new Scanner (System.in ); 
		String userValue = "";
		
		// ask about do loop
		do {
			System.out.println("Enter your search query or \"quit\" to stop:" );
			//get value of from the user 
			userValue = userInput.nextLine();
			if (!userValue.equalsIgnoreCase("quit")) { 
				String[] userValues = userValue.split(" ");
				String firstValue = userValues[0];
				String secondValue = userValues[1];
				
				if (firstValue.equalsIgnoreCase("name")) {
					secondValue = "0"; // do some lookup, maybe do a lookup function
				}
				
				else if (secondValue.equalsIgnoreCase("zip")) {}
				
				else {
					System.out.println("This is not a valid query. Try again.");
	
				
				
				
	
		}
			}
		}while (!userValue.equalsIgnoreCase("quit")); 
		
		userInput.close();
	}

	public static ArrayList<String> splitCSVLine(String textLine) {

		if (textLine == null)
			return null;

		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer();
		char nextChar;
		boolean insideQuotes = false;
		boolean insideEntry = false;
		// iterate over all characters in the textLine
		for (int i = 0; i < lineLength; i++) {
			nextChar = textLine.charAt(i);
			// handle smart quotes as well as regular quotes
			if (nextChar == '"' || nextChar == '\u201C' || nextChar == '\u201D') {
				// change insideQuotes flag when nextChar is a quote
				if (insideQuotes) {
					insideQuotes = false;
					insideEntry = false;
				} else {
					insideQuotes = true;
					insideEntry = true;
				}
			} else if (Character.isWhitespace(nextChar)) {
				if (insideQuotes || insideEntry) {
					// add it to the current entry
					nextWord.append(nextChar);
				} else { // skip all spaces between entries
					continue;
				}
			} else if (nextChar == ',') {
				if (insideQuotes) { // comma inside an entry
					nextWord.append(nextChar);
				} else { // end of entry found
					insideEntry = false;
					entries.add(nextWord.toString());
					nextWord = new StringBuffer();
				}
			} else {
				// add all other characters to the nextWord
				nextWord.append(nextChar);
				insideEntry = true;
			}
		}
		// add the last word ( assuming not empty )
		// trim the white space before adding to the list
		if (!nextWord.toString().equals("")) {
			entries.add(nextWord.toString().trim());
		}
		return entries;

	}
	
	}
