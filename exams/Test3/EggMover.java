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
class EggBasket
{
      private int eggs;

      public EggBasket ( )
      {
        this(0);
        //System.out.println("eggbas no args constructor has been called");
      }

      public EggBasket(int e)
      {
        //System.out.println("eggbas param e "+e+" has been called");
            eggs = e;
      }

      public EggBasket(EggBasket eb)
      {
        //System.out.println("eggbas egbags param"+eb+" has been called");
            eggs = eb.eggs;
      }

      public void move(EggBasket other)
      {
        //System.out.println("move "+other+" has been called");
            eggs += other.eggs;
            other.eggs = 0;
      }

      public String toString ( )
      {
        //System.out.println("tostring has been called "+eggs);
            return "This basket has " + eggs + " eggs.";
      }
}
