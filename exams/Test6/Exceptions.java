/**
 * The APCS exam tests for the following exceptions.
 *	- ArithmeticException
 *	- NullPointerException
 *	- IndexOutOfBoundsException
 *	- ArrayIndexOutOfBoundsException
 *	- IllegalArgumentException
 */

public class Exceptions 
{
	public static void main(String[] args) 
	{
		Exceptions exc = new Exceptions();
		exc.run();
	}
	
	public void run() 
	{
		System.out.println("\n\n");
		arithmetic();
		nullPointer();
		indexBounds();
		arrayIndexBounds();
		illegalArgument();
		System.out.println("\n\n");
	}
	
	public void arithmetic() 
	{
		int x = 1;
		int y = 0;
		try 
		{
			int z = x / y;
		}
		catch (ArithmeticException e) 
		{
			System.out.println("ERROR: ArithmeticException");
		}
	}
	
	public void nullPointer() 
	{
		Integer [] arr = new Integer [10];
		try 
		{
			int z = arr[0].intValue();
		}
		catch (NullPointerException e) 
		{
			System.out.println("ERROR: NullPointerException");
		}
	}
	
	public void indexBounds() 
	{
		String hello = "Hello";
		try 
		{
			char c = hello.charAt(hello.length());
		}
		catch (IndexOutOfBoundsException e) 
		{
			System.out.println("ERROR: IndexOutOfBoundsException");
		}
	}
	
	public void arrayIndexBounds() 
	{
		int [] arr = new int [10];
		try 
		{
			int k = arr[10];
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("ERROR: ArrayIndexOutOfBoundsException");
		}
	}
	
	public void illegalArgument() 
	{
		String str = "hello";
			System.out.printf("%d\n", str);
			System.out.println("ERROR: IllegalArgumentException");

	}
}
