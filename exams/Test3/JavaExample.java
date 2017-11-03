class A
{
   public void methodA()
   {
      System.out.println("method of Class A");
   }
}
class B extends A
{
   public String methodF()
   {
      return("method of Class B");
   }
}
class C extends A
{
  public String methodF()
  {
     return("method of Class C");
  }
}
class D extends A
{
  public String methodF()
  {
     return("method of Class D");
  }
}
class F extends A
{
  public F()
  {
    super();
    System.out.println(super.methodF());
  }
}
public class JavaExample
{
  public static void main(String args[])
  {
    F obj4 = new F();
      }
}
