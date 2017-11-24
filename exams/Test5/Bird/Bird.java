import java.util.List;
import java.util.ArrayList;
public class Bird implements Comparable <Bird>
{
  private ArrayList<Turkey> food;
  private String name;
  private int numberOfTurkeys;
  public Bird(int num, String name)
  {
    food = new ArrayList<Turkey>();
    numberOfTurkeys = num;
    name = name;
  }

  public generateTurkey()
  {
    for (int i = 0;i<numberOfTurkeys;i++) {
      food.add(new Turkey(name))
    }
  }


  public int compareTo(Bird other)
  {
    return name.compareTo(other.name);
  }
}
