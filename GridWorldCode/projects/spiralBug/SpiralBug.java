import info.gridworld.actor.Bug;

public class SpiralBug extends Bug
{
    private int steps; //steps is counter that goes until length of the square
    private int sideLength; //length of the square
    
    public SpiralBug(int length)
    {
        steps = 0;
        sideLength = length;
    }
    
    public void act()
    {
        if(steps<sideLength && canMove())
        {  
            move();
            steps++;
        }
        else
        {
            sideLength++;
            turn();
            turn();
            steps=0;
        }



    
    }



}
