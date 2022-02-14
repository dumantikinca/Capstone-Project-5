package task_24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//Software Engineering Task 24 - Capstone Project III.
//This task required the creation of a small project management system for structural engineering // firm called 'Poised'.
//This management system keeps track of the projects which the firm works on.
//@author Duma

public class Main {

 // Initializes the menu choice of the user for program use. 

 public int userChoice;

 // Initializes the project list to be used for the purposes of the program

 public static Project[] projectList = new Project[30];

 // Sets the counter for projects in the list to zero

 public static int proCount = 0;


 // Constructor for creating a new project

 public static void newProject() {

   // Adds all the project details for customer
   System.out.println("\nInput project information\n+++++++++++++++++++++++++++\n");

   String proType;
   String proPhysAdd;
   String proERF;
   double invoiceTotal = 0;
   String proDeadline;
   Scanner input = new Scanner(System.in);

   // Request project name from user
   System.out.print("Project name: ");
   String proName = input.nextLine();

   // Request bulding type and validates information from user
   while (true) {
     System.out.print("Building type (e.g. house): ");
     proType = input.nextLine();
     if (proType.matches("[a-zA-Z]+") && (proType != null && !proType.isEmpty())) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }
   // Request project physical address and validates information from user
   while (true) {
     System.out.print("Project physical address: ");
     proPhysAdd = input.nextLine();
     if (proPhysAdd != null && !proPhysAdd.isEmpty()) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }
   // Request project erf number and validates information from user
   while (true) {
     System.out.print("Project erf number: ");
     proERF = input.nextLine();
     if (proERF != null && !proERF.isEmpty()) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }


   // Request project deadline date and validates information from user
   while (true) {
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
     sdf.setLenient(false);
     System.out.print("Project deadline date (dd-mm-yyyy): ");
     proDeadline = input.nextLine();
     try {
       sdf.parse(proDeadline);
       break;
     } catch (Exception e) {
       System.out.println(proDeadline + " is an invalid date. Use correct date format and try again. ");
     }
   }

   
   // Request project total fee and validates information from user
   while (true) {
     try {
       System.out.print("Project total fee: R ");
       input = new Scanner(System.in);
       invoiceTotal = input.nextDouble();
       break;
     } catch (Exception e) {
       System.out.println("Invalid entry - this is a required field.");
     }
   }

   // Requests customer information from user
   System.out.println("\nInput customer information\n+++++++++++++++++++++++++++\n");
   String miscellaneous = input.nextLine();

   String customerFirstName;
   String customerLastName;
   String customerTelNum;
   String customerEmail;
   String customerPhyAdd;

   // Request customer first name and validates information from user
   while (true) {
     System.out.print("Customer first name: ");
     customerFirstName = input.nextLine();
     if (customerFirstName.matches("[a-zA-Z]+") && (customerFirstName != null && !customerFirstName.isEmpty())) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }

   // Request customer last name and validates information from user
   while (true) {
     System.out.print("Customer last name: ");
     customerLastName = input.nextLine();
     if (customerLastName.matches("[a-zA-Z]+") && (customerLastName != null && !customerLastName.isEmpty())) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }


  // Request customer telephone and validates information from user
   while (true)
   {
     try
     {
       System.out.print("Customer telephone: ");
       customerTelNum = input.nextLine();
       if (customerTelNum.matches("[0/+27]?[0-9]+") && (customerTelNum.length() >= 9 && customerTelNum.length() <= 12) && (customerTelNum != null && !customerTelNum.isEmpty())) {
       break;
       }
       else { 
       throw new Exception();
       }
     }
     catch (Exception e)
     {
     System.out.println("Invalid entry - this is a required field - make sure you have entered only digits and that the phone number is at least 9 but no more than 12 characters.");
     continue;
     }
   }


   // Request customer email and validates information from user

   while (true) {
     try
     {
       System.out.print("Customer email: ");
       customerEmail = input.nextLine();
       String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
               + "[a-zA-Z0-9_+&*-]+)*@"
               + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
               + "A-Z]{2,7}$";
       if (customerEmail.matches(emailRegex) && (customerEmail != null && !customerEmail.isEmpty())) { // if email is valid
           break; 
           }
       else
       { // email is not valid
           throw new Exception();
       }
     }
     catch (Exception e)
     {
         System.out.println("Invalid entry - this is a required field - please enter valid email, ie. michealjackson@hyperion.com");
         continue;
     }
   }


   
   // Request customer physical address and validates information from user
   while (true) {
     System.out.print("Customer physical address: ");
     customerPhyAdd = input.nextLine();
     if (customerPhyAdd != null && !customerPhyAdd.isEmpty()) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }


   // Requests contractor information from user
   System.out.println("\nInput contractor information\n+++++++++++++++++++++++++++\n");
 
   String contractorFirstName;
   String contractorLastName;
   String contractorTelNum;
   String contractorEmail;
   String contractorPhyAdd;

   // Request contractor first name and validates information from user
   while (true) {
     System.out.print("Contractor first name: ");
     contractorFirstName = input.nextLine();
     if (contractorFirstName.matches("[a-zA-Z]+") && (contractorFirstName != null && !contractorFirstName.isEmpty())) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }
   // Request contractor last name and validates information from user
   while (true) { 
     System.out.print("Contractor last name: ");
     contractorLastName = input.nextLine();
     if (contractorLastName.matches("[a-zA-Z]+") && (contractorLastName != null && !contractorLastName.isEmpty())) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }

   // Request contractor telephone number and validates information from user
   while (true) {
     try
     {
       System.out.print("Contractor telephone number: ");
       contractorTelNum = input.nextLine();
       if (contractorTelNum.matches("[0/+27]?[0-9]+") && (contractorTelNum.length() >= 9 && contractorTelNum.length() <= 12) && (contractorTelNum != null && !contractorTelNum.isEmpty())) {
       break;
       }
       else { 
       throw new Exception();
       }
     }
     catch (Exception e)
     {
     System.out.println("Invalid entry - this is a required field - make sure you have entered only digits and that the phone number is at least 9 but no more than 12 characters.");
     continue;
     }
   }


   // Request contractor email and validates information from user
 
   while (true) {
     try
     {
       System.out.print("Contractor email: ");
       contractorEmail = input.nextLine();
       String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
               + "[a-zA-Z0-9_+&*-]+)*@"
               + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
               + "A-Z]{2,7}$";
       if (contractorEmail.matches(emailRegex) && (contractorEmail != null && !contractorEmail.isEmpty())) { // if email is valid
           break; 
           }
       else
       { // email is not valid
           throw new Exception();
       }
     }
     catch (Exception e)
     {
         System.out.println("Invalid entry - this is a required field - please enter valid email, ie. michealjackson@hyperion.com");
         continue;
     }
   }

   // Request contractor physical address and validates information from user
   while (true) {
     System.out.print("Contractor physical address: ");
     contractorPhyAdd = input.nextLine();
     if (contractorPhyAdd != null && !contractorPhyAdd.isEmpty()) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }


   // Requests architect information from user
   System.out.println("\nInput architect information\n+++++++++++++++++++++++++++");
   

   String architectFirstName;
   String architectLastName;
   String architectTelNum;
   String architectEmail;
   String architectPhyAdd;

   // Request architect first name and validates information from user
   while (true) {
     System.out.print("Architect first name: ");
     architectFirstName = input.nextLine();
     if (architectFirstName.matches("[a-zA-Z]+") && (architectFirstName != null && !architectFirstName.isEmpty())) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }

   // Request architect last name and validates information from user
   while (true) {
     System.out.print("Architect last name: ");
     architectLastName = input.nextLine();
     if (architectLastName.matches("[a-zA-Z]+") && (architectLastName != null && !architectLastName.isEmpty())) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }
   

   // Request architect telephone number and validates information from user
   while (true) {
     try
     {
       System.out.print("Architect telephone: ");
       architectTelNum = input.nextLine();
       if (architectTelNum.matches("[0/+27]?[0-9]+") && (architectTelNum.length() >= 9 && architectTelNum.length() <= 12) && (architectTelNum != null && !architectTelNum.isEmpty())) {
       break;
       }
       else { 
       throw new Exception();
       }
     }
     catch (Exception e)
     {
     System.out.println("Invalid entry - this is a required field - make sure you have entered only digits and that the phone number is at least 9 but no more than 12 characters.");
     continue;
     }
   }

   // Request architect email address and validates information from user

   while (true) {
     try
     {
       System.out.print("Architect email: ");
       architectEmail = input.nextLine();
       String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
               + "[a-zA-Z0-9_+&*-]+)*@"
               + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
               + "A-Z]{2,7}$";
       if (architectEmail.matches(emailRegex) && (architectEmail != null && !architectEmail.isEmpty())) { // if email is valid
           break; 
           }
       else
       { // email is not valid
           throw new Exception();
       }
     }
     catch (Exception e)
     {
         System.out.println("Invalid entry - this is a required field - please enter valid email, ie. michealjackson@hyperion.com");
         continue;
     }
   }
   

   // Request architect physical address and validates information from user
   while (true) {
     System.out.print("Architect physical address: ");
     architectPhyAdd = input.nextLine();
     if (architectPhyAdd.matches("[a-zA-Z]+") && (architectPhyAdd != null && !architectPhyAdd.isEmpty())) {
       break;
     } else {
       System.out.println("Invalid entry - this is a required field.");
     }
   }

   //  New customer
   Person customer = new Person(
         customerFirstName, 
         customerLastName, 
         customerTelNum, 
         customerEmail, 
         customerPhyAdd
         );

   // New contractor
   Person contractor = new Person(
         contractorFirstName, 
         contractorLastName, 
         contractorTelNum, 
         contractorEmail, 
         contractorPhyAdd
         );

   // New architect
   Person architect = new Person(
         architectFirstName, 
         architectLastName, 
         architectTelNum, 
         architectEmail, 
         architectPhyAdd
         );

   // Set variable proStatus to "in Progress"
   String proStatus = "In Progress";

   // Adds a new project to the projectList
   projectList[proCount] = new Project(
         proName, 
         proType, 
         proPhysAdd, 
         proERF, 
         proDeadline, 
         proStatus, 
         invoiceTotal,
         customer, 
         contractor, 
         architect
         );

   // Writes the project additions and changes to projects.txt file
   writeProjectToFile(
         proName, 
         proType, 
         proPhysAdd, 
         proERF, 
         proDeadline, 
         proStatus, 
         invoiceTotal, 
         customerFirstName, 
         customerLastName, 
         customerTelNum, 
         customerEmail, 
         customerPhyAdd, 
         contractorFirstName, 
         contractorLastName, 
         contractorTelNum, 
         contractorEmail, 
         contractorPhyAdd, 
         architectFirstName, 
         architectLastName, 
         architectTelNum, 
         architectEmail, 
         architectPhyAdd
         );

   // Increments the project counter initially set to zero
   proCount += 1;
 }


