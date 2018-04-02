/*
Note that the Jumper should never leave a Flower behind, even if it only moves 
to an adjacent location.  The Jumper should always attempt to move two spaces
(a "jump") first.
1) a.  If there is a Flower or Rock two cells in front of the Jumper, the Jumper
       will move to the adjacent location, in the direction it is facing.  If that
     location is occupied, the Jumper will turn like a Bug.
   b.  If the location two cells in front of the Jumper is out of the grid, the
       Jumper will move to the adjacent location, in the direction it is facing.
     If that location is occupied, the Jumper will turn like a Bug.
   c.  If the Jumper is facing an edge of the grid, it will turn like a Bug.
   d.  See 1a.
   e.  The Jumper will treat other Actors just as it treats Flowers and Rocks.
   f.  No
2) a.  Extend the Actor class.
   b.  Use the Bug class as a template (a place to get started) in coding the
       Jumper class.
   c.  Yes, write at least one constructor that sets the default color to GREEN.
   d.  Override the act method.
   e.  jump and canJump, similar to the Bug's move and canMove methods.  A turn
       method is also needed.
   f.  Use the class below to test your Jumper.
*/
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class JumperRunner
{
    public static void main(String[] args)
    {
        BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(20,20);
        ActorWorld world = new ActorWorld(mygrid);
    
        world.add(new Location(0,0),new Jumper());
        world.add(new Location(0,1),new Jumper());
        world.add(new Location(1,0),new Jumper());
        world.add(new Location(1,1),new Rock());
        world.add(new Location(1,2),new Bug());
        world.add(new Location(0,3),new Bug());
    
        world.add(new Location(2,6),new Jumper());
        world.add(new Location(2,7),new Jumper());
        world.add(new Location(1,7),new Rock());
        world.add(new Location(1,6),new Rock());
        world.add(new Location(0,7),new Rock());
    
        world.add(new Location(19,1),new Rock());
    
        world.show();
    }
}
