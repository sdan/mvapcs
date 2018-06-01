/**
 * BinarySearchTree.java
 * A Binary Search Tree data structure.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 5/31/2018
 */

import java.util.NoSuchElementException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree ( )
	{
		root = null;
	}

	/**
	*	Loads data from file
	*/
	public void loadData(String fileName)
	{
		String collegeName;
		String city;
		String state;
		int tuition;
		int year;
		int enrolled;
		double grad;

        try
        {
            Scanner inFile = new Scanner(new File(fileName));
            while(inFile.hasNext())
            {

				String line = inFile.nextLine();

				collegeName = line.substring(0,line.indexOf(" "));
				line = line.substring(line.indexOf(" ")).trim();
				city = line.substring(0,line.indexOf(" "));
				line = line.substring(line.indexOf(" ")).trim();
				state = line.substring(0,line.indexOf(" "));
				line = line.substring(line.indexOf(" ")).trim();
				tuition = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line = line.substring(line.indexOf(" ")).trim();
				year = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line = line.substring(line.indexOf(" ")).trim();
				enrolled = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line = line.substring(line.indexOf(" ")).trim();
				grad = Double.parseDouble(line.trim());

				insert(root,new College(collegeName, city, state, tuition, year, enrolled, grad));
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
	}

	/**
	*	Inserts new TreeNode object into BST
	*/
	public void insert (TreeNode node, Object data)
	{
		if(root == null)
		{
			root = new TreeNode(data);
		}
		else
		{
			if((((College)data)).compareTo(((College)node.getValue())) > 0)
			{
				if(node.getRight()==null)
					node.setRight(new TreeNode(data));
				else
					insert(node.getRight(), data);
			}
			else
			{
				if(node.getLeft()==null)
					node.setLeft(new TreeNode(data));
				else
					insert(node.getLeft(), data);
			}
		}
	}

	/**
	*	Recursive runner helper method for printing all nodes in BST
	*/
	public void printRun()
	{
		printList(root);
	}

	/**
	*	Prints list
	*/
	public void printList(TreeNode node)
	{
		if(node!=null)
		{
			printList(node.getLeft());
			System.out.println((College)node.getValue());
			printList(node.getRight());
		}
	}


	/**
	*	Searches for TreeNode in BST by name
	*/
	public void searchNode(String name)
    {
		TreeNode node = search(root, name);
				if(node != null)
					System.out.println(node.getValue());
				else
					System.out.println(name+" could not be found.");
				System.out.println("\n");
    }

	/**
	* Helper method to deletion. Evaluates if there is a TreeNode with the @param name as its name.
	*/
	public boolean isValid(String name)
    {
		TreeNode node = search(root, name);
				if(node != null)
					return true;
				else
					return false;
    }

	/**
	*	Recursively searches for TreeNode.
	*/
	TreeNode search(TreeNode node, String name)
	{
		if(node == null)
		{
			return node;
		}
		int diff = name.toLowerCase().compareTo(((College)node.getValue()).getName().toLowerCase());
		if(diff == 0)
				return node;
		else if(diff > 0)
			return search(node.getRight(), name);
		else
			return search(node.getLeft(), name);

	}

	/**
	* Helper method to deletion method.
	*/
    public void deleteNode(String name)
    {

		if(!isValid(name))
			System.out.println("\nSorry, but "+name+" could not be found\n");
		else
		{
			root = delete(root, name);
			System.out.println("\n"+name+" was removed from the BST\n");
		}

    }

	/**
	*	Deletes TreeNode in BST
	*/
    TreeNode delete(TreeNode node, String name)
    {
		if(node == null)
		        return node;
		        int diff = name.toLowerCase().compareTo(((College)node.getValue()).getName().toLowerCase());
		        if(diff > 0)
		            node.setRight(delete(node.getRight(), name));
		        else if(diff < 0)
		            node.setLeft(delete(node.getLeft(), name));
		        else{
		            if(node.getLeft() == null)
		                return node.getRight();
		            else if(node.getRight() == null)
		                return node.getLeft();

		        TreeNode recur = root;
		        while(recur.getLeft() != null){
		            recur = recur.getLeft();
		        }
		        node.setValue(recur.getValue());
		        String find = ((College)(node.getValue())).getName();
		        node.setRight(delete(node.getRight(), find));

		    return node;

	}

	/**
	*	Returns name of College that is the lowest (farthest to the left) of the BST.
	*/
	String lowest(TreeNode node)
    {
        String name = ((College)node.getValue()).getName();
        while (node.getLeft() != null)
        {
            name = ((College)(node.getLeft().getValue())).getName();

			node = node.getLeft();
        }
        return name;
    }

	/**
	*	Helper method to start counting nodes in BST.
	*/
	int countNode()
	{
		return count(root);
	}

	/**
	*	Recursively counts Nodes in BST.
	*/
	int count(TreeNode node)
	{
		if(node == null)
			return 0;

		if(node.getLeft() == null && node.getRight() == null)
			return 1;

		return 1 + count(node.getLeft()) + count(node.getRight());
	}

	/**
	*	Clears entire BST.
	*/
	public void clear ()
	{
		root = null;
	}



}
