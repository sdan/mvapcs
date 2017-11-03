public class MoreParameters2
{
	private int number;
	public static void main (String [] args)
	{
		MoreParameters2 run = new MoreParameters2();
		run.changeArray();
	}

	public MoreParameters2()
	{
		int number = 20;
	}
	public void changeArray ( )
	{
		System.out.println("num"+number);
		int [] array = {8, 33, 52};
		printArray(array);
		changeArrayOne(array);
		printArray(array);
		changeArrayTwo(array);
		printArray(array);
	}

	public void printArray (int [] arr)
	{
		System.out.println(arr[0] + "  " + arr[1] + "  " + arr[2]);
	}

	public void changeArrayOne (int [] arr)
	{
		arr[1] = arr[2];
		arr[2] = arr[0];
		arr[0] = arr[1];
		printArray(arr);
	}

	public void changeArrayTwo (int [] arr)
	{
		int array[] = new int[3];
		array[0] = 9;
		array[1] = 13;
		array[2] = 17;
		printArray(array);
	}
}
