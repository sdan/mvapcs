import java.gridworld.actor.ActorWorld;
import info.grifworld.grid.Location;

import java.awt.Color;

public class CircleBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        CircleBug steve = new CircleBug(6);
        steve.setColor(Color.ORANGE);
        CircleBug john = new CircleBug(3);
        world.add(new Location(7,8), steve);
        world.add(new Location(5,5), john);
        world.show();
    }
}
