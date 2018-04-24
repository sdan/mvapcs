class Plane
{
    public void print()
    {
        System.out.println("my plane");
    }
}

public class Boeing extends Plane
{
    public static void main(String[]args)
    {
        Boeing plane = new Boeing();
        plane.run();
    }

    // public void print()
    // {
    //     System.out.println("my boeing");
    // }

    public void run()
    {
        System.out.println(1+1);
        print();

    }
}
