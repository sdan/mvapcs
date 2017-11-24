import java.util.List;
import java.util.ArrayList;
public class Bird
{
  public ArrayList<Turkey> food;
  private ArrayList<String> llamar;
  private int numberOfTurkeys;
  public Bird(int num, ArrayList<String> names)
  {
    food = new ArrayList<Turkey>();
    llamar = new ArrayList<String>(names);
    numberOfTurkeys = num;

  }

  public void generateTurkey()
  {
    for (int i = 0;i<numberOfTurkeys;i++) {
      // System.out.println(llamar.get(i));
      String temp = llamar.get(i);
      food.add(new Turkey(temp));
    }
  }

  public void age()
  {
      for(int i = 0;i<food.size();i++)
      {
        food.get(i).setAge((int)Math.random()*100);
      }
  }

  public void traits()
  {
    for (int i = 0;i<food.size();i++ ) {
      food.get(i).setTraits(0,(int)Math.random()*10);
    }
  }

  public void friends()
  {
    for (int i = 0;i<food.size();i++) {
      // System.out.println("i in bird: "+i);
      String woah = random();
      // System.out.println("rand in bird: "+woah);
      food.get(i).setFriends(i,woah);
    }
  }

  public void dimensions()
  {
    for (int i = 0;i<food.size();i++) {
      food.get(i).setDimensions(ran(),ran(),rant());
    }
  }
  public int ran()
  {
    return (int)Math.random()*3;
  }
  public char rant()
  {
    int n = (int)Math.random()*5;
    switch(n)
    {
      case 1: return '/';
      case 2: return '#';
      case 3: return '|';
      case 4: return '_';
      case 5: return '=';
    }
    return '$';
  }
  public String random()
  {
    int n = (int)Math.random()*4;
    String beta = "";
    switch(n)
    {
      case 1: beta= "Steve";
      case 2: beta= "Bill";
      case 3: beta= "Mark";
      case 4: beta= "Jake";
    }
    return beta;
  }




}
