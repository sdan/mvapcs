import java.util.NoSuchElementException;

public class SinglyLinkedList
{
	private ListNode first;
	private ListNode last;

	public SinglyLinkedList()
	{
		first = null;
		last = null;
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
