public class ClassTester
{
	public static void main (String [] args)
	{
		Dog c1 = new Dog();
		Dog c2 = new Lab();
		Lab c3 = new Lab();
		c3.special();
		//c1.methodTwo();
		//c2 not involved
		// c2.methodTwo();
		// c2.hey();
		///c2.methodOne();
		//doesnt work because m1 isnt in classtwo
	}
}

class Dog
{

	public static void hey()
	{
		System.out.println("HEY in DOG");
	}

	public void special()
	{
		System.out.println("i am the glob glob");
	}

	public void methodOne ( )
	{
		System.out.println("1 1");
	}

	public void methodTwo()
	{
		System.out.println("1 2");
	}
}

 class Lab extends Dog
{

	public static void hey()
	{
		System.out.println("HEY in LAB");
	}

	public void methodTwo ( )
	{
		System.out.println("2 2");
	}


}
