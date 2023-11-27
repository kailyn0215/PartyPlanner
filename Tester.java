import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tester
{
	private int[] compCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	// driver class
	public static void main(String args[])
	{
		ArrayList<Attendee> guests = new ArrayList<Attendee>();
		ArrayList<String> comps = new ArrayList<String>();
		ArrayList<Attendee> unassigned = new ArrayList<Attendee>();
		//ArrayList<Attendee>[] tables = new ArrayList<Attendee>();
				
		int id;
		String firstName;
		String lastName;
		String company;
		String companyName;
		int x = 0;
		int y = 0;
		int maxTables = 10;
		int maxPeople = 90;
		
		try // try catch for the company list
		{
			File companies = new File("companies.txt");
			Scanner getCompanies = new Scanner(companies);
			System.out.print("Companies:\n\n");
			while (getCompanies.hasNextLine()) 
			{
				String arr2[] = getCompanies.nextLine().split(",");
				if (!arr2[0].equals("")) //skips the blank lines
				{										
					String cn = arr2[1];
					comps.add(cn);
					System.out.println("#" + (y + 1) + ": " + comps.get(y));
					y++;				
				}
			}
			getCompanies.close();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		try //try catch for the guest list
		{
			File people = new File("partyguests.txt");
			Scanner getPeople = new Scanner(people);
			System.out.print("Guests:\n\n");
			while (getPeople.hasNextLine()) 
			{
				String arr[] = getPeople.nextLine().split(",");
				id = Integer.parseInt(arr[0]);
				firstName = arr[2];
				lastName = arr[1];
				company = arr[3];
				companyName = comps.get(Integer.parseInt(company));						
				guests.add(new Attendee(id, firstName, lastName, companyName, Integer.parseInt(company)));
				System.out.print(guests.get(x));
				x++;
			}
			getPeople.close();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		x++;
		ArrayList<Attendee>[] tables = new ArrayList[maxTables];
		
		for (int i = 0; i < guests.size(); i++)
		{
			unassigned.add(guests.get(i));
		}
		
		for (int i = 0; i < maxTables; i++)
		{
			tables[i] = new ArrayList<Attendee>();
		}
		
		Party fun = new Party(maxPeople, maxTables);
			
		fun.assignTables(unassigned, tables);
		
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("Please select from the following options:\n1) Add guests\n2) Print roster by table\n3) Print roster by company\n4) Search for guest\n5) Quit\n\n");
			int input = 0;
			
			try
			{
				input = scan.nextInt();
			}
			catch (InputMismatchException e) {}
			
			if (input == 1)
			{			
				fun.addGuest(guests, x, comps);
			}
			else if (input == 2)
			{
				fun.printTable(tables);
			}
			else if (input == 3)
			{
				fun.printCompany(guests, comps);
			}
			else if (input == 4)
			{
				
			}
		}
	}
}
