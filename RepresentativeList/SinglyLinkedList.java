/**
 * SinglyLinkedList.java
 * A Singly Linked List data structure made of ListNode objects.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 5/14/2018
 */

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class SinglyLinkedList
{
	private ListNode first;
	private ListNode last;

	public SinglyLinkedList()
	{
		first = null;
		last = null;
	}

	public void loadData()
	{
		String temp;
		String subs;
		String district;
		String firstName;
		String lastName;
		int birthMonth;
		int birthDay;
		int birthYear;
		String party;
		int firstElected;

        try
        {
            Scanner inFile = new Scanner(new File("representatives.txt"));
            inFile.nextLine();
            //District,           Name,                   Birth Date      Party           Year First Elected
            //Arizona 1,          Tom O'Halleran,         01/24/1946      Democrat        2016
            while(inFile.hasNext())
            {
				//System.out.println("\n\n\n");
                // temp = inFile.nextLine();
                // district = line.substring(0, line.indexOf(",")).trim();
                // temp = temp.substring(line.indexOf(",")+1).trim();
				// subs = line.substring(0, line.indexOf(",")+1);
                // firstName = subs.substring(0, subs.indexOf(l)).trim();
                // temp = temp.substring(temp.indexOf(' ')).trim();
                // lastName = subs.substring(subLine.lastIndexOf(" ")+1, subs.indexOf(",")).trim();
                // temp = temp.substring(temp.indexOf(',')+1).trim();
                // birthMonth = Integer.parseInt(temp.substring(0,temp.indexOf('/')));
                // temp = temp.substring(temp.indexOf('/')+1).trim();
                // birthDay = Integer.parseInt(temp.substring(0,temp.indexOf('/')));
                // temp = temp.substring(temp.indexOf('/')+1).trim();
                // birthYear = Integer.parseInt(temp.substring(0,temp.indexOf(' ')));
                // temp = temp.substring(temp.indexOf(' ')).trim();
                // party = temp.substring(0,temp.indexOf(' '));
                // temp = temp.substring(temp.indexOf(' ')).trim();
                // firstElected = Integer.parseInt(temp);

				String line = inFile.nextLine();

				String d = line.substring(0, line.indexOf(",")).trim();
				line = line.substring(line.indexOf(",")+1).trim();
				String subLine = line.substring(0, line.indexOf(",")+1);
				String l = subLine.substring(subLine.lastIndexOf(" ")+1, subLine.indexOf(",")).trim();
				String f = subLine.substring(0, subLine.indexOf(l)).trim();
				line = line.substring(line.indexOf(",")+1).trim();
				int bm = Integer.parseInt(line.substring(0, line.indexOf("/")).trim());
				line = line.substring(line.indexOf("/")+1).trim();
				int bd = Integer.parseInt(line.substring(0, line.indexOf("/")).trim());
				line = line.substring(line.indexOf("/")+1).trim();
				int by = Integer.parseInt(line.substring(0, line.indexOf(" ")).trim());
				line = line.substring(line.indexOf(" ")+1).trim();
				String p = line.substring(0, line.indexOf(" ")).trim();
				line = line.substring(line.indexOf(" ")+1).trim();
				int e = Integer.parseInt(line);

				addLast(new Representative(d, f, l, bm, bd, by, p, e));




				//String d, String f, String l, int bm, int bd, int by, String p, int e
                //System.out.println("district "+district);
                //System.out.println("firstName "+firstName);
                //System.out.println("lastName "+lastName);
                //System.out.println("birthMonth "+birthMonth);
                //System.out.println("birthDay "+birthDay);
                //System.out.println("birthYear "+birthYear);
                //System.out.println("party "+party);
                //System.out.println("firstElected "+firstElected);
                //addLast(new Representative(district,firstName,lastName,birthMonth,birthDay,birthYear,party,firstElected));
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

	}

	// public void selectionSortYear()
	// {
	// 	for (ListNode outer = getFirst(); outer.getNext()!=null ; outer.getNext())
	// 	{
	// 		ListNode min = outer;
	// 		ListNode temp = null;
	// 		for(ListNode inner = outer.getNext(); inner!=null; inner.getNext())
	// 			if(((Representative)min.getBirthYear()>(Representative)inner.getNext().getBirthYear()))
	// 			{
	// 				min = inner.getNext();
	// 				temp = inner;
	// 			}
	//
	// 		if(min!=outer)
	// 			swap(getFirst(), getFirst(), min, temp);
	// 	}
	// }
	//
	// public void swapNodes(ListNode head, ListNode currX,ListNode currY, ListNode prevY)
	// {
	// 	// make 'currY' as new head
	// 	head = currY;
	// 	// adjust links
	// 	prevY.next = currX;
	//
	// 	// Swap next pointers
	// 	ListNode temp = currY.next;
	// 	currY.next = currX.next;
	// 	currX.next = temp;
	// }


	public Object getFirst()
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return first.getValue();
		}
	}

	public Object getLast()
	{
		ListNode temp = first;
		while(temp.getNext() != null)
		{
		   temp = temp.getNext();
		}
		return temp.getValue();
	}

	public void addFirst(Object value)
	{
		first = new ListNode(value, first);
		if(size()==0)
			last = first;
	}

	public void addLast(Object value)
	{
		if(first == null)
		{
			first = new ListNode(value, null);
			last = new ListNode(value, null);
		}
		else
		{
			ListNode temp = first;
			while(temp.getNext() != null)
			{
			   temp = temp.getNext();
			}
			temp.setNext(new ListNode(value, null));
			last = temp.getNext();
		}
	}

	public int size()
	{
		int sizeCount = 0;
		ListNode temp = first;
		if(first == null)
			return sizeCount;
		while (temp != null)
		{

			temp = temp.getNext();
			sizeCount++;
		}
		return sizeCount;
	}


    public void clear()
    {
        first = null;
        last = null;
    }

	public void testFind(String name)
	{

		ListNode node = first;

		while(node.getNext()!=null && !(((Representative)(node.getValue())).getLastName().equalsIgnoreCase(name)))
		{
			node = node.getNext();
		}
		System.out.println();
		if((((Representative)(node.getValue())).getLastName().equalsIgnoreCase(name)))
			System.out.println(((Representative)(node.getValue())));
		else
			node = null;
		if(node == null)
			System.out.println(name + " could not be found.");
		System.out.println();
	}

	public void testDelete()
	{
		Scanner console = new Scanner(System.in);
		String lastName = "";
		boolean quit = false;

		do
		{
			System.out.print("Enter a Representative's last name to delete (Q to quit): ");
			lastName = console.nextLine();
			if(lastName.equalsIgnoreCase("Q"))
				quit = true;

			if(!quit)
			{
				ListNode prev = null;
				ListNode node = first;

				while(node.getNext()!=null && !(((Representative)(node.getValue())).getLastName().equalsIgnoreCase(lastName)))
				{
					prev = node;
					node = node.getNext();
				}

				System.out.println();
				if((((Representative)(node.getValue())).getLastName().equalsIgnoreCase(lastName)))
				{
					if(prev!=null)
					{
						prev.setNext(node.getNext());
						System.out.println(lastName + " was deleted.");
					}
					else
					{
						first = node.getNext();
						System.out.println(lastName + " was deleted.");
					}
				}
				else
					node = null;
				if(node == null)
					System.out.println(lastName + " could not be found, so was not deleted.");
				System.out.println();
			}
		}
		while(!quit);
	}


	public void printList()
	{
		int cur = 1;
		ListNode temp = first; // start at the first node
		while (temp != null)
		{
			System.out.printf("%3d " + temp.getValue() + "\n", cur);
			cur++;
			temp = temp.getNext(); // go to next node
		}
	}

	public void printBackwards()
	{
		goBack(first);
	}

	public void goBack(ListNode node)
	{
		if(node==null)
			return;
		goBack(node.getNext());
		System.out.println(node.getValue());
	}

	public void bubbleSortName()
	{
		for (int outer = 0; outer < size() - 1; outer++)
		{
			for (int inner = 0; inner < size()-outer-1; inner++)
			{
				Representative rep = getRepresentative(inner);
				Representative rep2 = getRepresentative(inner+1);

				if(rep.getLastName().compareTo(rep2.getLastName()) > 0)
				{
					swap(rep, rep2);
				}
			}
		}
	}

	public void selectionSortYear ()
	{
		int max, temp;

		for (int outer = size(); outer > 1; outer--)
		{
			max = 0;
			for (int inner = 1; inner < outer; inner++)
			{
				Representative rep = getRepresentative(inner);
				Representative rep2 = getRepresentative(max);
				if (rep.compareTo(rep2) < 0)
				{
					max = inner; // a new largest item is found
				}
			}

			swap(getRepresentative(outer-1), getRepresentative(max));
		}
	}

	public void swap(Representative rep1, Representative rep2)
    {
    	ListNode node1 = first;
    	ListNode node2 = first;

		while(!(((Representative)(node1.getValue())).equals(rep1)))
		{
			node1 = node1.getNext();
		}

		while(!(((Representative)(node2.getValue())).equals(rep2)))
		{
			node2 = node2.getNext();
		}

        if (!(node1.equals(node2)))
        {
	        ListNode cur1 = node1;
	        ListNode prev1 = getPrev(cur1);
	        ListNode cur2 = node2;
	        ListNode prev2 = getPrev(cur2);

	        // if either cur1 or cur2 are null, do not swap
	        if (cur1 == null || cur2 == null)
	            return;

	        // if cur1 is not head of linked list
	        if (prev1 != null)
	            prev1.setNext(cur2);
	        else //make cur2 the new head
	            first = cur2;

	        // if cur2 is not head of linked list
	        if (prev2 != null)
	            prev2.setNext(cur1);
	        else // make cur1 the new head
	            first = cur1;

	        // swapping the pointers
	        ListNode temp = cur1.getNext();
	        cur1.setNext(cur2.getNext());
	        cur2.setNext(temp);
    	}
    }

	public ListNode getPrev(ListNode node)
	{
		if(node.equals(first))
			return null;

		ListNode temp = first;

		while(!(temp.getNext().equals(node)))
		{
			temp = temp.getNext();
		}

		return temp;
	}

	public Representative getRepresentative(int index)
	{
		ListNode node = first;
		int curIndex = 0;

		while(curIndex!=index)
		{
			node = node.getNext();
			curIndex++;
		}

		return (Representative)(node.getValue());
	}


}
