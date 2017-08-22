
public class TestInput
{
    public static void main (String [] args)
    {
        TestInput run = new TestInput();
        run.getInts();
        run.getDoubles();
        run.getChars();
    }

    public void getInts ( )
    {
        System.out.println("\n\n\n");
        int value1 = Prompt.getInt("\nPlease enter any integer: ");
        int value2 = Prompt.getInt("\nPlease enter an age value",12,75);
        System.out.println("\n\n" + value1 + "    " + value2 + "\n");
    }

    public void getDoubles ( )
    {
        double value1 = Prompt.getDouble("\nPlease enter any double: ");
        double value2 = Prompt.getDouble("\nPlease enter a weight",5.0,400.0);
        System.out.printf("%n%n%10.2f%10.2f%n%n",value1,value2);
    }

    public void getChars ( )
    {
        char mychar = Prompt.getChar("\nPlease enter any char: ");
        char [] possible = {'f','F','m','M'};
        char gender = Prompt.getChar("\nPlease enter a character for your gender (M or F)", possible);
        System.out.println("\n\n" + mychar + "    " + gender);
        System.out.println("\n\n\n");
    }
}
