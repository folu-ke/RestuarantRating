package project2;
import java.util.ArrayList;


public class Restaurant {
	private String name, zip, address, phone;
	private ArrayList<Inspection> listInsp = new ArrayList<Inspection> ();
	/**
	 * @param name
	 * @param zip
	 * @throws IllegalArgumentException if name is an empty string or 
	 * zip is not exactly five digits or address is an empty string or null or
	 * phone does not indicate a phone number.
	 */
	public Restaurant (String name, String zip) throws IllegalArgumentException {
		this.name = name;
		this.zip = zip;
	}
	/**
	 * @param address
	 * @param phone
	 * @throws IllegalArgumentException for same reason as 1st constructor
	 */
	public Restaurant(String name, String zip, String address, String phone) throws IllegalArgumentException {
		Restaurant(name, zip);
		this.address = address;
		this.phone = phone;
	}
	public void addInspection(Inspection inspect) {
		listInsp.add(inspect);
	}
}
	
