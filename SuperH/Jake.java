public class Jake
{
public static void main(String[]args)
{
  Jake paul = new Jake();
  paul.dog();
}
public void dog()
{
  String dude = "bent";
  System.out.println(dude.substring(0,3));
}

public String exOut(String phrase, String keep)
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
		return phrase;
	}

}
