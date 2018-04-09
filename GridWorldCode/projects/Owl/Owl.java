/**
 * Owl.java
 * An Owl is an Actor. An Owl primarily wants to eat Eggs. If it finds an Egg in the radius of the 16 cells around it,
 * it eats it. Owls eat Eggs near to it before deciding to eat Eggs further away. This same preference is true for Lizards.
 * Lizards are eaten only if the Owl cannot find Eggs nearby. If Lizards aren't nearby either, the Owl moves toward the
 * nearest Lizard or Egg, in hopes to find food to eat.
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

public class Owl extends Actor
{
    /**
     * An Owl's only Color is null
     */
    public Owl()
    {
        setColor(null);
    }

    /**
    * Everytime an Owl acts, it finds the locations it needs to move to in order to either eat a Lizard or Egg
    * , or move toward a Lizard or Egg.
    */
    public void act()
    {
        if (getGrid() == null)
            return;
        boolean twoSteps = false;
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
                        if(moveLocs.size()!=0)
                            twoSteps = true;
                    }
                }
            }
        }
        Location loc = selectMoveLocation(moveLocs);
        if(twoSteps)
            makeMoveToward(loc);
        else
            makeMove(loc);
    }

    /**
    * Finds Lizards or Eggs one step away from the Owl.
    */
    public ArrayList<Location> getNearMoveLocations(boolean noEgg)
    {
        ArrayList<Location> occ = getGrid().getOccupiedAdjacentLocations(getLocation());
        ArrayList<Location> locs = new ArrayList<Location>();
        for(Location loc : occ)
        {
            Actor a = getGrid().get(loc);
            if((noEgg)&&(a!=null)&&(a instanceof Lizard) && !(a instanceof Owl))
                locs.add(a.getLocation());
            else if((!noEgg)&&(a!=null)&&(a instanceof Egg) && !(a instanceof Owl))
                locs.add(a.getLocation());
        }
        return locs;
    }

    /**
    * Finds Lizards or Eggs two steps away from the Owl.
    */
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
                    if(a != null && a != this && !noEgg && a instanceof Egg && !(a instanceof Owl))
                        locs.add(a.getLocation());
                    else if(a != null && a != this && noEgg && a instanceof Lizard && !(a instanceof Owl))
                        locs.add(a.getLocation());
                }
            }
        return locs;
    }
    
    /**
    * Finds Lizards or Eggs more than two steps away from the Owl.
    */
    public ArrayList<Location> getFarFarAwayMoveLocations()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Location> locs = getGrid().getOccupiedLocations();
        ArrayList<Integer> distances = new ArrayList<Integer>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        ArrayList<Location> result = new ArrayList<Location>();
        ArrayList<Location> refined = new ArrayList<Location>();

        for(Location loc : locs)
        {
            if((gr.get(loc) instanceof Lizard || gr.get(loc) instanceof Egg) && !(gr.get(loc) instanceof Owl))
            {
                distances.add(distanceFrom(this.getLocation(),loc));
                refined.add(loc);
            }
        }

        if(distances.size()!=0)
        {
            int smallest = distances.get(0);
            for(Integer a : distances)
                if(a<smallest)
                    smallest = a;
            for(int i = 0;i<distances.size();i++)
                if(distances.get(i)==smallest)
                    indexes.add(i);
            for(int i = 0;i<indexes.size();i++)
                result.add(refined.get(indexes.get(i)));
        }
        return result;
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
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        } 
        if(!getLocation().equals(loc))
        {
            setDirection(getLocation().getDirectionToward(loc));
            moveTo(loc);
        }
    }

    /**
     * Moves two steps toward Location destination and turns in the direction that it moves.
     */
    public void makeMoveToward(Location destination)
    {
        Grid<Actor> gr = getGrid(); 
        if (gr == null) {
            return;
        }
        Location loc = getLocation();

        if(!getLocation().equals(destination))
        {
            setDirection(loc.getDirectionToward(destination));
            Location next = loc.getAdjacentLocation(getDirection());
            Location nextNext = next.getAdjacentLocation(getDirection());
            if(!(gr.get(nextNext) instanceof Owl) && !(gr.get(nextNext) instanceof Rock))
                moveTo(nextNext);
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