  // Main method for running the application
 public static void main(String[] args) {
   int userChoice = 0;
           System.out.println("----------------------------------------");
           System.out.println("|   POISED PROJECT MANAGEMENT SYSTEM   |");  
           System.out.println("----------------------------------------");

   // Reads projects from projects.txt file
   projectFileRead();

   while (true) {

       try {
         Scanner input = new Scanner(System.in);

         System.out.println("\nMain Menu\n+++++++++++++++++++++++++++");
         // The mainMenu() method displays all the menu items for the main menu of the
         // system
         userChoice = mainMenu(input);

         switch (userChoice) {
           // 1 - Create new project (main menu option)
         case 1:
           // The newProject() method creates a new project
           newProject();
           break;
           // 2 - Update existing project (main menu option)
         case 2:
           
           System.out.println("\nSearch for project\n(Find project number or name under main menu option 4 *View all projects*)\n+++++++++++++++++++++++++++\n");
           String findProj = null;

           // Asks user to input the project name or ID of the project in question
           System.out.print("Enter project number or name of existing project to update: "); 
           findProj = input.next();

           // Loops through the list of projects
           for (int i = 0; i < projectList.length; i++) {
             // Checks if the project name or ID is valid
             if (projectList[i].getproName().equalsIgnoreCase(findProj)
                 || projectList[i].getproNumber().equalsIgnoreCase(findProj)) {   

               while (userChoice != 5) {
                 System.out.println("\nProject: " + projectList[i].getproNumber()
                     + "\n+++++++++++++++++++++++++++");
                 // Displays the menu items for the selected Project
                 userChoice = editProjectMenu(input);

                 switch (userChoice) {
                 case 1:
                 //  View Project
                   // Prints out the selected project
                   System.out.println(projectList[i]);
                   break;

                 case 2:
                 // 2.2 - Add Payment
                   System.out.println("\nAdd Payment\n+++++++++++++++++++++++++++");
                   // Displays the current invoice total and amount owed by the user
                   System.out.print("Invoice total: "
                       + projectList[i].fmt.format(projectList[i].getinvoiceTotal()));
                   System.out.print("\nAmount owed: "
                       + projectList[i].fmt.format(projectList[i].getInvoiceBalance()));

                   // Checks that the user inputs numbers and not letters
                   while (true) {
                     try {
                       input = new Scanner(System.in);

                       // Asks user to input a new payment amount
                       System.out.print("\nEnter payment amount: R ");
                       double userInfo = input.nextDouble();
                       double payment = userInfo;

                       // invoiceBalance is made up of invoiceBalance minus payment for the current project 
                       projectList[i].invoicePayment(payment);
                       break;

                     } catch (Exception e) {
                       System.out.println("Invalid entry. Please re-enter payment amount.");
                     }
                   }

                   // Prints out new balance amount
                   System.out.println("\nNew balance: "
                       + projectList[i].fmt.format(projectList[i].getInvoiceBalance()));
                   input.nextLine();
                   break;

                 case 3:
                   // Edit deadline
                   System.out.println("\nEdit deadline\n+++++++++++++++++++++++++++");
                   // Displays the current deadline
                   System.out.print("Current deadline: " + projectList[i].getproDeadline());

                   // Checks that the new date is in the correct format
                   while (true) {
                     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
                     sdf.setLenient(false);

                     // Asks user to input a new deadline
                     System.out.print("\nNew deadline (dd-mm-yyyy): ");
                     String proDeadline = input.nextLine();

                     try {
                       sdf.parse(proDeadline);
                       // Updates proDeadlineate() with the new user input
                       projectList[i].setproDeadline(proDeadline);
                       System.out.print("\nSuccessfully updated to " + proDeadline + "\n");
                       break;
                     } catch (Exception e) {
                       System.out.println(proDeadline + " is not a valid Date");
                     }
                   }
                   break;


                 case 4:
                   while (userChoice != 2) {
                     System.out.println("\nFinalise project\n+++++++++++++++++++++++++++");
                     // The projectFinalisationMenu() method displays all the menu items update the Project
                     // Status
                     userChoice = projectFinalisationMenu(input);

                     switch (userChoice) {
                     case 1:
                       // Sets the currently selected project status to "Finalized"
                       // and generates invoice if invBalance > 0
                       projectList[i].processFinal();
                       System.out.print(
                           "\nProject set to: " + projectList[i].getproStatus() + "\n");

                       if (projectList[i].getInvoiceBalance() > 0) {
                         projectList[i].getInvoiceBalance();

                         // If amount owed is more than 0 the program prints invoice to a text file
                         invoiceFileWrite(i);

                         // Writes the finalized project to complete.txt file
                         finalisedProjectFileWrite(i);

                       } else {
                         projectList[i].getInvoiceBalance();
                       }
                       break;

                     case 2:

                       break;

                     default:
                       System.out.println("Invalid selection. Please try again.");
                     }
                     break;
                   }
                   break;

                 case 5:
                   break;

                 default:
                   System.out.println("Invalid selection. Please try again.");
                 }
               }
               break;
             }
           }
           break;

         // Edit contact Details
         case 3:

           System.out.println("\nSearch for project\n(Find project number or name under main menu option 4 *View all projects*)\n+++++++++++++++++++++++++++");
 
           // Requests project name or number to search for project
           System.out.print("Enter project number or name pertaining to the customer's information that needs to be updated: "); 
           findProj = input.next();

           // Loops through the list of projects
           for (int i = 0; i < projectList.length; i++) {
             // Checks if the project name or number is valid
             if (projectList[i].getproName().equalsIgnoreCase(findProj)
                 || projectList[i].getproNumber().equalsIgnoreCase(findProj)) {

               while (userChoice != 4) {
                 // Person Contact Editing section
                 System.out.println("\nEdit contacts\n+++++++++++++++++++++++++++");
                 System.out.println("\nProject: " + projectList[i].getproNumber() + "\n");
                 userChoice = editPersonMenu(input);

                 switch (userChoice) {
                 case 1:
                   while (userChoice != 4) {
                     System.out.println(
                         "\nCustomer contact details\n+++++++++++++++++++++++++++");
                     // Menu items to update customer details
                     userChoice = editCustomerMenu(input);

                     // Switch menu statements for customer
                     customerSwitchStatement(userChoice, input, i);
                   }
                   break;

                 case 2:
                   while (userChoice != 4) {
                     System.out.println(
                         "\nContractor contact details\n+++++++++++++++++++++++++++");
                     // Menu items to update contractor details
                     userChoice = editContractorMenu(input);

                     // Switch menu statements for contractor
                     contractorSwitchStatement(userChoice, input, i);
                   }
                   break;

                 case 3:
                   while (userChoice != 4) {
                     System.out.println(
                         "\nArchitect contact details\n+++++++++++++++++++++++++++");
                     // Menu items to update architect details
                     userChoice = editArchitectMenu(input);

                     // Switch menu statement for architect
                     architectSwitchStatement(userChoice, input, i);
                   }
                   break;

                 case 4:
                   break;

                 default:
                   System.out.println("Invalid selection. Please try again.");
                 }
               }
               break;
             }
           }
           break;


         case 4:

           boolean noProjects = true;


             System.out.println("\nAll project list\n+++++++++++++++++++++++++++");

             // Loops through project list
             for (int i = 0; i < projectList.length; i++) {

               if (projectList[i] != null) {
                 noProjects = false;
                 // Prints out the full list of all projects
                 System.out.println("\n\nProject number:  " + projectList[i].getproNumber() + "\nProject name: "
                     + projectList[i].getproName() + "\nProject status: "
                     + projectList[i].getproStatus() + "\nBuilding type: "
                     + projectList[i].getproType() + "\nDeadline: "
                     + projectList[i].getproDeadline() + "\nTotal owed: "
                     + projectList[i].fmt.format(projectList[i].getInvoiceBalance()));
               }
             }
             if (noProjects == true) {
               System.out.println("No projects.");
             }
             break;

         case 5:
         //
           boolean noOverdue = true;
           System.out.println("\nOverdue project List\n+++++++++++++++++++++++++++");
           userChoice = mainMenu(input);
           // Loops through project list
           for (int i = 0; i < projectList.length; i++) {

             if (projectList[i] != null) {
               noOverdue = false;

               // Converts the input string date into date format
               Date date1 = new SimpleDateFormat("dd-MM-yyy").parse(projectList[i].getproDeadline());

               // Gets todays date
               Date date2 = new Date();

               // Compares the dates to see if proDeadline is before or after today's date
               if (date1.compareTo(date2) == -1 || date1.compareTo(date2) == 0) {
                 projectList[i].setOverdue(true);

                 // If the project is overdue program prints out information
                 System.out.println("\n\nProject number:  " + projectList[i].getproNumber() + "\nProject name: "
                     + projectList[i].getproName() + "\nProject status: "
                     + projectList[i].getproStatus() + "\nBuilding type: "
                     + projectList[i].getproType() + "\nDeadline: "
                     + projectList[i].getproDeadline() + "\nTotal owed: "
                     + projectList[i].fmt.format(projectList[i].getInvoiceBalance()));
               }
             }
           }
           if (noOverdue == true) {
             System.out.println("No overdue projects.");
           }
           break;
     
           // 6. incomplete projects
         case 6:
           boolean noIncomplete = true;

           System.out.println("\nIncomplete project list\n+++++++++++++++++++++++++++");
 
           // Loops through project list
           for (int i = 0; i < projectList.length; i++) {
             if (projectList[i] != null) {
               noIncomplete = false;

               // Checks if the status is finalized, if not then prints out the list
               if (projectList[i].isFinalised() == false) {
                 // If the project is completed program prints out information
                 System.out.println("\n\nProject number:  " + projectList[i].getproNumber() + "\nProject name: "
                     + projectList[i].getproName() + "\nProject status: "
                     + projectList[i].getproStatus() + "\nBuilding type: "
                     + projectList[i].getproType() + "\nDeadline: "
                     + projectList[i].getproDeadline() + "\nTotal owed: "
                     + projectList[i].fmt.format(projectList[i].getInvoiceBalance()));
               }
             }
           }
           if (noIncomplete == true) {
             System.out.println("No incomplete projects.");
           }
           break;



         // Exit the program
         case 7:
           
           System.out.println("\n\nGood, bye!");

           // Clear the current project.txt
           PrintWriter pw = new PrintWriter("projects.txt");
           pw.close();

           // Save the projects to projects.txt as well as changes. 
           for (int i = 0; i < projectList.length; i++) {

             if (projectList[i] != null) {
               writeProjectToFile(
                   projectList[i].getproName(), 
                   projectList[i].getproType(),
                   projectList[i].getproPhysAdd(), 
                   projectList[i].getproERF(),
                   projectList[i].getproDeadline(), 
                   projectList[i].getproStatus(),
                   projectList[i].getinvoiceTotal(), 
                   projectList[i].getCustomer().getFirstName(),
                   projectList[i].getCustomer().getLastName(), 
                   projectList[i].getCustomer().getTelNum(),
                   projectList[i].getCustomer().getEmail(),
                   projectList[i].getCustomer().getPhyAdd(),
                   projectList[i].getContractor().getFirstName(),
                   projectList[i].getContractor().getLastName(),
                   projectList[i].getContractor().getTelNum(),
                   projectList[i].getContractor().getEmail(),
                   projectList[i].getContractor().getPhyAdd(),
                   projectList[i].getArchitect().getFirstName(),
                   projectList[i].getArchitect().getLastName(),
                   projectList[i].getArchitect().getTelNum(), 
                   projectList[i].getArchitect().getEmail(),
                   projectList[i].getArchitect().getPhyAdd());
               }
             }
             System.exit(0);
             break;

           default:
             System.out.println("Invalid selection. Please try again.");
           }

         } catch (Exception e) { 
         System.out.println("Invalid selection. Please try again."); 
       }
     }
   }


