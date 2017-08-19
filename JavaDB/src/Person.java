// File Name: Person.java
// Person class that represents an entry in an address book. 3 public class Person
// Gregory Delpe
// CSc221

public class Person
{
    private int addressID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String state;

    // constructor
    public Person()
    {
    }

    // constructor
    public Person(int addressID, String firstName, String lastName,
                  String email, String phoneNumber, String state)
    {
        setAddressID(addressID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setState(state);
    }

    // sets the addressID
    public void setAddressID(int addressID)
    {
        this.addressID = addressID;
    }

    // returns the addressID
    public int getAddressID()
    {
        return addressID;
    }

    // sets the firstName
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    // returns the first name
    public String getFirstName()
    {
        return firstName;
    }

    // sets the lastName
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    // returns the last name
    public String getLastName()
    {
        return lastName;
    }

    // sets the email address
    public void setEmail(String email)
    {
        this.email = email;
    }

    // returns the email address
    public String getEmail()
    {
        return email;
    }

    // sets the phone number
    public void setPhoneNumber(String phone)
    {
        this.phoneNumber = phone;
    }

    // returns the phone number
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    // sets the state
    public void setState(String state)
    {
    	this.state = state;
    }

    // returns the state
    public String getState()
    {
    	return state;
    }
}
