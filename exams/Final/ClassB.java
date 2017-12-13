public class ClassB extends ClassA implements InterfaceB
{
	public static void main (String [] args)
	{
		InterfaceA obj1 = new ClassA();
//		InterfaceB obj2 = new ClassA();
		InterfaceA obj3 = new ClassB();
		InterfaceB obj4 = new ClassB();
		ClassA obj5 = new ClassB();
	}

	public ClassB ( )
	{

	}
	public void methodA();
	//  methods not shown
}

interface InterfaceA
{
	public void methodA();
}

interface InterfaceB extends InterfaceA
{
	public void methodB();
}

class ClassA implements InterfaceA
{
	public void methodA ( )
	{

	}

	public void methodB ( )
	{

	}
}
