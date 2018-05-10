public class Representative implements Comparable
{
	private String district;
	private String firstName;
	private String lastName;
	private int birthMonth;
	private int birthDay;
	private int birthYear;
	private String party;
	private int firstElected;

	public Representative(String d, String f, String l, int bm, int bd, int by, String p, int e)
	{

		district = d;
		firstName = f;
		lastName = l;
		birthMonth = bm;
		birthDay = bd;
		birthYear = by;
		party = p;
		firstElected = e;


	}

	public String getDistrict()
	{
		return district;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public int getBirthMonth()
	{
		return birthMonth;
	}

	public int getBirthDay()
	{
		return birthDay;
	}

	public int getBirthYear()
	{
		return birthYear;
	}

	public String getParty()
	{
		return party;
	}

	public int getFirstElected()
	{
		return firstElected;
	}


	public int compareTo(Object other)
	{
		return 0;
	}


	public String toString()
	{
		return String.format("  %-20s%-25s  %2d  %2d%6d  %-14s%6d",district,firstName + " " + lastName,birthMonth,birthDay,birthYear,party,firstElected);
	}
}
