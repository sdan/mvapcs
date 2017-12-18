import java.util.ArrayList;
import java.util.Collections;

public class Sorts
{
	public static int bubbleSort (ArrayList <Integer> list)
	{
		int steps = 0;
		boolean swap = false;
		int numberOfUnsortedElements = list.size();
		steps+=3; //Declaration and assignment of steps, swap, and numberOfUnsortedElements
		do {
			steps+=2; //Declaration of iterate and assignment of swap
			swap = false;
			for (int iterate = 1;iterate<numberOfUnsortedElements;iterate++)
			{
				steps+=2; //boolean above (when true), iterate++
				if(list.get(iterate-1)>list.get(iterate))
				{
					steps++; //boolean above
					steps+=4; // Assignment of temp, swap, and swapping indexes of the ArrayList
					int temp = list.get(iterate);
					list.set(iterate,list.get(iterate-1));
					list.set(iterate-1,temp);
					swap = true;
				}
			}
			numberOfUnsortedElements--;
			steps+=2; // boolean below and assignment above
		} while (swap);
		return steps;
	}
	public static int selectionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		steps+=3; //Declaration of max and temp, and the declaration and assignment of outer.
		int min, temp;

		for (int outer = 0; outer <list.size(); outer++)
		{
			steps+=4; // boolean above (when true), outer--, max=0, declaration of inner.
			min = outer;
			for (int inner = outer; inner < list.size(); inner++)
			{
				steps+=3; //boolean above (when true), inner++, boolean below.
				if (list.get(inner).intValue() < list.get(min).intValue())
				{
					steps++; //for max = inner.
					min = inner; // a new largest item is found
				}
			}
			steps++; //inner<outer is false.
			steps+=3; // for the swap inthe two statements below.
			 temp = list.get(min);
      list.set(min, list.get(outer));
      list.set(outer, temp);
			// temp = list.set(outer,list.get(min)).intValue();
			// list.set(min,new Integer(temp));

		}
		steps++; //when outer>1 is false.

		return steps;
	}

	public static int insertionSort (ArrayList <Integer> list)
	{
		System.out.println("insertion");
		int steps = 0;
		steps++; //Declaration and assignment of outer
		for (int outer = 1; outer < list.size(); outer++)
		{
			int position = outer;
			int key = list.get(position);
			steps+=4; //Declaration and assignment of position, key, outer++, boolean above
			while (position > 0 && list.get(position-1) > key)
			{
				steps+=2; //both boolean statements
				list.set(position,list.get(position - 1));
				position--;
				steps+=2; //Assignment of position, assignment of position in set
			}
			list.set(position,key);
			steps++; //Assignment of position with set
		}
		return steps;
	}

	public static int mergeSort (ArrayList<Integer> a, int from, int to)
	{
		int steps = 0;
		if(to - from < 2)
		{
			steps++; //boolean above
			if(to>from && (a.get(to) < a.get(from)))
			{
				steps+=2; //both boolean expresions above
				int temp = a.get(to);
				a.set(to, a.get(from));
				a.set(from, temp);
				steps+=3; //Declaration and assignment of temp, and swtiching
			}
		}
		else
		{
			steps++;//Declaration and assignment of middle
			int middle = (from + to) / 2;
			// System.out.println("FROM: "+from+" MID: "+middle);
			steps += mergeSort(a, from, middle);
			steps += mergeSort(a, middle + 1, to);
			steps += merge(a, from, middle, to);
		}
		return steps;
	}

	public static int merge (ArrayList<Integer> a, int from, int middle, int to)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>(a);
		int i = from, j = middle+1, k = from;
		int steps = 0;
		steps+=4 ;//Declaration and assignment of i,j,k, ArrayList temp
		while( i <= middle && j <= to)
		{
			steps+=3; //both boolean expresions above
			if(a.get(i) < a.get(j))
			{
				temp.set(k,a.get(i));
				i++;
				steps+=2;//boolean expresion above, set, assignment of i
			}
			else
			{
				temp.set(k, a.get(j));
				j++;
				steps+=2;//set, assignment of step
			}
			k++;
			steps++; //Assignment of k
		}
		steps+=2;
		while (i <= middle)
		{
			temp.set(k, a.get(i));
			i++;
			k++;
			steps+=4;//boolean above, assignment of i,k,temp
		}
		steps+=1;
		while(j<=to)
		{
			temp.set(k, a.get(j));
			j++;
			k++;
			steps+=4;//boolean above, assignment of j, k, temp
		}
		steps+=2;
		for(k = from; k<=to;k++)
		{
			a.set(k, temp.get(k));
			steps+=3;//Assignment of set and k, k++
		}
		steps++;
		return steps;
	}
}
