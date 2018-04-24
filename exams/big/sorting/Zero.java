public class Zero
{

    public static void main(String[]args)
    {
        Zero hello = new Zero();
        hello.run();
    }


    public void run()
    {
        System.out.println(countZeros("0000000000000000000000000000000"));
        System.out.println(binarySearch(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 0));
    }

    public int countZeros(String s)
    {
        int i = 0, j = 30;
        int count = 0;
        while(i<=j)
        {
            int k = (i+j)/2;
            if(s.substring(k,k+1).equals("0"))
                i = k+1;
            else
            j = k-1;
            count++;
        }
        System.out.println("num0: "+i);
        return count;
    }


    // Returns index of x if it is present in arr[],
    // else return -1
    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r)
        {
            int m = l + (r-l)/2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }




}
