/**
 * College.java
 * Representative object stored in ListNode which is part of
 * Singly Linked List.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 5/14/2018
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

	public Double graduationRate()
	{
		return grad;
	}


	public int compareTo(Object other)
	{
		return 0;
	}


	public String toString()
	{
		return String.format("  %-20s%-25s  %2d  %2d%6d  %-14s%58 d",collegeName,city + " " + state,tuition,year,enrolled,grad);
	}
}
