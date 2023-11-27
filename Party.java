import java.util.*;

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
 	* Returns the maximum number of people that can go to the party.
	*/
	public int getMaxPpl()
	{
		return maxPpl;
	}
	/*
 	* Returns the maximum number of tables that are at the party.
	*/
	public int getMaxTables()
	{
		return maxTables;
	}
	/*
 	* Returns the maximum number of people per table, based off of maxppl and maxtables.
	*/
	public int getPerTable()
	{
		return perTable;
	}
	/*
 	* Assigns tables to each of the guests
  	*
   	* @param unassigned	arraylist of attendees who are not yet assigned to tables
    	* @param tables		the array of arraylists of tables
     	* @return 		no return value
	*/
	public void assignTables(ArrayList<Attendee> unassigned, ArrayList<Attendee>[] tables)
	{
		for (Attendee x : unassigned)
		{
			for (int i = 0; i < maxTables; i++)
			{
				if(checkTables(tables[i], x.getCompanyNumber(), i))
				{
					System.out.print(i);
					tables[i].add(x);
					x.setTable(i + 1);				
					break;
				}
			}
		}
	}
	/*
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
	/*
 	* Adds the guest the the list of guests (doesnt fully work yet, needs to be added to the arraylist + added to a table)
  	*
   	* @param guests		arraylist of attendees, to add new guest to
    	* @param x 		int value representing the id of the new guest
     	* @param comps		arraylist of companies to assign a company name to the guest
      	* @return 		no return value
	*/
	public void addGuest(ArrayList<Attendee> guests, int x, ArrayList<String> comps)
	{
		Scanner add = new Scanner(System.in);
		System.out.print("Please enter the name of the person who you would like to add: ");
		String arr[] = add.nextLine().split(" ");
		
		
		String fName = arr[0];
		String lName = arr[1];
		int id = x++;
		
		System.out.print("Please enter the company number of the person who you would like to add: ");

		int companyNumber = add.nextInt();
		String compName = comps.get(companyNumber); 
		
		//guests.add(id, fName, lName, compName, companyNumber);
	}
	/*
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
	/*
 	* Prints the list of attendees by company
  	*
   	* @param guests 	arraylist of all of the guests to print
    	* @param comps		arraylist of the names of all of the companies to arrange the guests in order
	*/
	public void printCompany(ArrayList<Attendee> guests, ArrayList<String> comps)
	{
		for(int i = 0; i < comps.size(); i++)
		{
			System.out.println(comps.get(i));
			for(Attendee x : guests)
			{
				if(x.getCompanyNumber() == i)
				{
					System.out.println(x.toString());
				}
			}
		}
	}
}
