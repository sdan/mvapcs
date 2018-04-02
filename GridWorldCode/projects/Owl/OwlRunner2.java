import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class OwlRunner2
{
	public static void main(String[] args)
	{
		BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(40,40);
		ActorWorld world = new ActorWorld(mygrid);
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				world.add(new Location(i,j), new Owl());
			}
		}
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				world.add(new Location(30+i,30+j), new Lizard());
			}
		}
		
		world.show();
	}
}