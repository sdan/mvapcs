import java.util.List;
import java.util.ArrayList;
public class Turkey implements Comparable <Turkey>
{
  private int age;
  private String name;
  private int[]traits;
  private ArrayList<String> friends;
  private int[][]dimensions;
  public Turkey(String name)
  {
    System.out.println("TURKEY NAME "+name);
    age = 0;
    name = name;
    traits = new int[2];
    friends = new ArrayList<String>(10);
    dimensions = new int[3][3];
  }
  public void setAge(int a)
  {
    age = a;
  }
  public int getAge()
  {
    return age;
  }
  public String getName()
  {
    return name;
  }
  public void setTraits(int i, int what)
  {
    traits[i] = what;
  }
  public int[] getTraits()
  {
    return traits;
  }
  public void setFriends(int i, String what)
  {
    aslkdmasldkmasdlkasmdalkdmasdasdlkasmda
     jsaodimasdoasd null = =naaaalla;
    System.out.println("friends "+ friends);

    friends.set(i,what);
  }
  public ArrayList<String> getFriends()
  {
    return friends;
  }
  public void setDimensions(int i, int j, int what)
  {
    dimensions[i][j] = what;
  }
  public int[][] getDimensions()
  {
    return dimensions;
  }



  public int compareTo(Turkey other)
  {
    return name.compareTo(other.name);
  }






}
