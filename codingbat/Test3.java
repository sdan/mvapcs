public class Test3
{
  public static void main(String[]args)
  {
    Test3 testClassObject3 = new Test3();
    //testClassObject3.variableChange();
    testClassObject3.codeFrag();
    //testClassObject3.basicOperations();
  }
  public void variableChange()
  {
    int ahab = 5;
    int moby = 6;
    int stubb = 11;
    do
    {
      if(moby%ahab>2)
      {
        ahab++;
        //System.out.println("ahab "+ahab);
      }
      else if(moby%ahab<2)
      {
        ahab--;
        moby++;
        //System.out.println("ahab "+ahab+" moby "+moby);
      }
      if(stubb/ahab==2)
      {
        stubb--;
        //System.out.println("stubb "+stubb);
      }
      else
      {
        stubb++;
        moby+=2;
        //System.out.println("stubb "+stubb+" moby "+moby);
      }
      System.out.println(ahab+" "+moby+" "+stubb);
    }while(stubb/moby>=1);
  }

  public void codeFrag()
  {
    for(int row =1;row<=5;row++)
    {
      int col =1;
      while(col<=5)
      {
        if(row%col==1)
        System.out.print(row);
        else
        System.out.print("*");
        col++;
      }
      System.out.println();
    }
  }

  public void basicOperations()
  {
    int integre = 5;
    double doble = 5.0;
    char somechar = '1';
    char anotherchar = 'a';
    char anotherone = 'o';
    int something = somechar%50;
    System.out.println(somechar%5+" "+somechar%50);
  }
}
