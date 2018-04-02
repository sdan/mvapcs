import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class OwlRunner7
{
    public static void main(String[] args)
    {
		BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(50,50);
		ActorWorld world = new ActorWorld(mygrid);
        
        Grid<Actor> gr = world.getGrid();
        int centerX = gr.getNumCols()/2;
        int centerY = gr.getNumRows()/2;
        for (int x = 0; x < gr.getNumCols(); x++) {
			if (x != 12 && x != 13 && x != 36 && x != 37)
			{
				world.add(new Location(x, centerY), new Rock());
				world.add(new Location(x, centerY+1),new Rock());
			}
        }
        for (int y = 0; y < gr.getNumRows(); y++) {
			if (y != 12 && y != 13 && y != 36 && y != 37)
			{
				world.add(new Location(centerX, y), new Rock());
				world.add(new Location(centerX+1, y),new Rock());
			}
        }
        
        for (int i = 0; i < 220; i++) {
            world.add(new Owl());
        }
        for (int i = 0; i < 1000; i++) {
            world.add(new Lizard(1,2));
        }
        world.show();
    }
}