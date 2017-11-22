import java.util.ArrayList;
import java.util.Arrays;
public class Quiz
{
  ArrayList<Double> values =  new ArrayList<Double>(Arrays.asList(2.4,3.8,4.2,1.6));

  public static void main(String[]args)
  {
    Quiz dame = new Quiz();
    // dame.swapy();
    // dame.adam();
     int[]beta = {3,4,3,6};
    // dame.somesort(beta);
    //dame.daddy();
    //dame.sortThis(beta);
    //System.out.println(dame.isSorted(beta));
    //dame.methodToMadness();
    //dame.badboy();
    //dame.arraybig();
  //  dame.anything();
  //dame.anotherone();
  //dame.jake();
  //dame.paul();
  dame.sortArray(beta);
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





public static boolean isSorted (int [] data)
{
  for (int k = 0; k < data.length-1; k++)
  {
    if (data[k] > data[k + 1])
    return false;
    else
    return true;
  }
  return true;
}






public void methodToMadness ( ) {
ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1));
newValues(nums);
for(int k = 0; k < nums.size(); k++) {
System.out.print(nums.get(k).intValue() + " ");
}
mixThemUp(nums);
for(int k = 0; k < nums.size(); k++) {
System.out.print(nums.get(k).intValue() + " ");
} }
public void newValues (ArrayList<Integer> list) {
for(int x = 0; x < list.size(); x++) {
list.set(x,new Integer(x * 2));
} }
public void mixThemUp (ArrayList<Integer> list) {
list = new ArrayList<Integer>();
for(int x = 0; x < 5; x++) {
list.add(new Integer(x * 5));
} }

public void badboy()
{
  ArrayList<Double> stringList = new ArrayList<Double>();
  //ArrayList<double> intList = new ArrayList<double>();
  ArrayList<Comparable> compList = new ArrayList<Comparable>();
}

public void arraybig()
{
  ArrayList<String> mylist = new ArrayList<String>(); mylist.add("M");
mylist.add("V");
mylist.add("A");
mylist.add("P"); mylist.add("C"); mylist.add("S");
for (int count = 0; count < mylist.size(); count+=2) {
mylist.remove(count);
}
for (int count = 1; count <= mylist.size()/2; count++) {
mylist.add(1,"RAIN!");
}
for (String value : mylist) {
System.out.print(value + " ");
}

}



public void anything()
{
  ArrayList<Integer> list = new ArrayList<Integer>();
  list.add(3);
list.add(2);
list.add(1);
int n = list.size();
for (int i = 0; i < n; i++) {
int value = list.get(i);
if (value > 0)
{
list.add(value, new Integer(value));
}
}
System.out.println(list);

}






public void anotherone()
{
  ArrayList<String> myclasses = new ArrayList<String>();
myclasses.add("AP Computer Science"); myclasses.add("World History"); myclasses.add("American Literature"); myclasses.add(0, "AP Biology"); myclasses.remove(3);
myclasses.add(0, "Physical Education"); System.out.println(myclasses);
}






public void jake()
{
  ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(99,0,1,2,3,110));
  System.out.println(number);
}

public void paul()
{
System.out.println(calcTotal());
}

public double calcTotal ( ) {
double total = 0.0;
for (int pos = 0; pos < values.size(); pos++)
total += values.get(pos).doubleValue();
return total;
}










public void sortArray(int [] arr)
{
int j, k;
for (j = arr.length - 1; j > 0; j--)
 {
int pos = j;

for ( k=j-1;k>=0;k--) {
if (arr[k] > arr[pos]) {
pos = k;
}
}
swap(arr,j,pos);
}
for (int i = 0;i<arr.length;i++ ) {
  System.out.print(arr[i]+" ");
}
}

public int[] swap(int[]arr,int a,int b)
{
  int temp = arr[a];
  arr[a] = arr[b];
  arr[b] = temp;
  return arr;
}


















}
