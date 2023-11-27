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
	
	public int getMaxPpl()
	{
		return maxPpl;
	}
	
	public int getMaxTables()
	{
		return maxTables;
	}
	
	public int getPerTable()
	{
		return perTable;
	}
	
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
	
	public void printTable(ArrayList<Attendee>[] tables)
	{
		for(int i = 0; i < maxTables; i++)
		{
			System.out.println("Table #" + (i + 1) + ":\n" + tables[i]);
		}
	}
	
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
