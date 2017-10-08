public class YahtzeeScoreCard
{
    public void printScoreCardHeading ( )
    {
        System.out.println("\n                                               3of  4of  Fll Smll Lrg");
        System.out.println("  NAME            1    2    3    4    5    6   Knd  Knd  Hse Strt Strt Chnc  Ytz!");
        System.out.println("+--------------------------------------------------------------------------------+");
    }

    public void printPlayerStatus (YahtzeePlayer yp)
    {
        if (yp.getName().length() <= 12)
        {
            System.out.printf("| %-12s |",yp.getName());
        }
        else
        {
            System.out.printf("| %-12s |",yp.getName().substring(0,12));
        }
        for (int i = 0; i < 13; i++)
        {
            if (yp.getScoreArrayElement(i) > -1)
            {
                System.out.printf(" %2d |",yp.getScoreArrayElement(i));
            }
            else
            {
                System.out.print("    |");
            }
            if (i == 11)
            {
                System.out.print(" ");
            }
        }
        System.out.println("\n+--------------------------------------------------------------------------------+");
    }

    public void changeScore (YahtzeePlayer yp, DiceGroup dice, int choice)
    {
        switch(choice)
        {
            case 1: case 2: case 3: case 4: case 5: case 6:
                searchAndAdd(yp,dice,choice);  break;
            case 7:
                threeOfAKind(yp,dice);  break;
            case 8:
                fourOfAKind(yp,dice);  break;
            case 9:
                fullHouse(yp,dice);  break;
            case 10:
                smallStraight(yp,dice);  break;
            case 11:
                largeStraight(yp,dice);  break;
            case 12:
                chance(yp,dice);  break;
            case 13:
                yahtzeeCall(yp,dice);  break;
            default:
        }
    }

    public void searchAndAdd (YahtzeePlayer yp, DiceGroup dice, int choice)
    {
        yahtzeeCheck(yp,dice);
        int sum = 0;
        for (int i = 1; i <= 5; i++)
        {
            if (dice.getDie(i-1).getValue() == choice)
            {
                sum += choice;
            }
        }
        yp.setScoreArrayElement(choice-1,sum);
    }

    public void threeOfAKind (YahtzeePlayer yp, DiceGroup dice)
    {
        yahtzeeCheck(yp,dice);
        int count;
        boolean threematch = false;
        for (int i = 1; i <= 6; i++)
        {
            count = 0;
            for (int j = 0; j < 5; j++)
            {
                if (dice.getDie(j).getValue() == i)
                {
                    count++;
                }
            }
            if (count >= 3)
            {
                threematch = true;
            }
        }
        int sum = 0;
        if (threematch)
        {
            for (int i = 1; i <= 5; i++)
            {
                sum += dice.getDie(i-1).getValue();
            }
        }
        yp.setScoreArrayElement(6,sum);
    }

    public void fourOfAKind (YahtzeePlayer yp, DiceGroup dice)
    {
        yahtzeeCheck(yp,dice);
        int count;
        boolean fourmatch = false;
        for (int i = 1; i <= 6; i++)
        {
            count = 0;
            for (int j = 0; j < 5; j++)
            {
                if (dice.getDie(j).getValue() == i)
                {
                    count++;
                }
            }
            if (count >= 4)
            {
                fourmatch = true;
            }
        }
        int sum = 0;
        if (fourmatch)
        {
            for (int i = 1; i <= 5; i++)
            {
                sum += dice.getDie(i-1).getValue();
            }
        }
        yp.setScoreArrayElement(7,sum);
    }

    public void fullHouse (YahtzeePlayer yp, DiceGroup dice)
    {
        yahtzeeCheck(yp,dice);
        boolean threematch = false, twomatch = false;
        int count;
        for (int i = 1; i <= 6; i++)
        {
            count = 0;
            for (int j = 0; j < 5; j++)
            {
                if (dice.getDie(j).getValue() == i)
                {
                    count++;
                }
            }
            if (count == 3)
            {
                threematch = true;
            }
            else if (count == 2)
            {
                twomatch = true;
            }
        }
        if (twomatch && threematch)
        {
            yp.setScoreArrayElement(8,25);
        }
        else
        {
            yp.setScoreArrayElement(8,0);
        }
    }

    public void smallStraight (YahtzeePlayer yp, DiceGroup dice)
    {
        yahtzeeCheck(yp,dice);
        int count = 0;
        for (int i = 1; i <= 4; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (dice.getDie(j).getValue() == i)
                {
                    count++;
                    j = 4;
                }
            }
        }
        if (count == 4)
        {
            yp.setScoreArrayElement(9,30);
            return;
        }
        count = 0;
        for (int i = 2; i <= 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (dice.getDie(j).getValue() == i)
                {
                    count++;
                    j = 4;
                }
            }
        }
        if (count == 4)
        {
            yp.setScoreArrayElement(9,30);
            return;
        }
        count = 0;
        for (int i = 3; i <= 6; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (dice.getDie(j).getValue() == i)
                {
                    count++;
                    j = 4;
                }
            }
        }
        if (count == 4)
        {
            yp.setScoreArrayElement(9,30);
            return;
        }
        yp.setScoreArrayElement(9,0);
    }

    public void largeStraight (YahtzeePlayer yp, DiceGroup dice)
    {
        yahtzeeCheck(yp,dice);
        int count = 0;
        for (int i = 1; i <= 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (dice.getDie(j).getValue() == i)
                {
                    count++;
                    j = 4;
                }
            }
        }
        if (count == 5)
        {
            yp.setScoreArrayElement(10,40);
            return;
        }
        count = 0;
        for (int i = 2; i <= 6; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (dice.getDie(j).getValue() == i)
                {
                    count++;
                    j = 4;
                }
            }
        }
        if (count == 5)
        {
            yp.setScoreArrayElement(10,40);
            return;
        }
        yp.setScoreArrayElement(10,0);
    }

    public void chance (YahtzeePlayer yp, DiceGroup dice)
    {
        yahtzeeCheck(yp,dice);
        int sum = 0;
        for (int i = 0; i < 5; i++)
        {
            sum += dice.getDie(i).getValue();
        }
        yp.setScoreArrayElement(11,sum);

    }

    public void yahtzeeCall (YahtzeePlayer yp, DiceGroup dice)
    {
        int value = dice.getDie(0).getValue();
        int count = 0;
        for (int i = 0; i < 5; i++)
        {
            if (value == dice.getDie(i).getValue())
            {
                count++;
            }
        }
        if (count == 5)
        {
            yp.setScoreArrayElement(12,50);
        }
        else
        {
            yp.setScoreArrayElement(12,0);
        }
    }

    public void yahtzeeCheck (YahtzeePlayer yp, DiceGroup dice)
    {
        int yahtzeeScore = yp.getScoreArrayElement(12);
        if (yahtzeeScore >= 50)
        {
            int value = dice.getDie(0).getValue();
            int count = 0;
            for (int i = 0; i < 5; i++)
            {
                if (value == dice.getDie(i).getValue())
                {
                    count++;
                }
            }
            if (count == 5)
            {
                yp.setScoreArrayElement(12,yahtzeeScore + 100);
            }
        }
    }
}
