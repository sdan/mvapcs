import java.util.ArrayList;

public class Sorts
{
	public static int bubbleSort (ArrayList <Integer> list)
	{
		int steps = 0;
		for (int i = 0;i<list.size();i++) {
			for (int j = 0;j<list.size()-i-1;j++) {
				//i-1 since last i's are sorted
				if(list.get(j).intValue()>list.get(j+1).intValue())
				{
					//swap
					int temp = list.get(j).intValue();
					list.set(j,list.get(j+1).intValue());
					list.set(j+1,temp);
					steps++;
				}
				steps++;
			}
		}
		return steps;
	}
	public static int selectionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		steps+=3; //Declaration of max and temp, and the declaration and assignment of outer.
		int max, temp;

		for (int outer = list.size(); outer > 1; outer--)
		{
			steps+=4; // boolean above (when true), outer--, max=0, declaration of inner.
			max = 0;
			for (int inner = 1; inner < outer; inner++)
			{
				steps+=3; //boolean above (when true), inner++, boolean below.
				if (list.get(inner).intValue() > list.get(max).intValue())
				{
					steps++; //for max = inner.
					max = inner; // a new largest item is found
				}
			}
			steps++; //inner<outer is false.
			steps+=3; // for the swap inthe two statements below.
			temp = list.set(outer-1,list.get(max)).intValue();
			list.set(max,new Integer(temp));

		}
		steps++; //when outer>1 is false.

		return steps;
	}

	public static int insertionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		for(int i = 1; i<list.size();i++)
		{
			int temp = list.get(i);
			int j = i;
			while(j>0 && temp < list.get(j-1)){
				list.set(j, list.get(j-1));
				j--;
				steps++;
			}
			list.set(j, temp);
			steps++;
		}
		return steps;
	}

	public static int mergeSort (ArrayList<Integer> a, int from, int to)
	{
		int steps = 0;
		int middle = (from + to) / 2;
		steps += mergeSort(a, from, middle);
		steps += mergeSort(a, middle + 1, to);
		steps += merge(a, from, middle, to);
		return steps;
	}

	public static int merge (ArrayList<Integer> a, int from, int middle, int to)
	{
		int steps = 0;
		return steps;
	}
}
