import java.util.*;
/**
* Attendee class - takes id, fname, lname, company, and company #
* lets guests be printed + gives access to their id, name, company, table, and seat
* @author kailyn0215
* @date 11/27/2023
*/
public class Attendee
{
	private int id;
	private String firstName;
	private String lastName;
	private String companyName;
	private int companyNumber;
	private int tableNumber;
	private int seatNumber;
	/**
 	* @param initId 	id number
  	* @param initFName	the guests first name
   	* @param initLName	the guests last name
    	* @param initCompany	the name of the company
     	* @param initCompNumb 	the number of the company (easy access)
	*/
	public Attendee(int initId, String initFName, String initLName, String initCompany, int initCompNumb)
	{
		id = initId;
		firstName = initFName;
		lastName = initLName;
		companyName = initCompany;	
		companyNumber = initCompNumb;		
	}
	/**
 	* @return 		returns string for the guest
	*/ 
	public String toString()
	{
		return ("\n\nID: " + id + ", Name: " + firstName + " " + lastName + ", Company: " + companyName + "\n");
	}
	/**
 	* @return 		returns int for id
	*/ 
	public int getId()
	{
		return id;
	}
	/**
 	* @return 		returns string for the guest name
	*/ 
	public String getName()
	{
		return firstName + " " + lastName;
	}
	/**
 	* @return 		returns int for the compnumber
	*/ 
	public int getCompanyNumber()
	{
		return companyNumber;
	}
	/**
 	* @return 		returns string for the compname
	*/ 
	public String getCompanyName()
	{
		return companyName;
	}
	/**
 	* sets int for the table number
  	* @return 		no return value
	*/ 
	public void setTable(int num)
	{
		tableNumber = num;
	}
	/**
 	* @return 		returns int for the table #
	*/ 
	public int getTable()
	{
		return tableNumber;
	}
	/**
 	* @return 		returns int for the seat #
	*/ 
	public int getSeat(ArrayList<Attendee>[] tables, int maxTables)
	{
		for(int i = 0; i < maxTables; i++)
		{
			int j = tables[i].indexOf(id);
			if(j > -1)
			{
				return i + 1;
			}
		}
		return seatNumber;
	}
}
