import java.util.List;
import java.util.ArrayList;
public class Turkey
{
  private int age;
  private String name;
  private String[]traits;
  private ArrayList<String> friends;
  private int[][]dimensions;
  public Turkey(int age, String name, String[]traits, ArrayList<String> friends, int[][]dimensions)
  {
    age = age;
    name = name;
    traits = traits;
    friends = friends;
    dimensions = dimensions;
  }
  public int getAge()
  {
    return age;
  }
  public String getName()
  {
    return name;
  }
  public String[] getTraits()
  {
    return traits;
  }
  public ArrayList<String> getFriends()
  {
    return friends;
  }
  public int[][] getDimensions()
  {
    return dimensions;
  }


}
