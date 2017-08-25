import java.io.*;
import java.util.*;


public class greedy {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int no=s.nextInt();
        int t=0;

        while(t<no)
        {
        int n=s.nextInt();
        int i=0;
        int x=0;
        for(i=0;i<n;i++)
        {
           int in=s.nextInt();
            x=x^in;
        }
        if(x>0)
        {
            System.out.println("First");
        }
        else
        {
            System.out.println("Second");
        }
        t++;
        }

    }
}
