public class Scope
{
  private int number;
  private String hello;
  private int[] array = new int[5];
  public Scope()
  {
    int number=20;
     hello = new String("what's poppin");
    array[0]=21;
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
    System.out.println("array "+array[0]);
    array[0]=31;
    System.out.println("string: "+hello);
    method1(5);
  }
  public void method1(int number)
  {
    String hello = new String("methe1");
    System.out.println(number);
    number+=10;
    System.out.println(number);
    System.out.println("array2 "+array[0]);
    number+=200;
    System.out.println(hello);
    System.out.println(hello);

  }
  public void method2()
  {
    System.out.println(number);
    number+=5;
    System.out.println(number);
  }
}
