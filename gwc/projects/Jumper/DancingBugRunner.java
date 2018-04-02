import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class DancingBugRunner
{
	public static void main(String[] args)
	{
		int [] dance1 = {1,2,3};
		int [] dance2 = {2,3,2,5,2};
		ActorWorld world = new ActorWorld();
		DancingBug alice = new DancingBug(dance1);
		alice.setColor(Color.ORANGE);
		DancingBug bob = new DancingBug(dance2);
		world.add(new Location(3, 4), alice);
		world.add(new Location(5, 6), bob);
		world.show();
	}
}
