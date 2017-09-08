import java.util.Scanner;
public class Coding
{
  int data;
  int hello;
  String hellothere;
  public Coding()
  {
    data = 1;
  }
  public static void main(String [] args)
  {
    Dice panda = new Dice(5);
    Coding monkey = new Coding();
    monkey.init();
    System.out.println("heojdaisjdoaisjd");
  }
  public void init()
  {
    hellothere = Prompt.getString("Enter string: ");
    delDel(hellothere);
  }
  public String delDel(String str)
  {
      // if(str.substring(str.indexOf(0),str.indexOf(3))=='del')
      // return str.indexOf(0)+str.substring(str.indexOf(1),str.length()-1);
      // else
      // return str;
      return "whats";
  }

}
