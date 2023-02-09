package userpackage;

public class User {
  // Member Variables
  protected String name;
  protected String email;
  protected String phone;

  // Constructor
  public User(String n, String e, String p) {
    name = n;
    email = e;
    phone = p;
  }

  // Default Constructor
  public User() {
    name = "N/A";
    email = "N/A";
    phone = "N/A";
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  // Setters 
  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}