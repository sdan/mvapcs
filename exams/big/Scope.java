
public class Scope
{
	private int number;

	public Scope ( )
	{
		int number = 1000000000;
	}

	public static void main(String [] args)
	{
		Scope run = new Scope();
		run.methods();
	}

	public void methods ( )
	{
		System.out.println("init "+number);
		method1(number);
		System.out.println(number); //0
		number += 20;
		method2();
		System.out.println(number);
	}

	public void method1(int number)
	{
		System.out.println(number); //0
		number += 30;
		System.out.println(number); //30
	}

	public void method2 ( )
	{
		System.out.println(number); //10
		number += 40;
		System.out.println(number); //50
	}
}
