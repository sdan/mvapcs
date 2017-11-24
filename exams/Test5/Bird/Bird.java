import java.util.List;
import java.util.ArrayList;
public class Bird implements Comparable <Bird>
{
  private ArrayList<Turkey> food;
  private ArrayList<String> llamar;
  private int numberOfTurkeys;
  public Bird(int num, ArrayList<String> names)
  {
    food = new ArrayList<Turkey>();
    llamar = names;
    numberOfTurkeys = num;

  }

  public generateTurkey()
  {
    for (int i = 0;i<numberOfTurkeys;i++) {
      food.add(new Turkey(llamar.get(i)))
    }
  }

  public age()
  {
      for(int i = 0;i<food.size())
  }




  public int compareTo(Bird other)
  {
    return name.compareTo(other.name);
  }
}
