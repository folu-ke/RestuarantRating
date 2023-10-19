package project2;
import java.util.ArrayList;


public class Restaurant implements Comparable<Restaurant>{
	private String name, zip, address, phone;
	private ArrayList<Inspection> listInspection = new ArrayList<Inspection> ();
	/**
	 * This constructor sets the name and zip code of a restaurant.
	 * @param name
	 * @param zip
	 * @throws IllegalArgumentException if name is an empty string or 
	 * zip is not exactly five digits or address is an empty string or null or
	 * phone does not indicate a phone number.
	 */
	public Restaurant (String name, String zip) throws IllegalArgumentException {
		if (name == null || name.strip().isEmpty()) { 
			throw new IllegalArgumentException ("Name can not be empty string."); 
		}
		if (zip.length() != 5) { 
			throw new IllegalArgumentException ("Zip code must have five (5) digits."); 
		}
		this.name = name;
		this.zip = zip;
		
	}
	/**
	 * This constructor sets name and zip code of a restaurant using the first constructor.
	 * It also sets the address and phone number of a restaurant.
	 * @param address
	 * @param phone
	 * @throws IllegalArgumentException for same reason as 1st constructor
	 */
	public Restaurant(String name, String zip, String address, String phone) throws IllegalArgumentException {
		this(name, zip);
		if (phone.length() != 11) {
			throw new IllegalArgumentException ("Phone number must have eleven (11) digits."); 
		}
		this.address = address;
		this.phone = phone;
	}
	/**
	 * This method is used to add inspections to a restaurant instance.
	 * @param inspection 
	 */
	public void addInspection(Inspection inspection) throws IllegalArgumentException {
		if (inspection == null) { throw new IllegalArgumentException("Inspection must not be null."); }
		listInspection.add(inspection);
	}
	@Override
	/**
	 *
	 */
	public int compareTo(Restaurant anotherRestaurant) {
		int nameComparison = this.name.compareToIgnoreCase(anotherRestaurant.getName());
		int zipComparison = this.zip.compareToIgnoreCase(anotherRestaurant.getZip());
		if (nameComparison == 0) { return zipComparison; }
		else { return zipComparison; }
	}
	@Override
	/**
	 *
	 */
	public boolean equals (Object object) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof Color))
//			return false;
//		Color other = (Color) obj;
//		if (hexValue == null) {
//			if (other.hexValue != null)
//				return false;
//		}
//			else if (!hexValue.equalsIgnoreCase(other.hexValue))
//				return false;
//			return true;
//		}
//		
		return false;	
	}
	@Override
	/**
	 * This function prints the restaurant object in this format:
	 * 
	 */
	public String toString () {
		return "";
	}
	/**
	 * @return name of the restaurant
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return zip code/postal code of the restaurant
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @return address of the restaurant
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return phone number of the restaurant
	 */
	public String getPhone() {
		return phone;
	}
}
	
