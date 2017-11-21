import java.util.ArrayList;
public class Quiz
{
  public static void main(String[]args)
  {
    Quiz dame = new Quiz();
    dame.swapy();
    dame.adam();
  }
  public void swapy()
  {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Winter");
    names.add("is");
    names.add("almost");
    names.add("here");
    String s1 = names.get(0);
String s2 = names.get(names.size()-1); names.set(0, s2); names.set(names.size()-1, s1);
//System.out.println(names);

  }
  public void adam()
  {
    int[][]arr={ { 1,2,3,4,5,6},
    { 7, 8, 9,10,11,12 },
    { 13,14,15,16,17,18 } };
    for (int [] list : arr)
    for (int x : list)
    if (x % 4 == 2 && x % 3 == 0)
    System.out.print(x + " ");
  }
}
