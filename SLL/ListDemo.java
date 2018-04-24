public class ListDemo
{
	public static void main (String [] args)
	{
		ListNode list;
		list = new ListNode(new Integer(13), null);
		System.out.println("\n\nThe node contains: " + (Integer)list.getValue());

		list.setValue(new Integer(17));
		System.out.println("\n\nThe node contains: " + (Integer)list.getValue());

		SinglyLinkedList mylist;
		mylist = new SinglyLinkedList();
		for (int i = 0; i < 10; i++)
		{
			mylist.addFirst(new Integer(i*i));
		}
		System.out.println("\n\n\n");
		mylist.printList();
		System.out.println("\n\n\n");




		System.out.println("\n\n\n");

		SinglyLinkedList thisList;
		thisList = new SinglyLinkedList();
		for (int i = 0; i < 20; i++)
		{
			thisList.addLast(new Integer(i+1));
		}

		System.out.println("First Element: "+(Integer)thisList.getFirst());
		System.out.println("Last Element: "+(Integer)thisList.getLast());
		System.out.print("SinglyLinkedList: ");
		thisList.printList();
		System.out.println("\nNodes: "+thisList.size());

		System.out.println("\n\n\n");



	}
}
