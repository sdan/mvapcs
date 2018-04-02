import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class OwlRunner5
{
	public static void main(String[] args)
	{
		BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(9,9);
		ActorWorld world = new ActorWorld(mygrid);
		
		for(int i = 0; i < 9; i+=2)
		{
			for(int j = 0; j < 9; j++)
			{
				world.add(new Location(i, j), new Rock());
			}
		}
		world.add(new Location(1, 0), new Owl());
		world.add(new Location(3, 6), new Lizard(100,100));
		world.add(new Location(5, 8), new Lizard(100,100));
		world.add(new Location(7, 7), new Lizard(100,100));
		
		world.show();
	}
}