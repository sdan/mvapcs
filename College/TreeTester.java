/**
 * TreeTester.java
 * User interface for College
 * @author Surya Dantuluri
 * @version 1.0
 * @since 5/31/2018
 */

import java.util.Scanner;

public class TreeTester
{
	public static void main ( String [] args )
	{
		TreeTester order = new TreeTester();
		order.mainMenu();
	}

	public void mainMenu ()
	{
		BinarySearchTree bst = new BinarySearchTree();

		String name, choice;
		Boolean exit = false;
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
						bst.printRun();
						System.out.println();
						break;
					case '3' :
                        name = "";
                        exit = false;
                        do
                        {
                            System.out.print("Enter a College name to be searched (Q to quit): ");
                            name = console.nextLine();
                            if(name.equalsIgnoreCase("q"))
                                exit = true;
                            if(!exit)
							{
								System.out.println("");
								bst.searchNode(name);
								System.out.println("");
							}

                        }
                        while(!exit);
						System.out.println("");
						break;
					case '4' :
						name = "";
						exit = false;
						do
						{
							System.out.print("Enter a College name to be removed (Q to quit): ");
							name = console.nextLine();
							if(name.equalsIgnoreCase("q"))
								exit = true;
							if(!exit)
							   bst.deleteNode(name);

						}
						while(!exit);
						break;
					case '5' :
						System.out.println("Number of nodes = " + bst.countNode());
						System.out.println();
						break;
					case '6' :
						bst.clear();
						System.out.println();
						break;
				}
			}
		}
		while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
	}
}
