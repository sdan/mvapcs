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

public class Lizard extends Actor
{	

	private int pDrop;
	private int pEgg;
	/**
	* Sets initial homework count to 0 and sets the initial color to 0
	*/
	public Lizard()
	{
		setColor(null);
		this.pDrop = 5;
		this.pEgg = 6;
	}

	public Lizard(int pDrop, int pEgg)
	{
		setColor(null);
		this.pDrop = pDrop;
		this.pEgg = pEgg;
	}

	/**
	* Act method of Student which extends Actor. Finds possible locations and tries to make move toward the empty space.
	*/
	public void act()
    {
    	setColor(null);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }

    public ArrayList<Location> getMoveLocations()
    {
        return getGrid().getEmptyAdjacentLocations(getLocation());
    }

    /**
    * Makes moves toward location. Drops a happy star after moving to that location.
    */
    public void makeMove(Location loc)
    {
		Grid<Actor> gr = getGrid();

		if(getDirection()!=getLocation().getDirectionToward(loc))
		{
			setColor(Color.BLUE);
			Location initialLoc = getLocation();
			setDirection(getLocation().getDirectionToward(loc));
			moveTo(loc);


			int random = (int)(Math.random()*(pDrop+1));
			if(random==0)
			{
				ArrayList<Location> eggMoveLocations = getMoveLocations();
				if(eggMoveLocations.size()>0)
				{
					Egg rawEgg = new Egg(pDrop, pEgg);
					rawEgg.putSelfInGrid(gr,initialLoc);
				}
			}
			
		}
    }

    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();
        int r = (int) (Math.random() * n);
        return locs.get(r);
    }

    



}
