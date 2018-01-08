import java.awt.Color;
public class RecursiveSquares {

    // plot a square, centered on (x, y) of the given side length
    // with a light gray background and black border
    public static void drawSquare(double x, double y, double size, Color color) {
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(x, y, size/2);
        StdDraw.setPenColor(color);
        StdDraw.square(x, y, size/2);
    }

    // plot an order n recursive squares pattern
    // centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size, Color color) {
        if (n == 0) return;

        drawSquare(x, y, size, color);

        // 2.2 ratio looks good
        double ratio = 2.2;
        Color nice = new Color(0,0,0);
        // recursively draw 4 smaller trees of order n-1
        int something = (int)(Math.random()*13+1);
        System.out.println("RAND: "+something);
        if(something==1)
        nice = StdDraw.BLACK;
        if(something==2)
        nice = StdDraw.BLUE;
        if(something==3)
        nice = StdDraw.CYAN;
        if(something==4)
        nice = StdDraw.DARK_GRAY;
        if(something==5)
        nice = StdDraw.GRAY;
        if(something==6)
        nice = StdDraw.GREEN;
        if(something==7)
        nice = StdDraw.LIGHT_GRAY;
        if(something==8)
        nice = StdDraw.MAGENTA;
        if(something==9)
        nice = StdDraw.ORANGE;
        if(something==10)
        nice = StdDraw.PINK;
        if(something==11)
        nice = StdDraw.RED;
        if(something==12)
        nice = StdDraw.WHITE;
        if(something==13)
        nice = StdDraw.YELLOW;

        draw(n-1, x - size/2, y - size/2, size/ratio, nice);    // lower left
        draw(n-1, x - size/2, y + size/2, size/ratio, nice);    // upper left
        draw(n-1, x + size/2, y - size/2, size/ratio, nice);    // lower right
        draw(n-1, x + size/2, y + size/2, size/ratio, nice);    // upper right
    }


    // read in an integer command-line argument n and plot an order n recursive
    // squares pattern
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5;   // center of square
        double size = 0.5;         // side length of square
        draw(n, x, y, size, StdDraw.YELLOW);
    }

}
