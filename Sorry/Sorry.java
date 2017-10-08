
//  To be used in Sorry.java
	public void introduction ( )
	{
		System.out.println("\n\n+------------------------------------------------------------------------------------+");
		System.out.println("| WELCOME TO SORRY!                                                                  |");
		System.out.println("|                                                                                    |");
		System.out.println("| The game of SORRY(TM) is a battle between two players.  This game is played on a   |");
		System.out.println("| game board of 20 cells, and the players use 3 4-sided dice.  The game starts with  |");
		System.out.println("| the players entering their names, then rolling the dice, attempting to roll the    |");
		System.out.println("| highest sum, to determine who will go first.  Once the starting player is          |");
		System.out.println("| determined, the players alternate turns.  During each turn a player rolls the 3    |");
		System.out.println("| dice, and can reroll the dice (or subsets of the dice) 2 other times.  At the end  |");
		System.out.println("| of the player's turn, the player chooses how to apply the dice values to the 3     |");
		System.out.println("| game pieces.  The game pieces are labeled a, b, and c, and the player tries to     |");
		System.out.println("| move these pieces along the board.  If one or more of the player's pieces lands on |");
		System.out.println("| any other piece, the piece that is landed on goes back to the starting point.      |");
		System.out.println("| This is true even if it is the player's own game piece.  The winning player is the |");
		System.out.println("| one that gets all 3 pieces to the end of the board first.                          |");
		System.out.println("|                                                                                    |");
		System.out.println("| LET'S PLAY SOME SORRY!                                                             |");
		System.out.println("+------------------------------------------------------------------------------------+\n\n");
	}

//  To be used in Sorry.java
	public void makeChoice (SorryPlayer sp)
	{
		card.printScoreCardHeading();
		card.printPlayerStatus(player1);
		card.printPlayerStatus(player2);
		boolean badinput = false;
		String order = new String("");
		do
		{
			badinput = false;
			System.out.println("\n" + sp.getName() + ", now it's time to choose the pieces you would like to move with the");
			System.out.println("dice you rolled.  For example, if you'd like your dice score to match up with pieces a, then");
			System.out.println("b, then c, then enter abc.  If you'd like the first two dice to go toward piece a, then the");
			System.out.print("third dice toward piece b, then enter aab: ");
			order = keyboard.nextLine().trim().toLowerCase();
			if(order.length() < 3 || order.length() > 3)
			{
				badinput = true;
			}
			for(int i = 0; i < order.length(); i++)
			{
				if(order.charAt(i) != 'a' && order.charAt(i) != 'b' && order.charAt(i) != 'c')
				{
					badinput = true;
				}
			}
		}
		while(badinput);

		card.movePieces(sp, dice, order);
	}
