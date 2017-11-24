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
        food.get(i).setAge((int)(Math.random() * 100));
      }
  }

  public void traits()
  {
    for (int i = 0;i<food.size();i++ ) {
      food.get(i).setTraits(0,((char)((int)(Math.random() * 94) + 32)));
      food.get(i).setTraits(1,((char)((int)(Math.random() * 94) + 32)));
    }
  }

  public void friends()
  {
    for (int i = 0;i<food.size();i++) {
      // System.out.println("i in bird: "+i);
      String temp = arny();
      System.out.println("ARNY: "+temp);
      food.get(i).setFriends(temp);
      temp = arny();
      food.get(i).setFriends(temp);
      temp = arny();
      food.get(i).setFriends(temp);
      temp = arny();
      food.get(i).setFriends(temp);
      temp = arny();
      food.get(i).setFriends(temp);
      temp = arny();
      food.get(i).setFriends(temp);
      temp = arny();
      food.get(i).setFriends(temp);
      temp = arny();
      food.get(i).setFriends(temp);
      temp = arny();
      food.get(i).setFriends(temp);
    }
  }

  public void dimensions()
  {
    for (int i = 0;i<food.size();i++) {
      int a = ran();
      int b = ran();
      char c = rant();
      System.out.println("a: "+a+" b: "+b+" c: "+c);
      food.get(i).setDimensions(a,b,rant());
    }
  }
  public int ran()
  {
    int num = (int)(Math.random() * 2) + 1;
    System.out.println("RAN SOM: "+ num);
    return num;
  }
  public char rant()
  {
    int n = (int)(Math.random() * 4) + 1;
    System.out.println("OASJDOIAJFOEWIJFOWEIFJOEWIFJEWOFJEOWIF: "+n);
    char beta = ' ';
    switch(n)
    {
      case 1: beta='/';
      break;
      case 2: beta='#';
      break;
      case 3: beta='|';
      break;
      case 4: beta='_';
      break;
      case 5: beta='=';
      break;
    }
    System.out.println("RANT: "+beta);
    return beta;
  }
  public String arny()
  {
    int n = (int)(Math.random() * 3) + 1;
    String beta = "";
    switch(n)
    {
      case 1: beta= "Steve";
      break;
      case 2: beta= "Bill";
      break;
      case 3: beta= "Mark";
      break;
      case 4: beta= "Jake";
      break;
    }
    return beta;
  }




}
