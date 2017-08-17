import java.util.Scanner;

public class JackpotPrimitive
{
	public static void main (String [] args)
	{
		int value1, value2, value3, sides, count = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\n\n\n");
		do
		{
			System.out.print("Please enter the number of sides for the 3 dice (6-20): ");
			sides = keyboard.nextInt();
		}
		while(sides>20||sides<6);
		System.out.println("\n");
		do
		{
			count++;
			value1 = (int)(Math.random()*sides)+1;
			value2 = (int)(Math.random()*sides)+1;
			value3 = (int)(Math.random()*sides)+1;
			System.out.printf("%4d%4d%4d\n",value1,value2,value3);
		}
		while(!(value1==value2&&value2==value3));
		System.out.printf("It took %d rolls to win the JACKPOT!", count);
		System.out.println("\n\n\n");
	}
}
