
public class WorkingWithParameters
{
	public static void main (String [] args)
	{
		WorkingWithParameters run = new WorkingWithParameters();
		run.changeValues();
		run.changeMore();
	}
	public void changeValues ( )
	{
		char letter1 = 'c', letter2 = 's';
		int [] value = {2,4,6};
		printLetters(letter1, letter2, value);
		changeLetters(letter1, letter2, value);
		printLetters(letter1, letter2, value);
	}

	public void printLetters (char let1, char let2, int [] v)
	{
		System.out.println(let1 + "  " + let2 + "  " + v[0] + "  " + v[1] + "  " + v[2]);
	}

	public void changeLetters (char let1, char let2, int [] v)
	{
		let1 = 'a';
		let2 = 'p';
		v[0] = 1;
		v[1] = 3;
		v[2] = 5;
		printLetters(let1, let2, v);
	}

	public void changeMore ( )
	{
		String course = "APCS A", name = "JAVA";
		printStrings(course, name);
		changeStrings(course, name);
		printStrings(course, name);
	}

	public void printStrings (String s1, String s2)
	{
		System.out.println(s1 + "  " + s2);
	}

	public void changeStrings (String s1, String s2)
	{
		s1 = new String("MONTA");
		s2 = new String("VISTA");
		printStrings(s1, s2);
	}
}
