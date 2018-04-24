public class SortX
{

    public static void main(String[]args)
    {
        String[] names = {"Dan", "Alice", "Claire","Evan","Boris"};
        sort(names);
    }
    public static void sort(String[] items)
    {
        int n = items.length;
        int count = 0;
        while(n>1)
        {
            count++;
            sortHelper(items, n-1);
            n--;
            System.out.println("iter "+count);
            if(count==2)
                n = 0;
        }
        for(String data: items)
        {
            System.out.print(data+" ");
        }
    }



    private static void sortHelper(String[] items, int last)
    {
        int m = last;
        for(int k = 0;k<last;k++)
        {
            if(items[k].compareTo(items[m])>0)
                m = k;
        }
        String temp = items[m];
        items[m] = items[last];
        items[last] = temp;
    }
}