 // Method creates a new file, writes and appends the completed project data to list
private static void finalisedProjectFileWrite(int i) {
 try {
   BufferedWriter myWriter = new BufferedWriter(new FileWriter("complete.txt", true));
   String projLine = projectList[i].toString();
   myWriter.write(projLine);
   myWriter.close();
   System.out.println("Saved project to complete.txt");

 } catch (IOException e) {
   System.out.println("An error occurred.");
   e.printStackTrace();
 }
}


  // Method creates a new file, writes and appends the invoice data to list
 private static void invoiceFileWrite(int i) {
   try {
     BufferedWriter myWriter = new BufferedWriter(new FileWriter("invoice.txt", true));
     String invLine = projectList[i].invoicePrintout();
     myWriter.write(invLine);
     myWriter.close();
     System.out.println("Saved invoice to invoice.txt");

   } catch (IOException e) {
     System.out.println("An error occurred.");
     e.printStackTrace();
   }
 }


  // This method reads the projects.txt to get all the info for each project
  // When it is not possible to convert a string in any numeric type (float, int, etc), this       // exception NumberFormatException is thrown.
 
 private static void projectFileRead() throws NumberFormatException {
   String[] projectElement = new String[22];
   try {
     BufferedReader br = new BufferedReader(new FileReader("projects.txt"));
     String line;
     // reads the file ccontent line by line
     while ((line = br.readLine()) != null) {
       // Splits the elements with comma
       projectElement = line.split(", ");
       projectList[proCount] = new Project(projectElement[0], projectElement[1], projectElement[2], projectElement[3], projectElement[4], projectElement[5],
           Double.parseDouble(projectElement[6]), new Person(projectElement[7], projectElement[8], projectElement[9], projectElement[10], projectElement[11]),
           new Person(projectElement[12], projectElement[13], projectElement[14], projectElement[15], projectElement[16]),
           new Person(projectElement[17], projectElement[18], projectElement[19], projectElement[20], projectElement[21]));
       proCount++;
     }
     br.close();
   } catch (IOException ioe) {
     System.err.println("IOException: " + ioe.getMessage());
   }
 }

