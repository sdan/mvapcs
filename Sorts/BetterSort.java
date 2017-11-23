import java.util.ArrayList;
import java.util.Arrays;
public class BetterSort
{
  ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(4,5,2,3,4,5,5,61,1,1,2,3,0));
  public static void main(String[]args)
  {
    BetterSort parti = new BetterSort();
    //parti.bubbleSort();
    //parti.selectionSort();
     //parti.insertionSort();
    parti.printout();
  }
  public void bubbleSort()
  {
    for (int i = 0; i < arr.size()-1; i++)
    for (int j = 0; j < arr.size()-i-1; j++)
    if (arr.get(j).intValue() > arr.get(j+1).intValue())
    {
      // swap temp and arr[i]
      int temp = arr.get(j).intValue();
      arr.set(j,arr.get(j+1).intValue());
      arr.set(j+1,temp);
    }


  }
  public void selectionSort()
  {
    int length = arr.size();
    for(int n = length; n>1; n--)
    {
      int iMax = 0;
      for(int i = 1; i < n; i++)
      {
        if(arr.get(i)>arr.get(iMax))
        iMax = i;
      }
      int aTemp = arr.get(iMax);
      int bTemp = arr.get(n-1);
      arr.set(iMax, bTemp);
      arr.set(n-1, aTemp);
    }
  }

  public void insertionSort()
  {
    for(int n = 1; n<arr.size();n++)
    {
      int aTemp = arr.get(n);
      int i = n;
      while(i>0 && aTemp < arr.get(i-1)){
        arr.set(i, arr.get(i-1));
        i--;
      }
      arr.set(i, aTemp);
    }
  }
  public void printout()
  {
    for(int i = 0;i<arr.size();i++)
    {
      System.out.print(arr.get(i).intValue()+" ");
    }
  }
}
