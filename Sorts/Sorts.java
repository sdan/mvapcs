import java.util.ArrayList;

public class Sorts
{
	public static int bubbleSort (ArrayList <Integer> list)
	{
		int steps = 0;
		return steps;
	}

	public static int selectionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		return steps;
	}

	public static int insertionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		return steps;
	}

	public static int mergeSort (ArrayList<Integer> a, int from, int to)
	{
		int steps = 0;
//		else
//		{
			int middle = (from + to) / 2;

			steps += mergeSort(a, from, middle);
			steps += mergeSort(a, middle + 1, to);
			steps += merge(a, from, middle, to);
//		}
		return steps;
	}

	public static int merge (ArrayList<Integer> a, int from, int middle, int to)
	{
		int steps = 0;
		return steps;
	}
}