 /**
  * Method writes a project with all required parameters to text file -
  * projects.txt
  * 
  * @param proName
  * @param proType
  * @param proPhysAdd
  * @param proERF
  * @param proDeadline
  * @param proStatus
  * @param invoiceTotal
  * @param customerFirstName
  * @param customerLastName
  * @param customerTelNum
  * @param customerEmail
  * @param customerPhyAdd
  * @param contractorFirstName
  * @param contractorLastName
  * @param contractorTelNum
  * @param contractorEmail
  * @param contractorPhyAdd
  * @param architectFirstName
  * @param architectLastName
  * @param architectTelNum
  * @param architectEmail
  * @param architectPhyAdd
  * 
  */

  
 private static void writeProjectToFile(
       String proName, 
       String proType, 
       String proPhysAdd, 
       String proERF,
       String proDeadline, 
       String proStatus, 
       double invoiceTotal, 
       String customerFirstName, 
       String customerLastName, 
       String customerTelNum,
       String customerEmail, 
       String customerPhyAdd, 
       String contractorFirstName, 
       String contractorLastName, 
       String contractorTelNum,
       String contractorEmail, 
       String contractorPhyAdd, 
       String architectFirstName, 
       String architectLastName, 
       String architectTelNum,
       String architectEmail, 
       String architectPhyAdd
       ) {
   // Writes the project to projects.txt file
   try {
     BufferedWriter myWriter = new BufferedWriter(new FileWriter("projects.txt", true));
     // Writes string items for the project
     myWriter.write(
       proName + ", " + 
       proType + ", " + 
       proPhysAdd + ", " + 
       proERF + ", " + 
       proDeadline + ", " + 
       proStatus + ", " + 
       invoiceTotal + ", " + 
       customerFirstName + ", " + 
       customerLastName + ", " + 
       customerTelNum + ", " + 
       customerEmail + ", " + 
       customerPhyAdd + ", " + 
       contractorFirstName + ", " + 
       contractorLastName + ", " + 
       contractorTelNum + ", " + 
       contractorEmail + ", " + 
       contractorPhyAdd + ", " + 
       architectFirstName + ", " + 
       architectLastName + ", " + 
       architectTelNum + ", " + 
       architectEmail + ", " + 
       architectPhyAdd
       );
     myWriter.newLine();
     myWriter.close();

   } catch (IOException e) {
     System.out.println("An error occurred.");
     e.printStackTrace();
   }
 }


