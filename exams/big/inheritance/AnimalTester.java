public class AnimalTester
{
	public static void main(String[] args)
	{
		Dog myAnimal = new Lab();
		myAnimal.testClassMethod();
		myAnimal.testInstanceMethod();
	}
}

class Animal
{
	public static void testClassMethod()
	{
		System.out.println("The class method in Animal.");
	}

	public void testInstanceMethod()
	{
		System.out.println("The instance method in Animal.");
	}
}

class Dog extends Animal
{
	public static void testClassMethod()
	{
		System.out.println("The class method in Dog.");
	}

	public void testInstanceMethod()
	{
		System.out.println("The instance method in Dog.");
	}
}

class Cat extends Animal
{
    public static void testClassMethod()
    {
        System.out.println("This class method in Cat");
    }

    public void testInstanceMethod()
    {
        System.out.println("The instance method in Cat.");
    }
}

class Poodle extends Dog
{
    public static void testClassMethod()
	{
		System.out.println("The class method in Poodle.");
	}

	public void testInstanceMethod()
	{
		System.out.println("The instance method in Poodle.");
	}
}

class Lab extends Poodle
{
    public static void testClassMethod()
	{
		System.out.println("The class method in Lab.");
	}

	public void testInstanceMethod()
	{
		System.out.println("The instance method in Lab.");
	}
}
