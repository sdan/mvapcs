class Derived extends Base {
public void methodSecond ( )
{

}
}
class Base {
public void methodFirst (){

}
public void methodSecond (){

}
}
public class beta{
  public static void main(String[]args)
  {
    Base instance1 = new Base();
    Base instance2 = new Derived();
    instance1.methodSecond();
    instance1.methodFirst();
    instance2.methodFirst();
  }

}
