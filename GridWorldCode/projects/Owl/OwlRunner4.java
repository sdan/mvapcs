import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class OwlRunner4
{
	public static void main(String[] args)
	{
		BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(19,19);
		ActorWorld world = new ActorWorld(mygrid);

		for (int i = 0; i < 50; i++)
		{
			world.add(new Location((int)(Math.random()*19),(int)(Math.random()*19)), new Egg(100,100));
		}
		
		world.add(new Location(0,0), new Owl());
		
		world.show();
    }
}