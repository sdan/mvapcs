public class Test
{
  public static void main(String[]args)
  {
    Test tomorrow = new Test();
    //tomorrow.first();
    //tomorrow.guessTheString("MickeyMouse");
    //tomorrow.stringMethods();
    tomorrow.run();
  }
  public void run()
  {
    //exOut("Good Work","o");
    //exOut("This is bliss.","is");
    //exOut("Hello there!","ere");
    repeatBuild("Monta");
    //repeatBuild("Crazy");
    //repeatBuild("");
    //repeatBuild("cool");
    //repeatBuild("Loopy");
  }
  public void first()
  {
    String word = new String("JUMBLE");
    String result = new String("");
    for(int i = 1;i<word.length();i++)
    {
      result+=word.substring(i,i+1);
      if(i+2<word.length())
      {
        result+=word.substring(i,i+2);
      }
      System.out.println(result);
    }
  }

  public void guessTheString(String word)
  {
    String result = new String("");
    char first = word.toLowerCase().charAt(0);
    switch(first)
    {
      case 'a': case 'e': case 'i': case 'o': case 'u':
      result = word+"-ay";
      break;
      default:
      result = word.substring(1,2).toUpperCase()+word.substring(2)+"-"+first+"ay";
    }
    System.out.println(result);
  }

  public void stringMethods()
  {
    String goodGuy = new String("road runner");
    String badGuy = new String("coyote");
    char oneChar = 'A';
    String animal = goodGuy;
    goodGuy = "road runner";

    System.out.println(badGuy.length());
    System.out.println(badGuy.indexOf('e'));
    System.out.println(oneChar+5);
    System.out.println(animal==goodGuy);
    System.out.println(animal.equals(goodGuy));
    System.out.println(badGuy.substring(0,3)+goodGuy.substring(4));

  }

  public void exOut(String phrase, String keep)
	{
		int index = phrase.indexOf(keep);
		int start = 0;
		while(index != -1 && index < phrase.length())
		{
		    for(int i = start; i < index; i++)
			{
				phrase = phrase.substring(0,i) + "X" + phrase.substring(i+1);
			}
			start = index+keep.length();
			index = phrase.indexOf(keep,index+1);
		}


		for(int i = start; i < phrase.length(); i++)
		{
			phrase = phrase.substring(0,i) + "X" + phrase.substring(i+1);
		}
		System.out.println(phrase);
	}

  public void repeatBuild(String word)
  {
    System.out.println("enter");
    int length = word.length();
    String better = "";
  	if(length==0)
    {
      System.out.println("nothing");
    }
  	else
  	{
  		for(int i = 0;i<=length;i++)
  		{
  			better+=word.substring(0,word.length()-i);
  		}
      System.out.println(better);
  	}
    System.out.println("exit");
  }

}
