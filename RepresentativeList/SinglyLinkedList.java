import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

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
				System.out.println("\n\n\n");
                temp = inFile.nextLine();
                district = temp.substring(0,temp.indexOf(' '));
                temp = temp.substring(temp.indexOf(',')+1).trim();
                firstName = temp.substring(0,temp.indexOf(' '));
                temp = temp.substring(temp.indexOf(' ')).trim();
                lastName = temp.substring(0,temp.indexOf(','));
                temp = temp.substring(temp.indexOf(',')+1).trim();
                birthMonth = Integer.parseInt(temp.substring(0,temp.indexOf('/')));
                temp = temp.substring(temp.indexOf('/')+1).trim();
                birthDay = Integer.parseInt(temp.substring(0,temp.indexOf('/')));
                temp = temp.substring(temp.indexOf('/')+1).trim();
                birthYear = Integer.parseInt(temp.substring(0,temp.indexOf(' ')));
                temp = temp.substring(temp.indexOf(' ')).trim();
                party = temp.substring(0,temp.indexOf(' '));
                temp = temp.substring(temp.indexOf(' ')).trim();
                firstElected = Integer.parseInt(temp);




				//String d, String f, String l, int bm, int bd, int by, String p, int e
                //System.out.println("district "+district);
                //System.out.println("firstName "+firstName);
                //System.out.println("lastName "+lastName);
                //System.out.println("birthMonth "+birthMonth);
                //System.out.println("birthDay "+birthDay);
                //System.out.println("birthYear "+birthYear);
                //System.out.println("party "+party);
                //System.out.println("firstElected "+firstElected);
                addLast(new Representative(district,firstName,lastName,birthMonth,birthDay,birthYear,party,firstElected));
                System.out.println("\n\n\n");
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

	}

	public void selectionSortYear()
	{
		for (ListNode outer = getFirst(); outer.getNext()!=null ; outer.getNext())
		{
			ListNode min = outer;
			ListNode temp = null;
			for(ListNode inner = outer.getNext(); inner!=null; inner.getNext())
				if(((Representative)min.getBirthYear()>(Representative)inner.getNext().getBirthYear())
				{
					min = inner.getNext();
					temp = inner;
				}

			if(min!=outer)
				swap(getFirst(), getFirst(), min, temp);
		}
	}

	public void swapNodes(ListNode head, ListNode currX,ListNode currY, ListNode prevY)
	{
		// make 'currY' as new head
		head = currY;
		// adjust links
		prevY.next = currX;

		// Swap next pointers
		ListNode temp = currY.next;
		currY.next = currX.next;
		currX.next = temp;
	}


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
		}
	}

	public int size()
	{
		int sizeCount = 0;
		ListNode temp = first; // start at the first node
		while (temp != null)
		{
			sizeCount++;
			temp = temp.getNext(); // go to next node
		}
		return sizeCount;
	}


	public void printList()
	{
		ListNode temp = first; // start at the first node
		while (temp != null)
		{
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext(); // go to next node
		}
	}
}
