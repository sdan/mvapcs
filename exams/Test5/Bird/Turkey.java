import java.util.List;
import java.util.ArrayList;
public class Turkey implements Comparable <Turkey>
{
  private int age;
  private String name;
  private char[]traits;
  private ArrayList<String> friends;
  private int[][]dimensions;
  public Turkey(String n)
  {
    // System.out.println("TURKEY NAME "+name);
    age = 0;
    name = n;
    traits = new char[2];
    friends = new ArrayList<String>(10);
    dimensions = new int[3][3];
  }
  public void setAge(int a)
  {
    // System.out.println("age "+a);
    age = a;
  }
  public int getAge()
  {
    return age;
  }
  public String getName()
  {
    // System.out.println("NNNNNAME: "+name);
    return name;
  }
  public void setTraits(int i, char what)
  {
    System.out.println("INT I: "+i+" what?: "+what);
    traits[i] = what;
  }
  public char[] getTraits()
  {
    return traits;
  }
  public void setFriends(String what)
  {
     System.out.println("friends "+ what);
    friends.add(what);
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