  // mainMenu() method holds the Main menu options

 private static int mainMenu(Scanner input) {
   int userChoice;
   // Main Menu Options:
   System.out.print(
       "1. Create new project\n" + 
       "2. Update existing project\n" + 
       "3. Update contact details\n" + 
       "4. View all projects \n" +
       "6. View overdue projects\n" + 
       "5. View incomplete projects\n" + 
       "7. Exit\n" + 
       "Enter your selection: ");
   userChoice = input.nextInt();
   input.nextLine();
   return userChoice;
 }


  // editProjectMenu() method holds roject specific menu options that 
  // enable user to make updates on the project

 private static int editProjectMenu(Scanner input) {
   int userChoice;
   System.out.print("1 - View project\n"); 
   System.out.print("2 - Add payment\n");
   System.out.print("3 - Edit deadline\n"); 
   System.out.print("4 - Finalise project\n"); 
   System.out.print("5 - Exit\n");
   System.out.print("Enter your selection: ");
   userChoice = input.nextInt();
   input.nextLine();
   return userChoice;
 }


  // editPersonMenu method displays the edit person contact details 
  // menu items that enable a user to make updates to the contact
  // details of persons.
  

 private static int editPersonMenu(Scanner input) {
   int userChoice;
   System.out.print("1 - Edit customer\n");
   System.out.print("2 - Edit contractor\n");
   System.out.print("3 - Edit architect\n");
   System.out.print("4 - Back\n");
   System.out.print("Enter your selection: ");
   userChoice = input.nextInt();
   input.nextLine();
   return userChoice;
 }


