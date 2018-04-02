import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class OwlRunner3
{
	public static void main(String[] args)
	{
		BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(50,50);
		ActorWorld world = new ActorWorld(mygrid);
		
		world.add(new Location(0, 0), new Lizard(2,1));
		world.add(new Location(0, 49), new Lizard(3,2));
		world.add(new Location(49, 0), new Lizard(4,2));
		world.add(new Location(49, 49), new Lizard());
		
		world.show();
	}
}