import java.util.ArrayList;

public class Sorts
{
	public static int bubbleSort (ArrayList <Integer> list)
	{
		int steps = 0;
		boolean swap = false;
		int numberOfUnsortedElements = 0;
		do {
			swap = false;
			for (int iterate = 1;iterate<numberOfUnsortedElements;iterate++)
			{
				if(list.get(iterate-1)>list.get(iterate))
				{
					int temp = list.get(iterate);
					list.set(iterate,list.get(iterate-1));
					list.set(iterate-1,temp);
				}
			}
			numberOfUnsortedElements++;
		} while ();
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
		if(to - from < 2){
			steps++;
			if(to>from && (a.get(to) < a.get(from)))
			{
				int aTemp = a.get(to);
				int bTemp = a.get(from);
				a.set(to, bTemp);
				a.set(from, aTemp);
				steps++;
			}
		}
		else
		{
			int middle = (from + to) / 2;

			steps += mergeSort(a, from, middle);
			steps += mergeSort(a, middle + 1, to);
			steps += merge(a, from, middle, to);
		}
		return steps;
	}

	public static int merge (ArrayList<Integer> a, int from, int middle, int to)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>(a.size());
		int i = from, j = middle+1, k = from;
		int steps = 0;
		while( i <= middle && j <= to){
			steps++;
			if(a.get(i) < a.get(j)){
				temp.set(k,a.get(i));
				i++;
				steps++;
			}
			else
			{
				temp.set(k, a.get(j));
				j++;
			}
			k++;
		}

		while (i <= middle){
			temp.set(k, a.get(i));
			i++;
			k++;
			steps++;
		}
		steps++;

		while(j<=to){
			temp.set(k, a.get(j));
			j++;
			k++;
			steps++;
		}
		steps++;

		for(k = from; k<=to;k++){
			a.set(k, temp.get(k));
			steps++;
		}
		return steps;
	}
}
