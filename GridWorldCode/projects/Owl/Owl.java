/**
 * Owl.java
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

public class Owl extends Actor
{
    /**
     * A critter acts by getting a list of other actors, processing that list,
     * getting locations to move to, selecting one of them, and moving to the
     * selected location.
     */
    public void act()
    {
        if (getGrid() == null)
            return;

        ArrayList<Location> moveLocs = new ArrayList<Location>();
        moveLocs = getNearMoveLocations(false);
        if(moveLocs.size()==0)
        {
            moveLocs = getFarMoveLocations(false);
            if(moveLocs.size()==0)
            {
                moveLocs = getNearMoveLocations(true);
                if(moveLocs.size()==0)
                {
                    moveLocs = getFarMoveLocations(true);
                    if(moveLocs.size()==0)
                    {
                        moveLocs = getFarFarAwayMoveLocations();
                    }
                }
            }
        }

        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }

    public ArrayList<Location> getNearMoveLocations(boolean noEgg)
    {
        ArrayList<Location> occ = getGrid().getOccupiedAdjacentLocations(getLocation());
        ArrayList<Location> locs = new ArrayList<Location>();
        for(Location loc : occ)
        {
            Actor a = getGrid().get(loc);
            if((noEgg)&&(a!=null)&&(a instanceof Lizard))
                locs.add(a.getLocation());
            else if((!noEgg)&&(a!=null)&&(a instanceof Egg))
                locs.add(a.getLocation());
        }
        return locs;

    }

    public ArrayList<Location> getFarMoveLocations(boolean noEgg)
    {
        ArrayList<Location> locs = new ArrayList<Location>();

        Location loc = getLocation();
        for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ )
            for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++)
            {
                Location tempLoc = new Location(r,c);
                if(getGrid().isValid(tempLoc))
                {
                    Actor a = getGrid().get(tempLoc);
                    if(a != null && a != this && !noEgg && a instanceof Egg)
                        locs.add(a.getLocation());
                    else if(a != null && a != this && noEgg && a instanceof Lizard)
                        locs.add(a.getLocation());
                }
            }
        return locs;
    }
    
    public ArrayList<Location> getFarFarAwayMoveLocations()
    {
        ArrayList<Location> locs = getGrid().getOccupiedLocations();
        ArrayList<Integer> distances = new ArrayList<Integer>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        ArrayList<Location> result = new ArrayList<Integer>();
        Location loc = getLocation();
        for(Location loc: locs)
        {
            distances.add(distanceFrom(this.getLocation(),loc));
        }
        int smallest = distances.get(0);
        for(Integer a: distances)
        {
            if(a<smallest)
            smallest = a;
        }
        for(int i = 0;i<distances.size();i++)
        {
            if(distances.get(i)==smallest)
            indexes.add(i);
        }
        for(int i = 0;i<indexes.size();i++)
        {
            result.add(distances.get(indexes.get(i)));s
        }
        return locs;
    }
    
    /** 
    * Computes the rounded integer distance between two given locations. 
    */ 
    public int distanceFrom(Location loc1, Location loc2) 
    { 
        int x1 = loc1.getRow(); 
        int y1 = loc1.getCol(); 
        int x2 = loc2.getRow(); 
        int y2 = loc2.getCol(); 
        double dist = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)) + .5; 
        return (int)Math.floor(dist); 
    }  


    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        if (loc == null)
            removeSelfFromGrid();
        else
            moveTo(loc);
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
