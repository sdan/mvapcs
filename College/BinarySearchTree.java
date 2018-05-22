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

	public void clear ( )
	{
	}

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
            inFile.nextLine();
            while(inFile.hasNext())
            {

				String line = inFile.nextLine();

				collegeName = line.substring(0,line.indexOf(" "));
				line = line.trim(line.substring(line.indexOf(" ")));
				city = line.substring(0,line.indexOf(" "));
				line = line.trim(line.substring(line.indexOf(" ")));
				state = line.substring(0,line.indexOf(" "));
				line = line.trim(line.substring(line.indexOf(" ")));
				tuition = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line = line.trim(line.substring(line.indexOf(" ")));
				year = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line = line.trim(line.substring(line.indexOf(" ")));
				enrolled = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line = line.trim(line.substring(line.indexOf(" ")));
				grad = Double.parseInt(line.trim(line));

				insert(new College(collegeName, city, state, tuition, year, enrolled, grad));
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
	}

	//done
	public void printList(TreeNode node)
	{
		if(node!=null)
		{
			printList(node.getLeft());
			System.out.println(node.getValue());
			printList(node.getRight());
		}
	}

	public void search(TreeNode node, String name)
	{
	    if (root==null || (College)node.getName().equals(name))
	        return root;

	    if ((College)node.getName().compareTo(name)>0)
	        return search(node.getLeft(), name);

	    return search(node.getRight(), name);
	}

    void deleteNode(String name)
    {
        root = delete(root, name);
    }

    TreeNode delete(TreeNode node, String name)
    {
        if (node == null)
			return node;

		if((College)node.compareTo(name)>0)
            root.left = delete((College)node.getLeft(), name);
        else if ((College)node.compareTo(name)<0)
            root.right = delete((College)node.getRight(), name);

        else
        {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();


            node = lowest(College)node.getRight());

            (College)node.setRight(delete(node.getRight()), (College)node.getName());
        }

        return node;
    }

	String lowest(TreeNode node)
    {
        String name = (College)node.getName();
        while (node.getLeft() != null)
        {
            String name = (College)node.getLeft().getName();
            TreeNode node = node.getLeft();
        }
        return name;
    }

	int countNode()
	{
		System.out.println("Number of nodes = "+counter(root)); //calls the counter method
	}

	int count(TreeNode node)
	{
		if(node == null)
			return 0;

		if(node.getLeft() == null && node.getRight() == null)
			return 1;

		return 1 + count(node.getLeft()) + count(node.getRight());
	}



}
