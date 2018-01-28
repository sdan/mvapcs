import java.awt.Color;

public class RecursiveArt {

   

    public static void main(String[] args)  {
        double xc   = Double.parseDouble(args[0]);
        double yc   = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);

        int n   = 512;   // create n-by-n image
        int max = 255;   // maximum number of iterations

        StdDraw.setCanvasSize(512,512);
        StdDraw.setPenColor(Color.WHITE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double x = xc - size/2 + size*i/n;
                double y = yc - size/2 + size*j/n;

                int gray = max - mandelbrot(x,y,max);


                Color color = new Color(gray, gray, gray);
                StdDraw.setPenColor(color);
                StdDraw.point(i,n-1-j);
            }
        }
    }

    // return number of iterations to check if c = a + ib is in Mandelbrot set
    public static int mandelbrot(double real, double imaginary, int max) 
    {
        double tempReal = real;
        double tempImaginary = imaginary;
        for (int i = 0; i < max; i++) 
        {
            if (Math.hypot(tempReal,tempImaginary)> 2.0) 
                return i;
            tempReal = tempReal*tempReal-tempImaginary*tempImaginary;
            tempReal = tempReal+real;
            tempImaginary = tempImaginary*tempImaginary-tempReal*tempReal;
            tempImaginary = tempImaginary + imaginary;
        }
        return max;
    }




}
