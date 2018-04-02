import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

import java.awt.Color; 

public class Jumper extends Bug
{

	public void act()
	{
		int steps = canJump();
		if(steps==0)
		{
			turn();
		}
		else
		{
			move(steps);
		}
	}

	public void move(int steps)
	{
		Grid<Actor> gr = getGrid();
		if(gr==null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location nextNext = next.getAdjacentLocation(getDirection());
		if(steps ==1)
			moveTo(next);
		if(steps ==2)
			moveTo(nextNext);
	}

	public int canJump()
	{
		Grid<Actor> gr = getGrid();
		if(gr == null)
			return 0;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if(gr.isValid(next))
		{
			if(gr.get(next) == null)
				return 1;
		}
		Location nextNext = next.getAdjacentLocation(getDirection());
		if(gr.isValid(nextNext))
		{
			if(gr.get(nextNext)==null)
				return 2;
		}
		return 0;
	}
}