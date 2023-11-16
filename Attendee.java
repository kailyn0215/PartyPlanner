public class Attendee
{
	private int id;
	private String name;
	private String company;
	
	public Attendee(int initId, String initName, String initCompany)
	{
		id = initId;
		name = initName;
		company = initCompany;
	}
	
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
	
	public String split(String person)
	{
		
	}
}