  // editCustomerMenu() method displays the customer contact update menu

 private static int editCustomerMenu(Scanner input) {
   return editPersonInput(input);
 }


  // The editContractorMenu() method displays the contractor contact update menu

 private static int editContractorMenu(Scanner input) {
   return editPersonInput(input);
 }

 
  // The editArchitectMenu() method displays the architect contact update menu

 private static int editArchitectMenu(Scanner input) {
   return editPersonInput(input);
 }


  // projectFinalisationMenu() method displays the finalisation of project menu options 

 private static int projectFinalisationMenu(Scanner input) {
   int userChoice;
   System.out.print("1 - Mark as finalised \n");
   System.out.print("2 - Exit \n");
   System.out.print("Enter your selection: ");
   String inputChoice = input.nextLine();
   userChoice = Integer.valueOf(inputChoice);
   return userChoice;
 }


  // The editPersonInput() method displays the menu options for non 
  // specific contact input details for updating a person's contact
  // details

 private static int editPersonInput(Scanner input) {
   int userChoice;
   System.out.print("1 - Update telephone number\n");
   System.out.print("2 - Update email\n");
   System.out.print("3 - Update physical address\n");
   System.out.print("4 - Back\n");
   System.out.print("Enter your selection: ");
   String inputChoice = input.nextLine();
   userChoice = Integer.valueOf(inputChoice);
   return userChoice;
 }



