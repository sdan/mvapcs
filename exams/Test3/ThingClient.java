public class ThingClient
{
	public static void main (String [] args)
	{
		ThingOne th1 = new ThingOne();
		ThingOne th2 = new ThingTwo();
		//th1.methodTwo();
		th2.methodTwo();
		th2.methodOne();
	}
}

class ThingOne
{
	public void methodOne ( )
	{
		System.out.println("Thing One!");
	}
}

class ThingTwo extends ThingOne
{
	public void methodTwo ( )
	{
		System.out.println("Thing Two!");
	}
}
