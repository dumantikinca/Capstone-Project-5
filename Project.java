package task_24;

import java.text.*;
import java.time.LocalDate;


/**
 * This is the project class which holds all the information to create a new
 * project object.
 * 
 * @author Duma
 *
 */
public class Project {
	// Attributes - Fields - Properties
	private static String string;
	private String proNumber;
	private String proName;
	private String proType;
	private String proPhysAdd;
	private String proERF;
	private String proDeadline;
	private String proStatus;
	private static String invoiceNumber;
	private double invoiceTotal;
	private double invoiceBalance = 0;
	private double payment = 0;
	private static int num = 100;
	private static int counter = 100;
	public LocalDate currentDate = LocalDate.now();
	public NumberFormat fmt = NumberFormat.getCurrencyInstance();
  private boolean finalised = false;
	private boolean overdue = false;
  private Person customer;
	private Person contractor;
	private Person architect;

	// Getters and Setters
	public String getproNumber() {
		return proNumber;
	}

	public String getproName() {
		return proName;
	}

	public String getproType() {
		return proType;
	}

	public String getproPhysAdd() {
		return proPhysAdd;
	}

	public String getproERF() {
		return proERF;
	}

	public String getproDeadline() {
		return proDeadline;
	}

	public void setproDeadline(String proDeadline) {
		this.proDeadline = proDeadline;
	}

	public String getproStatus() {
		return proStatus;
	}

	public void setproStatus(String proStatus) {
		this.proStatus = proStatus;
	}

	public boolean isFinalised() {
		return finalised;
	}

	public void setFinalised(boolean finalised) {
		this.finalised = finalised;
	}

	public double getinvoiceTotal() {
		return invoiceTotal;
	}

	public double getInvoiceBalance() {
		return invoiceBalance;
	}

	public Person getCustomer() {
		return customer;
	}

	public Person getContractor() {
		return contractor;
	}

	public Person getArchitect() {
		return architect;
	}

	public void setOverdue(boolean overdue) {
	this.overdue = overdue;
	}



	/**
	 * Elements required for the creation of new project
	 * 
	 * @param proName
	 * @param proType
	 * @param proPhysAdd
	 * @param proERF
	 * @param proDeadline
	 * @param proStatus
	 * @param invoiceTotal
	 * @param customer
	 * @param contractor
	 * @param architect
	 */
	public Project(String proName, String proType, String proPhysAdd, String proERF, String proDeadline,
			String proStatus, double invoiceTotal, Person customer, Person contractor, Person architect) {
		string = "";
		this.proName = proName;
		this.proType = proType;
		this.proPhysAdd = proPhysAdd;
		this.proERF = proERF;
		this.proDeadline = proDeadline;
		this.proStatus = proStatus;
		this.invoiceTotal = invoiceTotal;
		this.invoiceBalance = invoiceTotal;
		num++;
    // Creates project num
		proNumber = string + num; 
		counter++;
    // Creates invoice number
    invoiceNumber = "INV//" + counter; 
		this.customer = customer;
		this.contractor = contractor;
		this.architect = architect;
    // Creates project name if project name is empty
		createproName(); 
	}

	/**
	 * If the project name is empty then customproName() will generate one
	 * combining structureType + customerLastName.
	 */
	public void createproName() {
		if (proName.isEmpty()) {
			this.proName = getproType() + " " + customer.getLastName();
		}
	}

	/**
	 * This is used to make a payment by checking the invoice balance and less the
	 * payment input
	 * 
	 * @param payment
	 */
	public void invoicePayment(double payment) {
		this.invoiceBalance = invoiceBalance - payment;
	}
	/**
	 * The currentDate() method gets today's date
	 * 
	 * @return
	 */
	public LocalDate currentDate() {
		LocalDate date = LocalDate.now();
		date = LocalDate.now();
		return date;
	}

	/**
	 * The processFinal() method finalizes the project and adds the date
	 */
	public void processFinal() {
		setFinalised(true);
		setproStatus("Finalised");
	}


	/**
	 * String inv() method is used to print out the invoice
	 * 
	 * @return
	 */
	public String invoicePrintout() {
		String output = invoiceNumber;
		output += "\n+++++++++++++++++++++++++++";
		output += "\nDate: " + currentDate;
		output += "\nTo: " + customer.getFirstName() + " " + customer.getLastName();
		output += "\nTelephone number: " + customer.getTelNum();
		output += "\nEmail address: " + customer.getEmail();
		output += "\nPhysical address: " + customer.getPhyAdd();
		output += "\nProject reference\n+++++++++++++++++++++++++++";
		output += "\nProject number: " + proNumber;
		output += "\nProject name: " + proName;
		output += "\nProject status: " + proStatus;
		output += "\n+++++++++++++++++++++++++++\n\n";
		output += "\nTotal owed: " + invoiceBalance;
		output += "\n+++++++++++++++++++++++++++\n\n";
		return output;
	}


	/**
	 * toString method displays the Project summary when viewing it and also prints to
	 * completed-project.txt when project is finalised
	 */
	public String toString() {
		String output = "\nProject number: " + proNumber + "\n+++++++++++++++++++++++++++";
		output += "\nProject name: " + proName;
		output += "\nProject status: " + proStatus;
		output += "\nBuilding type: " + proType;
		output += "\nProject address: " + proPhysAdd;
		output += "\nProject erf: " + proERF;
		output += "\nProject deadline: " + proDeadline;
		output += "\nInvoice number: " + invoiceNumber;
		output += "\nInvoice total: " + fmt.format(invoiceTotal);
		output += "\nTotal owed: " + invoiceBalance;
		output += "\n\nCustomer information\n+++++++++++++++++++++++++++";
		output += "\n" + customer;
		output += "\n\nContractor information\n+++++++++++++++++++++++++++";
		output += "\n" + contractor;
		output += "\n\nArchitect information\n+++++++++++++++++++++++++++-";
		output += "\n" + architect + "\n\n";
		return output;
	}

}