 // customerSwitchStatement() method holds all the switch menu 
 // statements for editing the customer contact Details

 private static void customerSwitchStatement(int userChoice, Scanner input, int i) {
   switch (userChoice) {

     case 1:
       // Update telNum

       while (true) {
         try
         {
           System.out.print("Enter new customer telephone to update: ");
           String telNum = input.nextLine();
           if (telNum.matches("[0/+27]?[0-9]+") && (telNum.length() >= 9 && telNum.length() <= 12) && (telNum != null && !telNum.isEmpty())) {
           projectList[i].getCustomer().setTelNum(telNum);
           break;
           } else { 
           throw new Exception();
           }
         }
         catch (Exception e)
         {
         System.out.println("Invalid entry - this is a required field - make sure you have entered only digits and that the phone number is at least 9 but no more than 12 characters.");
         continue;
         }
       }
       break;


     case 2:

       // Update email
       while (true) {
         try
         {
           System.out.print("Enter new customer email to update: ");
           String email = input.nextLine();
           String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                   + "[a-zA-Z0-9_+&*-]+)*@"
                   + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                   + "A-Z]{2,7}$";
           if (email.matches(emailRegex) && (email != null && !email.isEmpty())) { // if email is valid
               projectList[i].getCustomer().setEmail(email);
               break; 
               }
           else
           { // email is not valid
               throw new Exception();
           }
         }
         catch (Exception e)
         {
             System.out.println("Invalid entry - this is a required field - please enter valid email, ie. michealjackson@hyperion.com");
             continue;
         }
       }
       break;


     case 3:
       // Update address
       while (true) {
         System.out.print("\nEnter new customer physical address to update: ");
         String phyAdd = input.nextLine();
         if (phyAdd != null && !phyAdd.isEmpty()) {
           projectList[i].getCustomer().setPhyAdd(phyAdd);
           break;
         } else {
           System.out.println("This is a required field.");
         }
       }
       break;

     case 4:
       break;

     default:
       System.out.println("Invalid selection. Please try again.");
   }
 }

