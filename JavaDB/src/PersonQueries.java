// File Name: PersonQueries.java
// PreparedStatements used by the Address Book application.
// Gregory Delpe
// CSc221

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries
{
    private static final String URL = "jdbc:derby:addressbook;create=true";
    private static final String USERNAME = "deitel";
    private static final String PASSWORD = "deitel";
    private Connection connection; // manages connection
    private PreparedStatement selectAllPeople;
    private PreparedStatement selectPeopleByLastName;
    private PreparedStatement insertNewPerson;
    private PreparedStatement deletePerson;
    private PreparedStatement updatePerson;
    private PreparedStatement selectPeopleByState;

    // constructor
    public PersonQueries()
    {
        try
        {
        	//Driver driver = new oracle.jdbc.OracleDriver();
        	//DriverManager.registerDriver(driver);
        	//DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        	//Class.forName("org.apache.derby.jdbc.ClientDriver");

            connection =
                    DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // create query that selects all entries in the AddressBook
            selectAllPeople =
                    connection.prepareStatement("SELECT * FROM Addresses");

            // create query that selects entries with a specific last name
            selectPeopleByLastName = connection.prepareStatement(
                    "SELECT * FROM Addresses WHERE LastName = ?");

            // create insert that adds a new entry into the database
            insertNewPerson = connection.prepareStatement(
                    "INSERT INTO Addresses " +
                            "(FirstName, LastName, Email, PhoneNumber,State) " +
                            "VALUES (?, ?, ?, ?,?)");
            // delete current entry
            deletePerson = connection.prepareStatement("DELETE FROM Addresses "
            		+ "WHERE Addressid = ?");

            // selects entries with a specific state
            selectPeopleByState = connection.prepareStatement(
                    "SELECT * FROM Addresses WHERE State = ?");

            // update current entry
            updatePerson = connection.prepareStatement("UPDATE Addresses SET "
            		+ "FirstName = ?, "
            		+ "LastName = ?, "
            		+ "Email = ?, "
            		+ "PhoneNumber = ?, "
            		+ "State = ? "
            		+ "WHERE Addressid = ?");
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    // select all of the addresses in the database
    public List< Person > getAllPeople()
    {
        List< Person > results = null;
        ResultSet resultSet = null;

        try
        {
            // executeQuery returns ResultSet containing matching entries
            resultSet = selectAllPeople.executeQuery();
            results = new ArrayList< Person >();

            while (resultSet.next())
            {
                results.add(new Person(
                        resultSet.getInt("addressID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("State")));
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
                close();
            }
        }

        return results;
    }

    // select person by last name
    public List< Person > getPeopleByLastName(String name)
    {
        List< Person > results = null;
        ResultSet resultSet = null;

        try
        {
            selectPeopleByLastName.setString(1, name); // specify last name

            // executeQuery returns ResultSet containing matching entries
            resultSet = selectPeopleByLastName.executeQuery();

            results = new ArrayList< Person >();

            while (resultSet.next())
            {
                results.add(new Person(resultSet.getInt("addressID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("State")));
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();

            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    // select person by state
    public List< Person > getPeopleByState(String state)
    {
        List< Person > results = null;
        ResultSet resultSet = null;

        try
        {
            selectPeopleByState.setString(1, state); // specify last state

            // executeQuery returns ResultSet containing matching entries
            resultSet = selectPeopleByState.executeQuery();

            results = new ArrayList< Person >();

            while (resultSet.next())
            {
                results.add(new Person(resultSet.getInt("addressID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("State")));
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();

            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    // add an entry
    public int addPerson(
            String fname, String lname, String email, String num, String state)
    {
        int result = 0;

        // set parameters, then execute insertNewPerson
        try
        {
            insertNewPerson.setString(1, fname);
            insertNewPerson.setString(2, lname);
            insertNewPerson.setString(3, email);
            insertNewPerson.setString(4, num);
            insertNewPerson.setString(5, state);
            //insertNewPerson.setString(5, state);

            // insert the new entry; returns # of rows updated
            result = insertNewPerson.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    // delete current entry
    public void deletePerson(String id)
    {

        try
        {
            deletePerson.setString(1, id);
            deletePerson.executeUpdate();

        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
        }

    }

    // update current entry
    public void updatePerson(String firstName, String lastName,
    		String email, String phoneNumber, String state, String id)
    {
        try
        {
            //updatePerson.setString(1, attribute);
            updatePerson.setString(1, firstName);
            updatePerson.setString(2, lastName);
            updatePerson.setString(3, email);
            updatePerson.setString(4, phoneNumber);
            updatePerson.setString(5, state);
            updatePerson.setString(6, id);

            updatePerson.executeUpdate();

        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            close();
        }

    }

    // close the database connection
    public void close()
    {
        try
        {
            connection.close();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}
