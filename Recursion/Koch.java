public class Koch {
public static double x = 0;
public static double y = 0;
public static void main(String args[]) 
	{
		int n = Integer.parseInt(args[0]);

		StdDraw.setCanvasSize(600,800);
		StdDraw.picture(0.5,0.5,"mv.png",1,1);
		sierpinski(n, 0.5, 0.5,0.5,0.0);
	}

public static void sierpinski(int n, double length, double xc, double yc, double angle){
		if(n==0)
			return;
		drawKoch(length, xc, yc, angle);
		sierpinski(n-1, length+0.2, xc-length/5, yc-length/5, 60.0);
		sierpinski(n-1, length-0.2, xc+length/5,yc-length/5, -120.0);
		sierpinski(n-1, length,  xc, yc-length/5, 60.0);

	}


public static void drawKoch(double size, double x1, double y1, double angle) {
		StdDraw.picture(x1 ,y1 ,"bulbasaur.png",0.1,0.1,angle);
}






}