 // The contractorSwitchStatement() method holds all the switch menu // statements for editing the contractor contact Details

 private static void contractorSwitchStatement(int userChoice, Scanner input, int i) {
   switch (userChoice) {

     case 1:
       // Update telNum

       while (true) {
         try
         {
           System.out.print("Enter new contractor telephone to update: ");
           String telNum = input.nextLine();
           if (telNum.matches("[0/+27]?[0-9]+") && (telNum.length() >= 9 && telNum.length() <= 12) && (telNum != null && !telNum.isEmpty())) {
           projectList[i].getContractor().setTelNum(telNum);
           break;
           } else { 
           throw new Exception();
           }
         }
         catch (Exception e)
         {
         System.out.println("Invalid entry - this is a required field - make sure you have entered only digits and that the phone number is at least 9 but no more than 12 characters.");
         continue;
         }
       }
       break;
       


     case 2:
     
       // Update email

       while (true) {
         try
         {
           System.out.print("Enter new contractor email to update: ");
           String email = input.nextLine();
           String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                   + "[a-zA-Z0-9_+&*-]+)*@"
                   + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                   + "A-Z]{2,7}$";
           if (email.matches(emailRegex) && (email != null && !email.isEmpty())) { // if email is valid
               projectList[i].getContractor().setEmail(email);
               break; 
               }
           else
           { // email is not valid
               throw new Exception();
           }
         }
         catch (Exception e)
         {
             System.out.println("Invalid entry - this is a required field - please enter valid email, ie. michealjackson@hyperion.com");
             continue;
         }
       }
       break;
      



     case 3:
       // Update phyAdd

       while (true) {
         System.out.print("Enter new contractor phyAdd to update: ");
         String phyAdd = input.nextLine();
         if (phyAdd != null && !phyAdd.isEmpty()) {
           projectList[i].getContractor().setPhyAdd(phyAdd);
           break;
         } else {
           System.out.println("This is a required field.");
         }
       }
       break;


     case 4:
       break;

     default:
       System.out.println("Invalid selection. Please try again.");
   }
 }


  // The architectSwitchStatement() method holds all the switch menu // cases for editing the architect contact Details

 private static void architectSwitchStatement(int userChoice, Scanner input, int i) {
   switch (userChoice) {

     case 1:
       // Update telNum

       while (true) {
         try
         {
           System.out.print("Enter new architect telephone to update: ");
           String telNum = input.nextLine();
           if (telNum.matches("[0/+27]?[0-9]+") && (telNum.length() >= 9 && telNum.length() <= 12) && (telNum != null && !telNum.isEmpty())) {
           projectList[i].getArchitect().setTelNum(telNum);
           break;
           } else { 
           throw new Exception();
           }
         }
         catch (Exception e)
         {
         System.out.println("Invalid entry - this is a required field - make sure you have entered only digits and that the phone number is at least 9 but no more than 12 characters.");
         continue;
         }
       }
       break;


     case 2:
       // Update email

       while (true) {
         try
         {
           System.out.print("Enter new architect email to update: ");
           String email = input.nextLine();
           String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                   + "[a-zA-Z0-9_+&*-]+)*@"
                   + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                   + "A-Z]{2,7}$";
           if (email.matches(emailRegex) && (email != null && !email.isEmpty())) { // if email is valid
               projectList[i].getArchitect().setEmail(email);
               break; 
               }
           else
           { // email is not valid
               throw new Exception();
           }
         }
         catch (Exception e)
         {
             System.out.println("Invalid entry - this is a required field - please enter valid email, ie. michealjackson@hyperion.com");
             continue;
         }
       }
       break;



     case 3:
       // Update address
       while (true) {
         System.out.print("Enter new architect physical address to update: ");
         String phyAdd = input.nextLine();
         if (phyAdd != null && !phyAdd.isEmpty()) {
           projectList[i].getArchitect().setPhyAdd(phyAdd);
           break;
         } else {
           System.out.println("This is a required field.");
         }
       }
       break;

     case 4:
       break;

     default:
       System.out.println("Invalid selection. Please try again.");
   }
 }


}