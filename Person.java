package task_24;

/**
 * This is the person class which holds all the information to create a new
 * person object.
 * 
 * @author Duma
 *
 */
public class Person {
	// Instance variables used to create a new person.
	private String firstName;
	private String lastName;
	private String telNum;
	private String email;
	private String phyAdd;

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhyAdd() {
		return phyAdd;
	}

	public void setPhyAdd(String phyAdd) {
		this.phyAdd = phyAdd;
	}

	/**
	 * Person constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param telNum
	 * @param email
	 * @param phyAdd
	 */
	public Person(String firstName, String lastName, String telNum, String email, String phyAdd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNum = telNum;
		this.email = email;
		this.phyAdd = phyAdd;
	}

	/**
	 * toString displays the Person object data
	 */
	public String toString() {
		String output = "Name : " + firstName;
		output += "\nSurname: "  + lastName;
		output += "\nTelephone number: " + telNum;
		output += "\nEmail address: " + email;
		output += "\nPhysical address: " + phyAdd;
		return output;
	}
}