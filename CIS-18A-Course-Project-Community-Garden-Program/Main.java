import userpackage.Attender;
import userpackage.User;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.io.PrintStream;
//import java.io.FileOutputStream;

class Main {
  public static void main(String[] args) {

    String[] arr; // Array to hold donation contents
    int track; // Size of donation list

    // Get User Information
    System.out.println("\n\nWelcome to the Community Garden");

    // Enter General Information:
    System.out.println("\n\nCan you please enter your contact information: ");
    String name = "";
    String pn = "";
    String email = "";

    // Scanner Object used to gather basic information
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Name: ");
    name = input.nextLine();
    System.out.print("Enter Phone Number: ");
    pn = input.nextLine();
    System.out.print("Enter Email Address: ");
    email = input.nextLine();

    // Access User constructor
    User member = new User(name, pn, email);

    // Flag variable to navigate code
    int flag = 0;
    Attender person = null;
    Date Appointment = null;
    do {
      System.setOut(System.out);
      // Menu Option
      System.out.println("\n Choose your option:");
      System.out.println("1. Schedule an appointment");
      System.out.println("2. Make a donation");
      System.out.println("3. Output Appointment to file");
      System.out.println("4.  Exit");
      flag = input.nextInt();

      // Option 1 : Create an Appointment
      if (flag == 1) {
        person = new Attender(); // Attender Object created

        // Appointment Range
        System.out.println("\nThe Garden is Open from: ");
        System.out.println("8:00 AM – 8:00 PM, Monday – Friday");
        System.out.println("8:00 AM – 5:00 PM, Saturday");
        System.out.println("\nPlease select your date in numbered format from a 1-Year Span");

        // Variable types for Appointment
        int day, month, year;
        String time;

        // User input for date
        System.out.print("Enter Day: ");
        day = input.nextInt();
        System.out.print("Enter Month (1-12): ");
        month = input.nextInt();
        System.out.print("Enter Year: ");
        year = input.nextInt();
        input.nextLine();
        System.out.print("Enter Time (#:## PM/AM): ");
        time = input.nextLine();

        // Date object
        Appointment = new Date(year - 1900, month - 1, day);

        // Formates the Date object in Y-M-D format
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Day1 = dayFormat.format(Appointment);

        // Outputs appointment Date w/out time
        System.out.println("The following Date was assigned : " + Day1);

        // Attender person = new Attender(name,pn,email,Appointment,time);
        person.setName(name);
        person.setPhone(pn);
        person.setEmail(email);
        person.setTime(Appointment);
        person.setArrival(time);

        System.out.println("\nThank you for creating an appointment");
      }

      // Option 2: Donation
      if (flag == 2) {

        // List of Possible Donations form User
        System.out.println("\nThe community garden accepts many types of donations: ");
        System.out.println("(*) Monetary donations");
        System.out.println("(*) Voluntary Labor");
        System.out.println("(*) Gardening material/Equipment/supplies");

        // Ask user for the amount of donations
        System.out.println("How many items/Services from the list of possible donations would you like to donate? ");
        track = input.nextInt(); // Varaible for donation amount
        input.nextLine();
        arr = new String[track]; // Donation Array
        int result = 0;

        // Do-while loop inputs contents into array
        do {
          System.out.print("Enter the donation/services:");
          arr[result] = input.nextLine();
          result++;
        } while (result != track);

        // Transfer array list to object Attender
        person.transfer(arr);
      }

      if (flag == 3) {
        if (Appointment != null) {
          System.out.println("Here is your recipt:");
          person.printAttender();
          person.SetFile();
         System.out.println("You can create another Appointment to add to the file:");
        }
      }
      // Option 3: Exit out of Menu
    } while (flag != 4);

    System.out.println("Goodbye");

  }

}