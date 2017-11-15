import java.util.ArrayList;
public class Sorts
{
    public static int bubbleSort (ArrayList <Integer> list)
    {
        int steps = 0;
        return steps;
    }
    public static int selectionSort (ArrayList <Integer> list)
    {
        int steps = 0;
        return steps;
    }
    public static int insertionSort (ArrayList <Integer> list)
    {
        int steps = 0;


        int max, temp;
        for (int outer = list.size(); outer > 1; outer--)
        {
            max = 0;
            for (int inner = 1; inner < outer; inner++)
            {
                if (list.get(inner).intValue() > list.get(max).intValue())
                {
                    max = inner; // a new largest item is found
                }
            }

            temp = list.set(outer-1,list.get(max)).intValue();
            list.set(max,new Integer(temp));

        }

        return steps;
    }

    public static int mergeSort (ArrayList<Integer> a, int from, int to)
    {
        int steps = 0;
//        else
//        {
            int middle = (from + to) / 2;

            steps += mergeSort(a, from, middle);
            steps += mergeSort(a, middle + 1, to);
            steps += merge(a, from, middle, to);
//        }
        return steps;
    }
    public static int merge (ArrayList<Integer> a, int from, int middle, int to)
    {
        int steps = 0;
        return steps;
    }
}
