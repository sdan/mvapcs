public class EggMover
{
      public static void main(String [] args)
      {
            EggMover eggs = new EggMover();
            eggs.rearrange();
      }

      public void rearrange ( )
      {
            EggBasket emily = new EggBasket(23);
            EggBasket billy = new EggBasket(14);
            EggBasket naughtyurkel = new EggBasket();

            System.out.println("\n\n");
            System.out.println(emily + "\n");
            System.out.println(billy + "\n");
            System.out.println(naughtyurkel + "\n");
            System.out.println("\n\n");

            naughtyurkel = combine(emily,billy);

            System.out.println(emily + "\n");
            System.out.println(billy + "\n");
            System.out.println(naughtyurkel + "\n");
            System.out.println("\n\n");
      }

      public EggBasket combine(EggBasket one, EggBasket two)
      {
            EggBasket copyOne = new EggBasket(one);
            EggBasket copyTwo = new EggBasket(two);
            copyOne.move(copyTwo);
            return copyOne;
      }
}
public class EggBasket
{
      private int eggs;

      public EggBasket ( )
      {
            this(0);
      }

      public EggBasket(int e)
      {
            eggs = e;
      }

      public EggBasket(EggBasket eb)
      {
            eggs = eb.eggs;
      }

      public void move(EggBasket other)
      {
            eggs += other.eggs;
            other.eggs = 0;
      }

      public String toString ( )
      {
            return "This basket has " + eggs + " eggs.";
      }
}
