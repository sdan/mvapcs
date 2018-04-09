/**
 * HappyStars.java
 * A HappyStar is placed when a Student is happy. A Student is happy when he or she has no homework.
 * A HappyStar does not replace any other Actor.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 3/28/2018
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
     * Constructs a HappyStar that has no color
     */
    public Egg()
    {
        setColor(Color.WHITE);
        setDirection(Location.NORTH);
    }

    public Egg(int pDrop, int pEgg)
    {
        setColor(Color.WHITE);
        this.pDrop = pDrop;
        this.pEgg = pEgg;
    }


    /**
    * Removes the HappyStar from Grid when Act is called
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
    
    private void darken()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen());
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
        setColor(new Color(red, green, blue));
    } 



}
