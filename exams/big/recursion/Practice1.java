public class Practice1
{
	public static void main(String[]args)
	{
		Practice1 hello = new Practice1();
		hello.run();
	}

	public void run()
	{
		printSomething("ABCD");
	}

	public void printSomething(String s)
	{
		int n = s.length();
		if(n<1)
			return;
		String s1 = s.substring(1,n);
		printSomething(s1);
		System.out.println(s);
		printSomething(s1);
	}
}