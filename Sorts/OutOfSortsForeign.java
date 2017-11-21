import java.util.Scanner;
import java.util.ArrayList;

public class OutOfSorts
{
	ArrayList <Integer> intlist;

	public OutOfSorts ( )
	{
		intlist = new ArrayList <Integer> ();
	}

	public static void main (String [] args)
	{
		OutOfSorts sortit = new OutOfSorts();
		sortit.run();
	}

	public void run ( )
	{
		char choice = '1';
		welcome();
		do
		{
			int size = getSize();
			int max = getMax();
			createList(size, max, intlist);
			printList(intlist);
			choice = chooseFromMenu("ArrayList of Integer", intlist);
			choice = repeatOrEnd(choice);
		} while (choice >= '1' && choice <= '4');
		goodBye();
	}

	//  A welcome message.
	public void welcome ( )
	{
		System.out.println("\n\n\n\n\t\t\tAre you feeling OUT OF SORTS?\n\n");
		System.out.println("Welcome to the SORTING PROGRAM, a program that will take an Integer ArrayList");
		System.out.println("that is initially unordered, and then order the array using one of 3 quadratic");
		System.out.println("sorting algorithms, or an n log n sort.  These include a Bubble Sort, a Selection");
		System.out.println("Sort, an Insertion Sort, and a Merge Sort.  HAPPY SORTING!\n\n");
	}

	//  Gets the size of the array, from 5 to 10000.
	public int getSize ( )
	{
		return 100;
	}

	//  Gets the max value of the random values to be generated, from 1 to max.  The max should be from 5 to 10000.
	public int getMax ( )
	{
		return 100;
	}

	//  Generates an ArrayList of Integer values, with a size of s, and values from 1 to m.
	public void createList (int s, int m, ArrayList <Integer> a)
	{
	}

	//  Prints the ArrayList of Integer, printing a new line after every 15 values.
	public void printList (ArrayList <Integer> a)
	{
	}

	//  Calls menuOfSorts, getSortType, one of the sorts, then printList and printSteps.
	public char chooseFromMenu (String arraytype, ArrayList <Integer> list)
	{
		menuOfSorts(arraytype);
		return '1';
	}

	//  Prints the list of sort options.
	public void menuOfSorts (String title)
	{
		System.out.println("\n\n1. " + title + " Bubble Sort");
		System.out.println("2. " + title + " Selection Sort");
		System.out.println("3. " + title + " Insertion Sort");
		System.out.println("4. " + title + " Merge Sort\n");
	}

	//  Prompts the user to enter a character value from '1' to '4', indicating the sort
	//  to be run.
	public char getSortType ( )
	{
		return '1';
	}

	//  Prints the number of steps taken by the sort.
	public void printSteps (int s)
	{
	}

	//  Prompts the user to enter a 'c' or 'C' to continue, any other character to exit.
	public char repeatOrEnd (char c)
	{
		return '5';
	}

	//  A goodbye message.
	public void goodBye ( )
	{
		System.out.println("\n\n\n\t\tThanks for working with the SORTING PROGRAM.");
		System.out.println("Hopefully, you were able to put your affairs in order(!).  Please run the program again");
		System.out.println("if you're interested in seeing quadratic sorting algorithms at work.\n\n\n\n");
	}
}
