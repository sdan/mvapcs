import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class TeacherRunner1
{
	public static void main(String[] args)
	{
		int size = 10;
		BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(size,size);
		ActorWorld world = new ActorWorld(mygrid);

		for(int i = 0; i < size/2; i++)
		{
			world.add(new Location((int)(Math.random() * size),(int)(Math.random() * size)), new Student());
		}
		world.show();
	}
}
