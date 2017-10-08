//  To be used in SorryScoreCard.java
	public void printScoreCardHeading ( )
	{
		System.out.println("\n  NAME               1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20");
		System.out.println("+--------------------------------------------------------------------------------------------------+");
	}

//  To be used in SorryScoreCard.java
	public void printPlayerStatus (SorryPlayer sp)
	{
		if (sp.getName().length() <= 12)
		{
			System.out.printf("| %-12s",sp.getName());
		}
		else
		{
			System.out.printf("| %-12s",sp.getName().substring(0,12));
		}
		System.out.print(" ");
		if(sp.getPieceArrayElement(0) == 0)
		{
			System.out.print("a");
		}
		else
		{
			System.out.print(" ");
		}
		if(sp.getPieceArrayElement(1) == 0)
		{
			System.out.print("b");
		}
		else
		{
			System.out.print(" ");
		}
		if(sp.getPieceArrayElement(2) == 0)
		{
			System.out.print("c");
		}
		else
		{
			System.out.print(" ");
		}
		System.out.print(" |");
		for (int i = 1; i <= 20; i++)
		{
			if (i == sp.getPieceArrayElement(0))
			{
				System.out.printf(" a |");
			}
			else if (i == sp.getPieceArrayElement(1))
			{
				System.out.printf(" b |");
			}
			else if (i == sp.getPieceArrayElement(2))
			{
				System.out.printf(" c |");
			}
			else
			{
				System.out.print("   |");
			}
		}
		System.out.print(" ");
		if(sp.getPieceArrayElement(0) > 20)
		{
			System.out.print("a");
		}
		if(sp.getPieceArrayElement(1) > 20)
		{
			System.out.print("b");
		}
		if(sp.getPieceArrayElement(2) > 20)
		{
			System.out.print("c");
		}
		System.out.println("\n+--------------------------------------------------------------------------------------------------+");
	}
