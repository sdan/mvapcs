/**
 * TreeTester.java
 * @author Surya Dantuluri
 * @version 1.0
 * @since 5/14/2018
 */

import java.util.Scanner;

public class TreeTester
{
	public static void main ( String [] args )
	{
		RepresentativeList order = new RepresentativeList();
		order.mainMenu();
	}

	public void mainMenu ()
	{
		BinarySearchTree bst = new BinarySearchTree();

		String name;
		Scanner console = new Scanner(System.in);

		System.out.println("\n\n");
		do
		{
			System.out.println("\nBinary Search Tree algorithm menu\n");
			System.out.println("(1) Read data from file");
			System.out.println("(2) Print list ordered by College name");
			System.out.println("(3) Search list by College name");
			System.out.println("(4) Delete from list by College name");
			System.out.println("(5) Count nodes in list");
			System.out.println("(6) Clear entire list");
			System.out.println("(Q) Quit\n");
			do
			{
				System.out.print("Choice ---> ");
				choice = console.nextLine() + " ";
				System.out.println();
			}
			while((choice.charAt(0) < '1' || choice.charAt(0) > '8') && (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q'));

			if ('1' <= choice.charAt(0) && choice.charAt(0) <= '8')
			{
				switch (choice.charAt(0))
				{
					case '1' :
						System.out.print("Enter a file name: ");
						name = console.nextLine();
						bst.loadData(name);
						break;
					case '2' :
						System.out.println();
						System.out.println("The list printed in order by name\n");
						list.selectionSortYear();
						list.printList();
						System.out.println();
						break;
					case '3' :
                        String name = "";
                        boolean exit = false;
                        do
                        {
                            System.out.print("Enter a Representative's last name to be searched (Q to quit): ");
                            name = console.nextLine();
                            if(name.equalsIgnoreCase("q"))
                                exit = true;
                            if(!exit)
                               list.testFind(name);

                        }
                        while(!exit);
						break;
					case '4' :
						list.testDelete();
						break;
					case '5' :
						list.clear();
						break;
					case '6' :
						System.out.println("Number of nodes = " + list.size ());
						System.out.println();
						break;
				}
			}
		}
		while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
	}
}
