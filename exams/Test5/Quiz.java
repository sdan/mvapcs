import java.util.ArrayList;
import java.util.Arrays;
public class Quiz
{
  public static void main(String[]args)
  {
    Quiz dame = new Quiz();
    // dame.swapy();
    // dame.adam();
     int[]beta = {5,4,3,1,2};
    // dame.somesort(beta);
    //dame.daddy();
    dame.sortThis(beta);
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
    System.out.print("");
  }


  public static void somesort (int [] array) {
  for (int i = 0; i < array.length - 1; i++) {
  int j = indexSmallest(array, i, array.length - 1); int temp = array[i];
  array[i] = array[j];
  array[j] = temp;
  }
for (int i = 0; i<array.length; i++) {
  System.out.print(array[i]+" ");
}}
  public static int indexSmallest (int[] array, int lower, int upper) {
int indexMin = lower;
for (int i = lower + 1; i <= upper; i++) {
if (array[i] < array[indexMin]) {
indexMin = i; }
}
return indexMin;
}


public void daddy()
{
  ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(11, 22, 100, 33, 55, 92, 100, 11, 44, 100, 76)); System.out.println(findNext(array,100,2));
}


public int findNext (ArrayList<Integer> arr, int val, int start)
{
int pos = start + 1;
while ( (pos < arr.size()) && (arr.get(pos) != val) )
pos++; return pos;

}




public void sortThis(int [] list)
{
int n = list.length;
 while ( n >= 2 )
{
int z = 0;
for (int i=n;i>0;i--)
if (list[i] > list[z])
z = i;
int temp = list[n-1];
list[n-1] = list[z]; list[z] = temp;
n--;
}


for (int i = 0; i<list.length;i++ ) {
  System.out.print(list[i]+" ");
}

}



}
