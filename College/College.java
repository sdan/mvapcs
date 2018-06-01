/**
 * College.java
 * College object that is a node in Binary Search Tree
 * @author Surya Dantuluri
 * @version 1.0
 * @since 5/31/2018
 */

public class College implements Comparable
{
	private String collegeName;
	private String city;
	private String state;
	private int tuition;
	private int year;
	private int enrolled;
	private double grad;

	public College(String n, String c, String s, int t, int y, int e, double g)
	{
		collegeName = n;
		city = c;
		state = s;
		tuition = t;
		year = y;
		enrolled = e;
		grad = g;
	}

	public String getName()
	{
		return collegeName;
	}

	public String getCity()
	{
		return city;
	}

	public String getState()
	{
		return state;
	}

	public int getTuition()
	{
		return tuition;
	}

	public int getYear()
	{
		return year;
	}

	public int getEnrollment()
	{
		return enrolled;
	}

	public Double getGraduationRate()
	{
		return grad;
	}


	public int compareTo(Object other)
	{
		return collegeName.compareTo(((College)other).getName());
	}


	public String toString()
	{
		return String.format("%-20s%-20s%-10s%-10d%5d   %-10.2f",collegeName, city, state, tuition, enrolled, grad);
	}
}
