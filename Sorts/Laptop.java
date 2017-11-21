
import java.util.ArrayList;

public class Laptop implements Comparable<Laptop>
{
	private String name;
	private int modelNum;

	public Laptop ( )
	{
		name = new String("LAPTOP");
		modelNum = -1;
	}

	public Laptop(String s, int n)
	{
		name = new String(s);
		modelNum = n;
	}

	public static void main(String [] args)
	{
		int listSize = 30;
		ArrayList<Laptop> laptop = new ArrayList<Laptop>();
		String [] laptopName = {"Aspire", "Chromebook", "MacBook", "ZenBook", "Inspiron",
				"Latitude", "Pavilion", "EliteBook", "ProBook", "Envy",
				"ThinkPad", "IdeaPad", "Surface", "Blade", "Slate"};
		int [] num = {1100, 2100, 9000, 8600, 500, 987, 4950, 7700, 65, 5, 9012, 6600, 9105, 1500};
		for(int i = 0; i < listSize; i++)
		{
			laptop.add(new Laptop(laptopName[(int)(Math.random()*laptopName.length)],num[(int)(Math.random()*num.length)]));
		}
		sort(laptop);
		System.out.println("\n\n\n");
		for(int i = 0; i < laptop.size(); i++)
		{
			System.out.printf("%-28s",laptop.get(i));
			if(i != 0 && laptop.get(i).equals(laptop.get(i-1)))
			{
				System.out.print("Same as the previous laptop!");
			}
			System.out.println();
		}
		System.out.println("\n\n\n");
	}

	public int compareTo(Laptop other)
	{
		int diff = this.name.compareTo(other.name);
		if(diff == 0)
		{
			diff = modelNum - other.modelNum;
		}
		return diff;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj != null && obj instanceof Laptop)
		{
			return compareTo((Laptop)obj) == 0;
		}
		return false;
	}

	public String toString ( )
	{
		return name + " " + modelNum;
	}

	public static void sort(ArrayList<Laptop> a)
	{
		for (int outer = 0; outer < a.size() - 1; outer++)
		{
			for (int inner = 0; inner < a.size()-outer-1; inner++)
			{
				if(a.get(inner).compareTo(a.get(inner + 1)) > 0)
				{
					//swap array[inner] & array[inner+1]
					Laptop temp = a.get(inner);
					a.set(inner,a.get(inner + 1));
					a.set(inner+1,temp);
				}
			}
		}
	}
}
