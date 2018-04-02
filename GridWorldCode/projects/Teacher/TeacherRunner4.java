


import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class TeacherRunner4
{
	public static void main(String[] args)
	{
		int size = 10;
		BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(size,size);
		ActorWorld world = new ActorWorld(mygrid);
		
		world.add(new Location(0,0), new Student());
		Teacher anderson = new Teacher();
		world.add(new Location(0,1), anderson);
		anderson.setDirection(Location.WEST);
		Teacher stark = new Teacher();
		world.add(new Location(1,1), stark);
		stark.setDirection(Location.NORTHWEST);
		Teacher conlin = new Teacher();
		world.add(new Location(1,0), conlin);
		conlin.setDirection(Location.NORTH);
		
		world.add(new Location(0,9), new Student());
		Teacher birdsong = new Teacher();
		world.add(new Location(0,8), birdsong);
		birdsong.setDirection(Location.EAST);
		Teacher gupta = new Teacher();
		world.add(new Location(1,8), gupta);
		gupta.setDirection(Location.NORTHEAST);
		Teacher onodera = new Teacher();
		world.add(new Location(2,7), onodera);
		onodera.setDirection(Location.NORTHEAST);
		
		world.add(new Location(4,4), new Student());
		Teacher shimazaki = new Teacher();
		world.add(new Location(4,3), shimazaki);
		shimazaki.setDirection(Location.EAST);
		Teacher clarke = new Teacher();
		world.add(new Location(4,2), clarke);
		clarke.setDirection(Location.EAST);
		
		world.add(new Location(6,6), new Student());
		world.add(new Location(6,5), new Student());
		Teacher autran = new Teacher();
		world.add(new Location(6,4), autran);
		autran.setDirection(Location.EAST);
		
		world.add(new Location(8,0), new Student());
		Teacher platt = new Teacher();
		world.add(new Location(7,1), platt);
		platt.setDirection(Location.SOUTH);
		Teacher sturgill = new Teacher();
		world.add(new Location(8,1), sturgill);
		sturgill.setDirection(Location.SOUTH);
		Teacher pelkey = new Teacher();
		world.add(new Location(9,1), pelkey);
		pelkey.setDirection(Location.SOUTH);
		Teacher belshe = new Teacher();
		world.add(new Location(9,0), belshe);
		belshe.setDirection(Location.EAST);
		
		world.add(new Location(9,9), new Student());
		Teacher jensen = new Teacher();
		world.add(new Location(8,9), jensen);
		jensen.setDirection(Location.WEST);
		Teacher sullivan = new Teacher();
		world.add(new Location(8,8), sullivan);
		sullivan.setDirection(Location.EAST);
		Teacher tait = new Teacher();
		world.add(new Location(8,7), tait);
		tait.setDirection(Location.EAST);
		
		world.show();
	}
}
