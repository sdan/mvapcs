public class Scope
{
  private int number;
  public Scope()
  {
    int number=20;
  }
  public static void main(String[]args)
  {
    Scope run = new Scope();
    run.methods();
  }
  public void methods()
  {
    System.out.println(number);
    method1(number);
    System.out.println(number);
    number+=15;
    method2();
    System.out.println(number);
  }
  public void method1(int number)
  {
    System.out.println(number);
    number+=10;
    System.out.println(number);
  }
  public void method2()
  {
    System.out.println(number);
    number+=5;
    System.out.println(number);
  }
}
