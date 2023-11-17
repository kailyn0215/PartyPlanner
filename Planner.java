import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Planner
{
	// driver class
	public static void main(String args[])
	{
		ArrayList<Attendee> guests = new ArrayList<Attendee>();
		ArrayList<Attendee> tables = new ArrayList<Attendee>();
		
		int id;
		String name;
		String company;
		int x = 0;
		
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
				Attendee person = new Attendee(id, name, company);
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
		
	}
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
