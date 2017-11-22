
import java.util.ArrayList;

public class Address implements Comparable<Address>
{
	private String street;
	private int number;

	public Address ( )
	{
		street = new String("nowhere");
		number = -1;
	}

	public Address(String s, int n)
	{
		street = new String(s);
		number = n;
	}

	public static void main(String [] args)
	{
		int listSize = 30;
		ArrayList<Address> address = new ArrayList<Address>();
		String [] street = {"Main Street", "Park Place", "Center Avenue", "Jones Boulevard", "Alameda Street",
				"De Anza Boulevard", "Bubb Road", "McClellan Road", "Smith Road", "Albert Avenue",
				"Orange Avenue", "Imperial Avenue", "Presidio Drive", "Hyannisport Drive", "Byrne Avenue"};
		int [] num = {1234, 4567, 1982, 9835, 9911, 8228, 7333, 6446, 5512, 5692, 7111, 3571, 9145, 9631, 8148};
		for(int i = 0; i < listSize; i++)
		{
			address.add(new Address(street[(int)(Math.random()*street.length)],num[(int)(Math.random()*num.length)]));
		}
		sort(address);
		System.out.println("\n\n\n");
		for(int i = 0; i < address.size(); i++)
		{
			System.out.printf("%-28s",address.get(i));
			if(i != 0 && address.get(i).equals(address.get(i-1)))
			{
				System.out.print("Same as the previous address!");
			}
			System.out.println();
		}
		System.out.println("\n\n\n");
	}

	public int compareTo(Address other)
	{
		int diff = this.street.compareTo(other.street);
		if(diff == 0)
		{
			diff = number - other.number;
		}
		return diff;
	}

	@Override
	public boolean equals(Object obj1, Object obj2)
	{
		if(obj != null && obj instanceof Address)
		{
			return ob1.name.compareTo((Address)obj) == 0;
		}
		return false;
	}

	public String toString ( )
	{
		return number + " " + street;
	}

	public static void sort(ArrayList<Address> a)
	{
		for (int outer = 0; outer < a.size() - 1; outer++)
		{
			for (int inner = 0; inner < a.size()-outer-1; inner++)
			{
				if(a.get(inner).compareTo(a.get(inner + 1)) > 0)
				{
					//swap array[inner] & array[inner+1]
					Address temp = a.get(inner);
					a.set(inner,a.get(inner + 1));
					a.set(inner+1,temp);
				}
			}
		}
	}
}
