/**
 * OutOfSorts.java
 * Sorting Practice
 * @author Surya Dantuluri
 * @version 1.0
 * @since 11/17/2017
 */
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
            sortIt(choice);
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
        int size = Prompt.getInt("\n\nPlease enter the number of random integers you would like to generate (5 - 10000)    -> ",5,10000);
        return size;
    }

    //  Gets the max value of the random values to be generated, from 1 to max.  The max should be from 5 to 10000.
    public int getMax ( )
    {
        int max = Prompt.getInt("\n\nPlease enter the maximum value that you would like to possibly generate (5 - 10000)  -> ",5,10000);
        return max;
    }

    //  Generates an ArrayList of Integer values, with a size of s, and values from 1 to m.
    public void createList (int s, int m, ArrayList <Integer> a)
    {
        a.clear();
        for(int i = 0;i<s;i++)
        {
            a.add(new Integer(1+(int)(Math.random()*m)));
        }
    }

    //  Prints the ArrayList of Integer, printing a new line after every 15 values.
    public void printList (ArrayList <Integer> a)
    {
        for(int i = 0;i<a.size();i++)
        {
            if(i%15==0)
            {
                System.out.println();
            }
            System.out.printf("%6d",a.get(i).intValue());
        }
    }

    //  Calls menuOfSorts, getSortType, one of the sorts, then printList and printSteps.
    public char chooseFromMenu (String arraytype, ArrayList <Integer> list)
    {
        menuOfSorts(arraytype);
        return getSortType();

    }

    //  Prints the list of sort options.
    public void menuOfSorts (String title)
    {
        System.out.println("\n\n");
        System.out.println("\n\n1. " + title + " Bubble Sort");
        System.out.println("2. " + title + " Selection Sort");
        System.out.println("3. " + title + " Insertion Sort");
        System.out.println("4. " + title + " Merge Sort\n");
        System.out.println("\n");
    }

    //  Prompts the user to enter a character value from '1' to '4', indicating the sort
    //  to be run.
    public char getSortType ( )
    {
        char inputChar = ' ';
            inputChar = Prompt.getChar("Enter a choice (1-4) from the menu above -> ",new char[]{'1','2','3','4'});
        return inputChar;
    }

    public void sortIt(char choice)
    {
        int steps = 0;
        switch(choice)
        {
            case '1':
            steps = Sorts.bubbleSort(intlist);
             break;
            case '2':
            steps = Sorts.selectionSort(intlist);
             break;
            case '3':
            steps = Sorts.insertionSort(intlist);
             break;
            case '4':
            steps = Sorts.mergeSort(intlist,0,intlist.size()-1);
            break;
        }
        printList(intlist);
        printSteps(steps);
    }

    //  Prints the number of steps taken by the sort.
    public void printSteps (int s)
    {
        System.out.printf("\n\n");
        System.out.printf("%,d steps taken  in this sort.",s);
        System.out.printf("\n\n");
    }

    //  Prompts the user to enter a 'c' or 'C' to continue, any other character to exit.
    public char repeatOrEnd (char c)
    {
      char cornot = Prompt.getChar("Enter a character to get or c or C to continue or any other character if you don't want to->");
      if(cornot=='c'||cornot=='C')
      return '1';
      return '0';
    }

    //  A goodbye message.
    public void goodBye ( )
    {
        System.out.println("\n\n\n\t\tThanks for working with the SORTING PROGRAM.");
        System.out.println("Hopefully, you were able to put your affairs in order(!).  Please run the program again");
        System.out.println("if you're interested in seeing quadratic sorting algorithms at work.\n\n\n\n");
    }
}
