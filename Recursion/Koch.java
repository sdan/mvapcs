public class Koch {
public static double x = 0;
public static double y = 0;
public static void main(String args[]) 
	{
		int N = Integer.parseInt(args[0]);
		int width = 512;
		int height = (int) (2 * width / Math.sqrt(3));
		double size = width / Math.pow(3.0, N);




		StdDraw.setCanvasSize(width,height);

		StdDraw.line(x,y,0.0,width*Math.sqrt(3)/2);

		koch(N, size,0.0);
		koch(N, size,-120.0);
		koch(N, size,-120.0);


	}




public static void koch(int n, double size, double angle) {
	angle = angle * Math.PI / 180;
	if (n == 0) 
		StdDraw.line(x,y,x+size*Math.sin(angle),y+size*Math.cos(angle));
	else 
	{
		koch(n-1, size,0.0);
		koch(n-1, size,60.0);
		koch(n-1, size,-120.0);
		koch(n-1, size,60.0);
	}
}






}
