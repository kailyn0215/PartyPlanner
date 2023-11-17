import java.util.*;

public class Attendee
{
	private int id;
	private String name;
	private String company;
	private String person;
	
	private String[] companies = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"};
	private int[] compCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	public Attendee(int initId, String initName, String initCompany)
	{
		id = initId;
		name = initName;
		company = initCompany;
	}
	
	/*public Attendee(String people)
	{
		person = people;
	}*/
	
	public String toString()
	{
		return ("\n\nID: " + id + ", Name: " + name + ", Company: " + company + "\n");
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	public String companyName()
	{
		for (int x = 0; x < companies.length; x++)
		{
			if(Integer.parseInt(company) == x)
			{
				return companies[x];
			}
		}
		return "ERROR";
	}
	
	/*public void split()
	{
		String[] splitPerson = person.split(",", 5);
		id = Integer.parseInt(splitPerson[1]);
		name = splitPerson[3] + " " + splitPerson[2];
		company = splitPerson[4];
	}*/
}
