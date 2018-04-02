/**
 * Teacher.java
 * A Teacher assigns 2 homework assignments to a Student. A Teacher turns in a random direction when it is stuck.
 * A Teacher cannot remove a Student but it can remove a HappyStar from its location.
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

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Teacher extends Bug
{
    private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public Teacher()
    {
        setColor(null);
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        giveHomework();
        if(canMove()&&!stuck())
        {
            move();
        }
        else
            turn();
    }

    /**
    *  Assigns homework to one student
    */
    public void giveHomework()
    {
        Grid<Actor> gr = getGrid();
        Actor neighbor;
        Location next = getLocation();
        next = next.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
        {
            neighbor = gr.get(next);
            if (neighbor instanceof Student)
            {
                ((Student)neighbor).assignHomework();
            }
            else
            {
                next = next.getAdjacentLocation(getDirection());
                if (gr.isValid(next))
                {
                    neighbor = gr.get(next);
                    if (neighbor instanceof Student)
                    {
                        ((Student)neighbor).assignHomework();
                    }
                }   
            }
        }
    }

    /**
    *  Decides if it can move on top of a HappyStar or if it can move into an empty space
    */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return ((neighbor == null) || (neighbor instanceof HappyStars));

    }


    /**
    *   Moves into an adjacent location in the same direction as the Teacher
    */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    /**
    *   Turns the current Bug in a random direction
    */
    public void turn()
    {
        setDirection((int)(Math.random()*8)*45);
    }

    /**
    * Evaluates if the Teacher cannot move in the current direction and is thus stuck
    */
    public boolean stuck()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        ArrayList<Location> moveLocs = gr.getValidAdjacentLocations(getLocation());

        for (Location next : moveLocs)
        {
            if(gr.isValid(next))
            {
                Actor neighbor = gr.get(next);
                if ((neighbor == null) || (neighbor instanceof HappyStars))
                    return false;
            }
        }
        return true;
    }

}
