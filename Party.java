import java.util.*;
/**
* Party file!! holds max people, tables, and people per table.
* Also assigns, checks, and prints tables
* Allows user to search + add guests to the list
* @author kailyn0215
* @date 11/27/2023
*/
public class Party
{
	private int maxPpl;
	private int maxTables;
	private int perTable;
	
	public Party(int initMaxPpl, int initMaxTables)
	{
		maxPpl = initMaxPpl;
		maxTables = initMaxTables;
		perTable = maxPpl/maxTables;
	}
	/*
 	* @return		the maximum number of people that can go to the party.
	*/
	public int getMaxPpl()
	{
		return maxPpl;
	}
	/*
 	* @return		the maximum number of tables that are at the party.
	*/
	public int getMaxTables()
	{
		return maxTables;
	}
	/*
 	* @return		the maximum number of people per table, based off of maxppl and maxtables.
	*/
	public int getPerTable()
	{
		return perTable;
	}
	/**
 	* Assigns tables to each of the guests
  	*
   	* @param unassigned	arraylist of attendees who are not yet assigned to tables
   	* @param tables		the array of arraylists of tables
    	* @return 		no return value
	*/
	public void assignTables(ArrayList<Attendee> unassigned, ArrayList<Attendee>[] tables)
	{	
		for(int j = 0; j < maxTables; j++)
		{
			tables[j].clear();
		}
		
		/*Iterator<Attendee> iterator = unassigned.iterator();
		while(iterator.hasNext())
		{
			for (int i = maxTables - 1; i >= 0; i--)
			{
				if(checkTables(tables[i], iterator.next().getCompanyNumber(), i))
				{
					System.out.print(i);
					tables[i].add(iterator.next());
					//unassigned.remove(iterator.next()); //removes from the end of the list instead of the beginning - hope is that it stops from skipping attendees
					iterator.next().setTable(i - 1);
					iterator.remove();				
					break;
				}
			}
		}*/
		for (Attendee x : unassigned)
		{
			for (int i = 0; i < maxTables; i++)
			{
				if(checkTables(tables[i], x.getCompanyNumber(), i))
				{
					//System.out.print(i);
					tables[i].add(x);
					//unassigned.remove(x); couldnt figure this out :(
					x.setTable(i + 1);				
					break;
				}
			}
		}
	}
	/**
 	* Checks the tables to see if an attendee is eligible to sit there
  	*
   	* @param tables 	arraylist of a certain table
    	* @param num		int that holds the value of the attendees company
 	* @param i		int that holds which table the attendee is being placed at
   	* @return 		boolean representation of if the attendee can be sat at the current table
	*/
	public boolean checkTables(ArrayList<Attendee> tables, int num, int i)
	{
		if (tables.size() == perTable)
		{
			return false;
		}
		for (Attendee x : tables)
		{
			if (x.getCompanyNumber() == num)
			{
				return false;
			}
		}
		return true;
	}
	/**
 	* Adds the guest the the list of guests (doesnt fully work yet, needs to be added to the arraylist + added to a table)
  	*
   	* @param unassigned	arraylist of attendees, to add new guest to
   	* @param x 		int value representing the id of the new guest
 	* @param comps		arraylist of companies to assign a company name to the guest
	* @return 		no return value
	*/
	public void addGuest(ArrayList<Attendee> unassigned, ArrayList<Attendee> guests, int x, ArrayList<String> comps)
	{
		Scanner add = new Scanner(System.in);
		System.out.print("Please enter the name of the person who you would like to add: ");
		String arr[] = add.nextLine().split(" ");
		
		String fName = arr[0];
		String lName = arr[1];
		int id = x++;
		
		System.out.print("Please enter the company number of the person who you would like to add: ");

		int companyNumber = add.nextInt();
		companyNumber--;
		String compName = comps.get(companyNumber); 
		
		unassigned.add(new Attendee(id, fName, lName, compName, companyNumber));
		guests.add(new Attendee(id, fName, lName, compName, companyNumber));
	}
	/**
 	* Prints the tables from 1 - the max amount of tables
  	*
   	* @param tables 	array of arraylist of tables, used to access the different tables + print them
    	* @return 		no return value
	*/
	public void printTable(ArrayList<Attendee>[] tables)
	{
		for(int i = 0; i < maxTables; i++)
		{
			System.out.println("Table #" + (i + 1) + ":\n" + tables[i]);
		}

	}
	/**
 	* Prints the list of attendees by company
  	*
   	* @param guests 	arraylist of all of the guests to print
    	* @param comps		arraylist of the names of all of the companies to arrange the guests in order
     	* @return 		no return value
	*/
	public void printCompany(ArrayList<Attendee> guests, ArrayList<String> comps)
	{
		for(int i = 0; i < comps.size(); i++)
		{
			System.out.println(comps.get(i) + ":\n\n");
			for(Attendee x : guests)
			{
				if(x.getCompanyNumber() == i)
				{
					if(x.getTable() == 0)
					{
						System.out.println("Sorry! We were unable to provide a table for " + x.getName());
					}
					else
					{
						System.out.println(x.toString() + "Table: " + x.getTable());
					}					
				}
			}
		}
	}
	/**
 	* searches for the users input from the arraylist guests
  	*
   	* @param guests		arraylist of all of the guests to search through
    	* @param tables		array of arraylist of the tables that the guests are sat at
     	* @return 		no return value
	*/
	public void searchGuest(ArrayList<Attendee> guests, ArrayList<Attendee>[] tables)
	{
		Scanner n = new Scanner(System.in);
		System.out.print("Please enter the full name of the person you wish to search for: ");
		String name = n.nextLine();
		for(Attendee x : guests)
		{
			if(x.getName().equalsIgnoreCase(name))
			{
				System.out.println(x);
				if(x.getTable() == 0)
				{
					System.out.println("Sorry! We were unable to provide a table for " + x.getName() + ".\n");
				}
				else
				{
					System.out.println("Table: " + x.getTable() + "\n");
					// + ", Chair: " + x.getSeat(tables)); havent gotten the chair yet :(
				}
			}
		}
	}
}
