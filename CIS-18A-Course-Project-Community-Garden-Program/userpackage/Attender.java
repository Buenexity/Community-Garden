package userpackage;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Attender extends User {
  private Date time;
  private String arrival;
  private String[] donation;


  //Constructor
  public Attender(String n, String e, String p, Date t, String a) {
    super(n, e, p);
    this.time = t;
    this.arrival = a;
  }

  //Default Constructor
  public Attender() {
    super("N/A", "N/A", "N/A");
    this.time = new Date();
    this.arrival = "N/A";
  }

  public void transfer(String arr[]) {
    this.donation = arr;
  }

public void printAttender() {

  //Formats Date object in Year-Month-Day format
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 

  //Print Basic User Info
  System.out.println();
  System.out.println("Name: " + getName());
  System.out.println("Email: " + getEmail());
  System.out.println("Phone: " + getPhone());
  
  //Formats the Date object to Year-Month-Day format
  
  System.out.println("Date: " + dateFormat.format(time)); 

  //Print Arrival Time
  System.out.println("Arrival Time: " + arrival);
  
  //Print Donation-List
  DonationList();
}

  public void DonationList() {
    if (donation != null) {
      for (int i = 0; i < donation.length; i++) {
        System.out.println("Donation " + (i + 1) + " : " + donation[i]);
      }
    } else {
      System.out.println("No donation available");
    }
  }

  // Accessors (Getters)
  public Date getTime() {
    return time;
  }

  public String getArrival() {
    return arrival;
  }

  public String[] getDonation() {
    return donation;
  }

  // Mutators (Setters)
  public void setTime(Date time) {
    this.time = time;
  }

  public void setArrival(String arrival) {
    this.arrival = arrival;
  }

  public void setDonation(String[] donation) {
    this.donation = donation;
  }


  public void SetFile()
  {
  //Try block tests for file-erros
  try {
       //formats-Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //Object writes to words.txt
        FileWriter fw = new FileWriter("words.txt", true);
        //Prints line to wherever FileWriter object points to
        PrintWriter pw = new PrintWriter(fw);

       //Outputs member variables to words.txt
        pw.println();
    
        pw.println("Name: " + getName());
    
        pw.println("Email: " + getEmail());
    
        pw.println("Phone: " + getPhone());
    
        pw.println("Date: " + dateFormat.format(time)); 
    
        pw.println("Arrival Time: " + arrival);

        
        if (donation != null) {
            for (int i = 0; i < donation.length; i++) {
                pw.println("Donation " + (i + 1) + " : " + donation[i]);
            }
        } else {
            pw.println("No donation available");
        }

        //CLoses file objects
        pw.close();
        fw.close();
    //In case of error
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}