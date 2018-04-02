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



public class HappyStars extends Flower
{


    /**
     * Constructs a HappyStar that has no color
     */
    public HappyStars()
    {
        setColor(null);
    }

    /**
    * Removes the HappyStar from Grid when Act is called
    */
    public void act()
    {
        removeSelfFromGrid();
    }
}
