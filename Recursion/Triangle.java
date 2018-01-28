import java.awt.Color;

public class Triangle{
	public static void main(String [] args){
		double [] x = {0, 0.5, 1};
		double [] y = {0.1, 0.1 + Math.sqrt(3)/2, .1};
			
		StdDraw.setCanvasSize(1000,1000);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledPolygon(x,y);
		int n = Integer.parseInt(args[0]);
		double sidelength = 0.5, xcenter = 0.5, ycenter = 0.1 + Math.sqrt(3)/8;
		sierpinski(n, sidelength, xcenter, ycenter);
	}
	
	public static void sierpinski(int n, double length, double xc, double yc){
		if(n==0)
			return;
		drawTriangle(length, xc, yc);
		sierpinski(n-1, length/2, xc-length/2,  yc - length/8 * Math.sqrt(3));
		sierpinski(n-1, length/2, xc + length/2, yc - length/8 * Math.sqrt(3));
		sierpinski(n-1, length/2,  xc, yc + 3*length/8 * Math.sqrt(3));

	}
	
	public static void drawTriangle(double length,double xc, double yc){
		double [] x = {xc-length/2, xc, xc+length/2};
		double [] y = {yc + length/4 *Math.sqrt(3), yc - length/4*Math.sqrt(3), yc + length/4*Math.sqrt(3)};
		StdDraw.setPenColor(new Color(0, 100 + (int)Math.random()*155, 100 + (int)Math.random()*155));
		StdDraw.filledPolygon(x,y);

	}
}