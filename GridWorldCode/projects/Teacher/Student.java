/**
 * Student.java
 * A Student is a subclass of Actor. It does not change its direction but it does change color.
 * It changes color depending on if it is happy or not. It is happy when it has no homework, which
 * is assigned by a Teacher. When a Student is happy, it drops a HappyStar. A Student will not accept
 * more than 5 homeworks. When a Student cannot place a HappyStar, it does not.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 3/28/2018
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import java.awt.Color; 
import java.util.ArrayList;

public class Student extends Actor
{
	private int homework;
	
	/**
	* Sets initial homework count to 0 and sets the initial color to 0
	*/
	public Student()
	{
		homework = 0;
		setColor(null);
	}

	/**
	* Used to assign student with 2 homework assignments.
	*/
	public void assignHomework()
	{
		homework+=2;
	}

	/**
	* Act method of Student which extends Actor. Finds possible locations and tries to make move toward the empty space.
	*/
	public void act()
    {
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }

    /**
    * Selects random location to move to.
    */
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();
        int r = (int) (Math.random() * n);
        return locs.get(r);
    }

    public ArrayList<Location> getMoveLocations()
    {
        return getGrid().getEmptyAdjacentLocations(getLocation());
    }

    /**
	* Prevents from subclass of Actor to process any since this behavior is implemented in other methods.
	*/
    public void processActors(ArrayList<Actor> actors)
    {
   
    }

    /**
    * Makes moves toward location. Drops a happy star after moving to that location.
    */
    public void makeMove(Location loc)
    {
		Grid<Actor> gr = getGrid();

		if(homework>=1)
		{
			
			if(homework==0)
			{
				setColor(null);
			}
			else if(homework==1)
			{
				setColor(Color.BLUE);
			}
			else if(homework==2)
			{
				setColor(Color.GREEN);
			}
			else if(homework==3)
			{
				setColor(Color.ORANGE);
			}
			else if(homework==4||homework==5)
			{
				setColor(Color.RED);
			}
			else
			{
				homework = 5;
			}
			homework--;
		}
		if(homework == 0)
		{
			moveTo(loc);
			ArrayList<Location> starMoveLocations = getMoveLocations();
			if(starMoveLocations.size()>0)
			{
				Location happyStarMoves = selectMoveLocation(starMoveLocations);
				HappyStars star = new HappyStars();
				star.putSelfInGrid(gr,happyStarMoves);
			}
			
		}
    }
}
