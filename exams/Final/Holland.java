public class Holland extends Country
{
	public static void main (String [] args)
	{
		System.out.println("\n\n\n");
		Country country1 = new Country();
		Country country2 = new Holland();
		System.out.print(country1 + "   " + country2 + "   ");
		country1 = country2;
		System.out.print(country1);
		System.out.println("\n\n\n");
	}

	public String toString ( )
	{
		return "Holland";
	}
}

class Country
{
	public String toString ( )
	{
		return "Country";
	}
}
