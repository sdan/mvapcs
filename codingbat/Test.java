public class Test
{
  private int arr[];
  private String yeah;
  private int x;
  public Test()
  {
    int[]arr = new int[11];
    arr[0]=21;
    arr[10]=31;
  }
  public static void main(String[]args)
  {
    Test testclassobject = new Test();
    testclassobject.inputArray();
  }
  public void inputArray()
  {
    arr = new int[50];
    arr[10]=31;
    for(int i = 0;i<arr.length;i++)
    {
      System.out.println(arr[i]);
    }
    comeon();
    System.out.println(yeah);
    anotherMethod(arr);
    System.out.println(arr[29]);
    System.out.println(x);
  }

  public void anotherMethod(int[]arr)
  {
    arr[29]=3111;
    System.out.println(arr[29]);
  }
  public void comeon()
  {
    String what = "surya";
    yeah = what;
    anotherone();
  }
  public void anotherone()
  {
    yeah ="yooo";
    x=100;
  }
}
