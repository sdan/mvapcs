import java.util.ArrayList;

public class Recursion
{
	public static void main(String [] args)
	{
		Recursion run = new Recursion();
		run.loop();
	}

	public void loop ( )
	{
		System.out.println("\n\n\nWelcome to Surya's EXTENDED Recursion Game!");
		char input = ' ';
		do
		{
			menu();
			input = Prompt.getChar("\nMake a choice from the menu above, q or Q to quit: ");
			doSomething(input);
		}
		while(input != 'q' && input != 'Q');
	}

	public void menu ( )
	{
		System.out.println("\n(1) GCF");
		System.out.println("(2) Factorial");
		System.out.println("(3) Fibonacci");
		System.out.println("(4) Fibonacci");
		System.out.println("(5) Fibonacci");
		System.out.println("(6) Fibonacci");

	}

	public void doSomething(char input)
	{
		switch(input)
		{
			case '1':
				gcfLoop();
				break;
			case '2':
				factorialLoop();
				break;
			case '3':
				fibonacciLoop();
				break;
		}
	}

	public void gcfLoop ( )
	{
		int input1 = 0;
		int input2 = 0;
		do
		{
			input1 = Prompt.getInt("\nEnter an integer, 0 to quit",0,100000);
			if(input1 != 0)
			{
				input2 = Prompt.getInt("\nEnter an integer",1,100000);
				System.out.println("\nGCF: " + gcf(input1,input2));
			}
		}
		while(input1 != 0);
	}

	public int gcf(int a, int b)
	{
		return 0;
	}

	public void factorialLoop ( )
	{
		int input = 0;
		do
		{
			input = Prompt.getInt("\nEnter an integer, 0 to quit",0,20);
			if(input != 0)
			{
				System.out.print("\n" + input + "! = " + fact(input) + "\n");
			}
		}
		while(input != 0);
	}


	public long fact(int num)
	{
		return 0;
	}

	public void fibonacciLoop ( )
	{
		int input = 0;
		do
		{
			input = Prompt.getInt("\nEnter an index value, 0 to quit",0,40);
			if(input != 0)
			{
				System.out.println();
				ArrayList<Integer> list = new ArrayList<Integer>();
				fibonacci(input,1,list);
				printList(list);
			}
		}
		while(input != 0);
	}

	public void fibonacci(int max, int input, ArrayList<Integer> list)
	{

	}

	public int fib(int n)
	{
		return 0;
	}

	public void printList(ArrayList<Integer> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(i % 10 == 0)
			{
				System.out.println();
			}
			System.out.printf("%10d",list.get(i).intValue());
		}
		System.out.println();
	}
}

//  For the Prompt class
/*
	public static char getChar (String ask)
	{
		boolean badinput = false;
		String input = new String("");
		char value = ' ';
		do
		{
			badinput = false;
			input = getString(ask + " : ");
			if(input.length() != 1)
			{
				badinput = true;
			}
		}
		while(badinput);
		value = input.charAt(0);
		return value;
	}
*/
