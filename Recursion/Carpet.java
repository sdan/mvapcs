import java.awt.Color;

public class Carpet{
	public static void main(String [] args){

			
		StdDraw.setCanvasSize(1000,1000);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledSquare(.5,.5,1.0/2.0);
		int n = 5;
		if(args.length > 0)
			n= Integer.parseInt(args[0]);
			
	
		double sidelength = 1.0/3.0, xcenter = 0.5, ycenter = 0.5;
		sierpinski(n, sidelength, xcenter, ycenter);
	}
	
	public static void sierpinski(int n, double length, double xc, double yc){
		if(n==0)
			return;
		drawSquare(length, xc, yc);
		sierpinski(n-1, length/3, xc-length, yc); //left
		sierpinski(n-1, length/3, xc + length, yc); //right
		sierpinski(n-1, length/3,  xc, yc - length); //down
		sierpinski(n-1, length/3, xc, yc + length); //up
		sierpinski(n-1, length/3, xc - length, yc +length); //topleft
		sierpinski(n-1, length/3, xc - length, yc -length); //bottom left
		sierpinski(n-1, length/3, xc+length, yc -length); //topright
		sierpinski(n-1, length/3, xc + length, yc +length); //topleft

	
	}
	
	public static void drawSquare(double length,double xc, double yc){
		StdDraw.setPenColor(new Color(100+(int)(Math.random()*(100)),100+(int)(Math.random()*(100)),100+(int)(Math.random()*(100))));
		StdDraw.filledSquare(xc,yc,length/2);

	}
	
}