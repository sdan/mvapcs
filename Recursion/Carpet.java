import java.awt.Color;

public class Carpet
{
	public static void main(String[]args)
	{
		double [] x = {0,0.5,1.0};
		double [] y = {0.1,0.1+Math.sqrt(3)/2,0.1};
		StdDraw.setCanvasSize(700,700);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledSquare(0.5,0.5,0.5);
		int n =3;
		if(args.length>0)
		n = Integer.parseInt(args[0]);
		double sidelength = 1.0/3, xcenter = 0.5, ycenter = 0.5;
		sierpinski(n,sidelength, xcenter, ycenter);
	}
	
	public static void sierpinski(int n, double len, double xc, double yc)
	{
		if(n==0)
		return;
		drawSquare(len, xc, yc);
		sierpinski(n-1,len/3,xc-len,yc-len);
		sierpinski(n-1,len/3,xc,yc-len);
		sierpinski(n-1,len/3,xc+len,yc-len);
		sierpinski(n-1,len/3,xc-len,yc);
		sierpinski(n-1,len/3,xc+len,yc);
		sierpinski(n-1,len/3,xc-len,yc+len);
		sierpinski(n-1,len/3,xc,yc+len);
		sierpinski(n-1,len/3,xc+len,yc+len);
	}
	
	public static void drawSquare(double len, double xc, double yc)
	{
		StdDraw.setPenColor((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		StdDraw.filledSquare(xc,yc,len/2);
	}
}
