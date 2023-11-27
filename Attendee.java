import java.util.*;

public class Attendee
{
	private int id;
	private String firstName;
	private String lastName;
	private String companyName;
	private int companyNumber;
	private int tableNumber;
	private int seatNumber;
	
	public Attendee(int initId, String initFName, String initLName, String initCompany, int initCompNumb)
	{
		id = initId;
		firstName = initFName;
		lastName = initLName;
		companyName = initCompany;	
		companyNumber = initCompNumb;		
	}
	
	public String toString()
	{
		return ("\n\nID: " + id + ", Name: " + firstName + " " + lastName + ", Company: " + companyName + "\n");
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public int getCompanyNumber()
	{
		return companyNumber;
	}
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	public void setTable(int num)
	{
		tableNumber = num;
	}
	
	public int getTable()
	{
		return tableNumber;
	}

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
