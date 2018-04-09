/**
 * Egg.java
 * An Egg is a Flower since it does not move or turn, but it does change color like Flower.
 * Eggs are dropped by Lizards on the Grid. Eggs face North (0) and are initially white, eventually turning bright green
 * with every call to act. Eggs are incubated on the Grid before becoming a Lizard on the same location as the Egg.
 * 
 * @author Surya Dantuluri
 * @version 1.0
 * @since 4/8/2018
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import java.awt.Color; 
import java.util.ArrayList;


public class Egg extends Flower
{
    private static final double DARKENING_FACTOR = 0.05; 
    private int pDrop;
    private int pEgg;


    /**
     * Constructs an Egg that is white and is facing North
     */
    public Egg()
    {
        setColor(Color.WHITE);
        setDirection(Location.NORTH);
    }

    /**
    * Constructs Egg with probability of dropping an egg and time taken to become a Lizard.
    */
    public Egg(int pDrop, int pEgg)
    {
        setColor(Color.WHITE);
        this.pDrop = pDrop;
        this.pEgg = pEgg;
    }


    /**
    * Removes the itself from Grid when pEgg(time to hatch) is 0 and places Lizard in its place.
    */
    public void act()
    {
        Grid<Actor> gr = getGrid();
        darken();
        pEgg--;
        if(pEgg<=0)
        {
            Location loc = getLocation();
            removeSelfFromGrid();
            Lizard sneaky = new Lizard(pDrop,pEgg);
            sneaky.putSelfInGrid(gr,loc); 
        }
    }
    
    /**
    *  Darkens Egg's red and blue values, making it seem like the green value is increasing.
    */
    private void darken()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen());
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
        setColor(new Color(red, green, blue));
    } 



}
