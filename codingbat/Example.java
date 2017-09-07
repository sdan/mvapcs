import java.util.Scanner;
public class Example
{
  public Example()
  {
  }
  public static void main(String[]args)
  {
    System.out.println("This is a tab \t and this is not \\t");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    Example wow = new Example();
    boolean prime = wow.euclid(a,b);
    System.out.println(prime);
  }
  public boolean euclid(int x, int y)
  {
    while(x!=0&&y!=0)
    {
      if(x>y)
      x=x%y;
      else
      y=y%x;
    }
    if(x!=1||y!=1)
    {
      return true;
    }
    else
    return false;
  }
}
