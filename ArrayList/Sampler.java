/**
*  Sampler.java
*  A sampling of methods that manipulate ArrayLists. These include:
*  (1) A swap method that swaps two Strings in an ArrayList.
*  (2) An inOrder method that returns true if a String ArrayList is
*  in non-decreasing order, false otherwise.
*  (3) A reverse method that takes an Integer ArrayList and creates
*  a new ArrayList in reverse order, then returns this ArrayList.  The
*  original ArrayList remains unchanged.
*  (4) A removeLeast method that finds and removes the least
*  Double in an ArrayList, using the compareTo method in Double.
*  (5) A removeDuplicates method that removes duplicate Strings
*  in an ArrayList passed as an argument.
*  (6) A rotateRight method that rotates all elements of an ArrayList
*  of Integer n spots to the right, with "overflow" elements being
*  wrapped around to the start of the ArrayList.
*  A main method is provided to test each of these methods.
*  @author Surya Dantuluri
*  @version 1.0
*  @since 11/14/2017
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Sampler
{
  /**    The ArrayList of String to be used in tasks (1), (2), and (5) above   */
  private ArrayList<String> elements;
  /**    The ArrayList of Integer to be used in tasks (3) and (6) above   */
  private ArrayList<Integer> numbers;
  /**    The ArrayList of Double to be used in task (4) above   */
  private ArrayList<Double> values;
  /**    Creates a Sampler object, initializing the 3 ArrayLists with some
  *     values.
  */
  public Sampler ( )
  {
    elements = new ArrayList<String>(Arrays.asList("Zinc", "Copper", "Gold", "Iron", "Neon", "Boron", "Carbon", "Argon"));
    numbers = new ArrayList<Integer>(Arrays.asList(45, 23, 94, 15, 83, 59, 70, 34, 62, 38));
    values = new ArrayList<Double>(Arrays.asList(5.6, 4.1, 9.4, 8.8, 1.3, 2.1, 7.9));
  }
  public static void main(String [] args)
  {
    Sampler sample = new Sampler();
    sample.run();
  }
  /**
  *  Runs all of the tasks, fully testing them.
  */
  public void run ( )
  {
    System.out.println("\n\n\n");
    tasksOneAndTwo();
    taskThree();
    taskFour();
    taskFive();
    taskSix();
    System.out.println("\n\n\n");
  }
  /**
  *  Runs tasks (1) and (2), swapping elements of a String ArrayList,
  *  printing the ArrayList and checking to see if the ArrayList is in order.
  */
  public void tasksOneAndTwo ( )
  {
    System.out.println("\n\nTASKS (1) AND (2)\n");
    printStringArrayList(elements);
    checkOrder(elements);
    System.out.println();
    System.out.println("Swapping elements at indices 0 and 7:");
    swap(elements,0,7);
    printStringArrayList(elements);
    checkOrder(elements);
    System.out.println();
    System.out.println("Swapping elements at indices 1 and 5:");
    swap(elements,1,5);
    printStringArrayList(elements);
    checkOrder(elements);
    System.out.println();
    System.out.println("Swapping elements at indices 2 and 6:");
    swap(elements,2,6);
    printStringArrayList(elements);
    checkOrder(elements);
    System.out.println();
    System.out.println("Swapping elements at indices 3 and 5:");
    swap(elements,3,5);
    printStringArrayList(elements);
    checkOrder(elements);
    System.out.println();
    System.out.println("Swapping elements at indices 4 and 6:");
    swap(elements,4,6);
    printStringArrayList(elements);
    checkOrder(elements);
    System.out.println();
  }
  /**
  *  Runs task (3), reversing an ArrayList of Integer, printing out both the
  *  original ArrayList of Integer and the reversed ArrayList of Integer.
  */
  public void taskThree ( )
  {
    System.out.println("\n\nTASK (3)\n");
    ArrayList<Integer> reversed = reverseArray(numbers);
    System.out.println("The original ArrayList:");
    printIntegerArrayList(numbers);
    System.out.println();
    System.out.println("The reversed ArrayList:");
    printIntegerArrayList(reversed);
    System.out.println();
  }
  /**
  *  Runs task (4), removing the least value in an ArrayList of Double.
  */
  public void taskFour ( )
  {
    System.out.println("\n\nTASK (4)\n");
    System.out.println("The original ArrayList:");
    printDoubleArrayList(values);
    System.out.println();
    System.out.println("The ArrayList with the least value removed:");
    removeLeast(values);
    printDoubleArrayList(values);
    System.out.println();
    System.out.println("The ArrayList with the least value removed:");
    removeLeast(values);
    printDoubleArrayList(values);
    System.out.println();
    System.out.println("The ArrayList with the least value removed:");
    removeLeast(values);
    printDoubleArrayList(values);
    System.out.println();
    System.out.println("The ArrayList with the least value removed:");
    removeLeast(values);
    printDoubleArrayList(values);
    System.out.println();
  }
  /**
  *  Runs task (5), removing duplicate Strings from an ArrayList of String.
  */
  public void taskFive ( )
  {
    System.out.println("\n\nTASK (5)\n");
    elements.add(1,"Copper");
    elements.add(4,"Copper");
    elements.add(7,"Copper");
    elements.add(3,"Gold");
    elements.add(4,"Gold");
    System.out.println("The original ArrayList:");
    printStringArrayList(elements);
    System.out.println();
    System.out.println("The ArrayList with duplicates removed:");
    removeDuplicates(elements);
    printStringArrayList(elements);
    System.out.println();
  }
  /**
  *  Runs task (6), rotating an ArrayList of Integer, printing out both the
  *  original ArrayList of Integer and the rotated ArrayList of Integer.
  */
  public void taskSix ( )
  {
    System.out.println("\n\nTASK (6)\n");
    System.out.println("The original ArrayList:");
    printIntegerArrayList(numbers);
    System.out.println();
    System.out.println("The rotated (3 spots) ArrayList:");
    rotateRight(numbers,3);
    printIntegerArrayList(numbers);
    System.out.println();
    System.out.println("The rotated (1 spot) ArrayList:");
    rotateRight(numbers,1);
    printIntegerArrayList(numbers);
    System.out.println();
    System.out.println("The rotated (5 spots) ArrayList:");
    rotateRight(numbers,5);
    printIntegerArrayList(numbers);
    System.out.println();
    System.out.println("The rotated (-5 spots) ArrayList:");
    rotateRight(numbers,-5);
    printIntegerArrayList(numbers);
    System.out.println();
  }
  /**
  *  Checks to see if the Strings in the ArrayList are in lexicographic order,
  *  printing a message for either case.
  *  @param arr        The ArrayList of String to be checked for order
  */
  public void checkOrder(ArrayList<String> arr)
  {
    if(inOrder(arr))
    {
      System.out.println("The ArrayList is IN ORDER");
    }
    else
    {
      System.out.println("The ArrayList is NOT in order");
    }
  }
  /**
  *  Checks to see if the Strings in the ArrayList are in lexicographic order,
  *  returning true if they are in order, false otherwise.
  *  @param arr        The ArrayList of String to be checked for order
  *  @return           true for an ordered ArrayList, false otherwise
  */
  public boolean inOrder(ArrayList<String> arr)
  {
    int i = 0;
    while(i<arr.size()-1)
    {
      if((arr.get(i).compareTo(arr.get(i+1))>0))
      {
        System.out.println("FALSE "+arr.get(i)+" "+arr.get(i+1));
        return false;
      }
      else
      i++;
    }
    return true;
  }
  /**
  *  Prints the ArrayList of String.
  *  @param arr        The ArrayList of String to be printed
  */
  public void printStringArrayList(ArrayList<String> arr)
  {
    for(int i = 0; i < arr.size(); i++)
    {
      System.out.printf("%-8d", i);
    }
    System.out.println();
    for(String s : arr)
    {
      System.out.printf("%-8s", s);
    }
    System.out.println();
  }
  /**
  *  Swaps the ArrayList of String elements, as indicated by the index
  *  values that are passed in as arguments.
  *  @param arr        The ArrayList of String to be modified (two elements swapped)
  *  @param i          The first index of the String element to be swapped
  *  @param i          The second index of the String element to be swapped
  */
  public void swap(ArrayList<String> arr, int i, int j)
  {
    String temp = arr.get(i);
    arr.set(i,arr.get(j));
    arr.set(j,temp);
  }
  /**
  *  Creates an ArrayList of Integer.  This ArrayList of Integer is the
  *  reverse of the ArrayList of Integer passed as an argument.  The
  *  reversed ArrayList of Integer is returned.
  *  @param arr        The ArrayList of Integer to be reversed
  *  @return           The reversed ArrayList of Integer
  */
  public ArrayList<Integer> reverseArray(ArrayList<Integer> arr)
  {
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i = arr.size()-1; i>-1; i--)
    {
      result.add(arr.get(i));
    }
    return result;
  }
  /**
  *  Prints the ArrayList of Integer.
  *  @param arr        The ArrayList of Integer to be printed
  */
  public void printIntegerArrayList(ArrayList<Integer> arr)
  {
    for(int i = 0; i < arr.size(); i++)
    {
      System.out.printf("%-5d", i);
    }
    System.out.println();
    for(Integer num : arr)
    {
      System.out.printf("%-5d", num.intValue());
    }
    System.out.println();
  }
  /**
  *  Removes the least value from the ArrayList of Double.
  *  @param arr        The ArrayList of Double to be changed (least value removed)
  */
  public void removeLeast(ArrayList<Double> arr)
  {
    double min = arr.get(0);
    int index = -99999;
    for(int i = 0;i<arr.size();i++)
    {
      if(arr.get(i)<min)
      {
        min=arr.get(i);
      }
    }
    arr.remove(arr.indexOf(min));
  }
  /**
  *  Prints the ArrayList of Double.
  *  @param arr        The ArrayList of Double to be printed
  */
  public void printDoubleArrayList(ArrayList<Double> arr)
  {
    for(int i = 0; i < arr.size(); i++)
    {
      System.out.printf("%-8d", i);
    }
    System.out.println();
    for(Double num : arr)
    {
      System.out.printf("%-8.2f", num.doubleValue());
    }
    System.out.println();
  }
  /**
  *  Removes duplicates from an ArrayList of String
  *  @param arr        The ArrayList of String to be changed (duplicates removed)
  */
  public void removeDuplicates(ArrayList<String> arr)
  {
    for(int i = 0;i<arr.size();i++)
    {
      for (int j = 0;j<arr.size();j++)
      {
        if(arr.get(i).equals(arr.get(j))&&i!=j)
        arr.remove(j) ;
      }
    }
  }
  /**
  *  Rotates an ArrayList of Integer 1 step to the right, with the last element
  *  wrapped around to the first spot in the ArrayList of Integer.
  *  @param arr        The ArrayList of Integer to be changed (shifted one to the right)
  */
  public void rotateRight(ArrayList<Integer> a)
  {
    a.add(0,a.get((a.size()-1)));
    a.remove(a.size()-1);
  }
  /**
  *  Rotates an ArrayList of Integer 1 step to the left, with the first element
  *  wrapped around to the last spot in the ArrayList of Integer.
  *  @param arr        The ArrayList of Integer to be changed (shifted one to the left)
  */
  public void rotateLeft(ArrayList<Integer> a)
  {
    a.add(a.get(0));
    a.remove(0);
  }
  /**
  *  Rotates an ArrayList of Integer n steps to the right, with the last elements
  *  wrapped around to the beginning of the ArrayList of Integer.
  *  @param arr        The ArrayList of Integer to be changed (shifted n steps to the right)
  *  @param n          The number of steps that the ArrayList is shifted to the right (negative for left)
  */
  public void rotateRight(ArrayList<Integer> a, int n)
  {
    if(n>0)
    while(n>0)
    {
      rotateRight(a);
      n--;
    }
    else
    while(n<0)
    {
      rotateLeft(a);
      n++;
    }
  }
}
/*
C:\Java>java Sampler

TASKS (1) AND (2)
0       1       2       3       4       5       6       7
Zinc    Copper  Gold    Iron    Neon    Boron   Carbon  Argon
The ArrayList is NOT in order
Swapping elements at indices 0 and 7:
0       1       2       3       4       5       6       7
Argon   Copper  Gold    Iron    Neon    Boron   Carbon  Zinc
The ArrayList is NOT in order
Swapping elements at indices 1 and 5:
0       1       2       3       4       5       6       7
Argon   Boron   Gold    Iron    Neon    Copper  Carbon  Zinc
The ArrayList is NOT in order
Swapping elements at indices 2 and 6:
0       1       2       3       4       5       6       7
Argon   Boron   Carbon  Iron    Neon    Copper  Gold    Zinc
The ArrayList is NOT in order
Swapping elements at indices 3 and 5:
0       1       2       3       4       5       6       7
Argon   Boron   Carbon  Copper  Neon    Iron    Gold    Zinc
The ArrayList is NOT in order
Swapping elements at indices 4 and 6:
0       1       2       3       4       5       6       7
Argon   Boron   Carbon  Copper  Gold    Iron    Neon    Zinc
The ArrayList is IN ORDER
TASK (3)
The original ArrayList:
0    1    2    3    4    5    6    7    8    9
45   23   94   15   83   59   70   34   62   38
The reversed ArrayList:
0    1    2    3    4    5    6    7    8    9
38   62   34   70   59   83   15   94   23   45
TASK (4)
The original ArrayList:
0       1       2       3       4       5       6
5.60    4.10    9.40    8.80    1.30    2.10    7.90
The ArrayList with the least value removed:
0       1       2       3       4       5
5.60    4.10    9.40    8.80    2.10    7.90
The ArrayList with the least value removed:
0       1       2       3       4
5.60    4.10    9.40    8.80    7.90
The ArrayList with the least value removed:
0       1       2       3
5.60    9.40    8.80    7.90
The ArrayList with the least value removed:
0       1       2
9.40    8.80    7.90
TASK (5)
The original ArrayList:
0       1       2       3       4       5       6       7       8       9       10      11      12
Argon   Copper  Boron   Gold    Gold    Carbon  Copper  Copper  Gold    Copper  Iron    Neon    Zinc
The ArrayList with duplicates removed:
0       1       2       3       4       5       6       7
Argon   Copper  Boron   Gold    Carbon  Iron    Neon    Zinc
TASK (6)
The original ArrayList:
0    1    2    3    4    5    6    7    8    9
45   23   94   15   83   59   70   34   62   38
The rotated (3 spots) ArrayList:
0    1    2    3    4    5    6    7    8    9
34   62   38   45   23   94   15   83   59   70
The rotated (1 spot) ArrayList:
0    1    2    3    4    5    6    7    8    9
70   34   62   38   45   23   94   15   83   59
The rotated (5 spots) ArrayList:
0    1    2    3    4    5    6    7    8    9
23   94   15   83   59   70   34   62   38   45
The rotated (-5 spots) ArrayList:
0    1    2    3    4    5    6    7    8    9
70   34   62   38   45   23   94   15   83   59

C:\Java>
*/
 
