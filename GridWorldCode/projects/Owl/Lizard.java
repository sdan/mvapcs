/**
 * Lizard.java
 * A Lizard is an Actor. A Lizard turns blue when it drops an Egg. It drops an Egg randomly according to preset parameters.
 * A Lizard turns in the direction that it moves and is green when it doesn't move.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 4/8/2018
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
	* Sets initial probability of dropping an Egg and time for the Egg hatching to 5 and 6 respectively.
	*/
	public Lizard()
	{
		setColor(null);
		this.pDrop = 5;
		this.pEgg = 6;
	}

	/**
	* Sets initial probability of dropping an Egg and time for the Egg hatching to pDrop parameter
	* and pEgg parameter respectively.
	*/
	public Lizard(int pDrop, int pEgg)
	{
		setColor(null);
		this.pDrop = pDrop;
		this.pEgg = pEgg;
	}

	/**
	* Act method of Lizard which extends Actor. Finds possible locations and tries to make move toward the empty space.
	*/
	public void act()
    {
    	setColor(null);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }

    /**
    * Gets all empty adjacent locations around the current location.
    */
    public ArrayList<Location> getMoveLocations()
    {
        return getGrid().getEmptyAdjacentLocations(getLocation());
    }

    /**
    * Makes moves toward location. Randomly drops an Egg after moving (probability of not dropping Egg after moving).
    */
    public void makeMove(Location loc)
    {
			Grid<Actor> gr = getGrid();
			if (gr == null) {
            return;
        	}
			Location initialLoc = getLocation();
			if(!getLocation().equals(loc))
			{
				setDirection(getLocation().getDirectionToward(loc));
				moveTo(loc);
				int random = (int)(Math.random()*(pDrop+1));
				if(random==0)
				{
					ArrayList<Location> eggMoveLocations = getMoveLocations();
					if(eggMoveLocations.size()>0)
					{
						setColor(Color.BLUE);
						Egg rawEgg = new Egg(pDrop, pEgg);
						rawEgg.putSelfInGrid(gr,initialLoc);
					}
				}
			}
			
    }

    /**
    * Randomly selects a Location from the ArrayList of Locations.
    */
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();
        int r = (int) (Math.random() * n);
        return locs.get(r);
    }

}
