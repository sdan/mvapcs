public class Scope
{
private int number;
public static void main(String[]args)
{
  Scope run = new Scope();
  run.methods();
}
public void methods()
{
  method1();
  number+=20;
  method2(number);
  number+=30;
  method3();
  System.out.println(number);
}
public void method1()
{
  System.out.println(number);
  number+=40;
  System.out.println(number);
}
public void method2(int number)
{
  System.out.println(number);
  number+=50;
  System.out.println(number);
}
public void method3()
{
  int number = 60;
  System.out.println(number);
  number+=70;
  System.out.println(number);

}
}
