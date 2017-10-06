public class Test3
{
  public static void main(String[]args)
  {
    Test3 testClassObject3 = new Test3();
    //testClassObject3.variableChange();
    //testClassObject3.codeFrag();
    //testClassObject3.basicOperations();
    //testClassObject3.methodThree();
    testClassObject3.secondTest();
  }
  public void variableChange()
  {
    int ahab = 5;
    int moby = 6;
    int stubb = 11;
    do
    {
      if(moby%ahab>2)
      {
        ahab++;
        //System.out.println("ahab "+ahab);
      }
      else if(moby%ahab<2)
      {
        ahab--;
        moby++;
        //System.out.println("ahab "+ahab+" moby "+moby);
      }
      if(stubb/ahab==2)
      {
        stubb--;
        //System.out.println("stubb "+stubb);
      }
      else
      {
        stubb++;
        moby+=2;
        //System.out.println("stubb "+stubb+" moby "+moby);
      }
      System.out.println(ahab+" "+moby+" "+stubb);
    }while(stubb/moby>=1);
  }

  public void codeFrag()
  {
    for(int row =1;row<=5;row++)
    {
      int col =1;
      while(col<=5)
      {
        if(row%col==1)
        System.out.print(row);
        else
        System.out.print("*");
        col++;
      }
      System.out.println();
    }
  }

  public void basicOperations()
  {
    int integre = 5;
    double doble = 5.0;
    char somechar = '1';
    char anotherchar = 'a';
    char anotherone = 'o';
    int something = somechar%50;
    System.out.println(somechar%5+" "+somechar%50);
    if(2.0==2)
    System.out.println("2 is 2.0");
    else if(2.0!=2)
    System.out.println("2 is not 2.0");
  }

	public void methods ( )
	{
		System.out.println("\n\n");
		methodOne();
		System.out.println("\n\n");
		methodTwo();
		System.out.println("\n\n");
		methodThree();
		System.out.println("\n\n");
		System.out.println(alternate("pot","cab"));
		System.out.println(alternate("mixed","up"));
		System.out.println(alternate("excellent","work"));
		System.out.println(alternate("long","weekend"));
		System.out.println("\n\n");
		int [] array = {10, 20, 30, 40, 50, 60};
		System.out.println(positionOfClosest(array, 47));
		System.out.println(positionOfClosest(array, 23));
		System.out.println(positionOfClosest(array, 83));
		System.out.println(positionOfClosest(array, 1));
		System.out.println("\n\n");
		printArray(countVowels("aardvark"));
		printArray(countVowels("programming"));
		printArray(countVowels("EXCELLENT!"));
		printArray(countVowels("COOL METHOD"));
		System.out.println("\n\n");
	}

	public void methodOne ( )
	{
		int x = 2;
		int number = 3;
		int value = 10;

		while (value < 18)
		{
			if (value % number  == 0)
			{
				value++;
				number++;
			}
			else if (value % x == 0)
			{
				value++;
				x++;
			}
			else
			{
				number--;
				x--;
			}
			value++;
			System.out.println(x + "   " + number + "   " + value);
		}
	}

	public void methodTwo ( )
	{
		for (int row = 1; row <= 5; row++)
		{
			int column = 1;
			while (column <= 5)
			{
				if (row == column || row + column == 5)
					System.out.print(row);
				else
					System.out.print("*");      //  an asterisk
				column++;
			}
			System.out.println();              		  //  a new line
		}
	}

	public void methodThree ( )
	{
		System.out.println("\n" + ((int) (Math.PI * 100) == 314));
		System.out.println("" + (89.0 / 23 + 67 - 16 % 17 * 4));
    System.out.println((int)(89.0/23));
		System.out.println("" + (!( 65 > 4 * 15 || false)));
		System.out.println("" + (! (8 / 7.8 > 1 && true) || (int) 7.4 < 7.4));
		System.out.println("" + (65 * 10.0 > 1324 / 4 && 30 / 9 < 3.0 || ! true));
		System.out.println();
	}

	public String alternate (String one, String two)
	{
		String result = new String("");
		for(int i = 0; i < one.length() || i < two.length(); i++)
		{
			if(i < one.length())
			{
				result += one.charAt(i);
			}
			if(i < two.length())
			{
				result += two.charAt(i);
			}
		}
		return result;
	}

	public int positionOfClosest  (int [] a, int value)
	{
		int index = 0, dist = Math.abs(value - a[0]);
		for(int i = 1; i < a.length; i++)
		{
			if(Math.abs(value - a[i]) < dist)
			{
				index = i;
				dist = Math.abs(value - a[i]);
			}
		}
		return index;
	}

	public int [] countVowels(String str)
	{
		str = str.toUpperCase();
		int [] vowelCount = new int[5];
		for(int i = 0; i < str.length(); i++)
		{
			switch(str.charAt(i))
			{
				case 'A':	vowelCount[0]++;	break;
				case 'E':	vowelCount[1]++;	break;
				case 'I':	vowelCount[2]++;	break;
				case 'O':	vowelCount[3]++;	break;
				case 'U':	vowelCount[4]++;	break;
			}
		}
		return vowelCount;
	}

	public void printArray(int [] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + "  ");
		}
		System.out.println();
}
public void secondTest()
{
  int ab = 15;
  for(int cd = 120; cd>0;cd-=ab)
  {
    System.out.print("loop ");
    System.out.print("next ");
    System.out.printf("\n %d , %d \n",ab,cd);
  }
  thirdTest();
}

public void thirdTest()
{
  char dee = 'd';
  while(dee!='D')
  {
    dee-=8.0;
    System.out.println((int)dee);
    System.out.println((double)dee);
    System.out.println(dee);
  }
  fourTest();
}

public void fourTest()
{
  System.out.println("spocy");
  System.out.println(12 % 5 != 2.0);
  //System.out.println((! 65 > 4 * 15 || false));
  System.out.println((8 * 4 % 16 != 5) && (44 / 11 + 5 >= 31));
  System.out.println((int) 7.4 < 7.4 || ! (5.6 / 7.8 > 1 && true) );
  System.out.println((5 +(-2) * 4 + 6.5) + 24 / 6 % 2);
}


}
