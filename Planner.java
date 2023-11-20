import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Planner
{
	private int[] compCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	// driver class
	public static void main(String args[])
	{
		ArrayList<Attendee> guests = new ArrayList<Attendee>();
		//ArrayList<Attendee> tables = new ArrayList<Attendee>();
		String tables[][];
		
		int id;
		String name;
		String company;
		int x = 0;
		int maxTables = 10;
		int maxPeople = 10;
		
		try 
		{
			File people = new File("partyguests.txt");
			Scanner myReader = new Scanner(people);
			while (myReader.hasNextLine()) 
			{
				//String person = myReader.nextLine();
				String arr[] = myReader.nextLine().split(",");
				//uniqueid, last, first, compID
				id = Integer.parseInt(arr[0]);
				name = arr[2] + " " + arr[1];
				company = arr[3];
				//companyCount(company);						
				guests.add(new Attendee(id, name, company));
				System.out.print(guests.get(x));
				x++;
				//guests.add(person.split());
			}
			myReader.close();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		for (int i = 0; i < maxTables; i++)
		{
			if(tables[i][j].equals("") && ) // need to add smth do check if the seat is free and if there is no one else from their company sitting there
			{
				
			}
		}
	}
	
	private int comp;
	
	/*public boolean companyCount(String company)
	{
		comp = Integer.parseInt(company);
		compCount[comp]++; // adds one count to the # of people from each company
		if(compCount[comp] > 10)
		{
			return false;
		}
		return true;
	}*/
}
/*
 * Attendee Info: 1 company rep per table - if more than 10 people from a company tell the user
 * 10 tables
 * 10 seats per table
 * 90 people preregister
 * 10 people manually
 * 
 * Sort by company + iterate through this way
 * 
 * Table could be collection type?
 * 
 * Name
 * Company
 * Table Number
 * Seat Number
 * Role/Title
*/
