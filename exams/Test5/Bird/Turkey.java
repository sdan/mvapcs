import java.util.List;
import java.util.ArrayList;
public class Turkey
{
  private int age;
  private String name;
  private String[]traits;
  private ArrayList<String> friends;
  private int[][]dimensions;
  public Turkey(String name)
  {
    age = 0;
    name = name;
    traits = new traits[5];
    friends = new ArrayList<String>();
    dimensions = new dimensions[3][3];
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
