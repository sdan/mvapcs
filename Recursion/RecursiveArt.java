/**
 *  RecursiveArt.java
 *  Draws Pokemon recursively using StdDraw.java
 *  @author Surya Dantuluri
 *  @version 1.0
 *  @since 1/22/2018
 */

import java.awt.Color;

public class RecursiveArt {
    public static void main(String[] args) {
        int n = 4;
        n = Integer.parseInt(args[0]);
        StdDraw.setCanvasSize(800 ,600);
        StdDraw.picture(0.5,0.5,"mv.png",1,1);
        draw(n, 0.5, 0.5, 0.5, 0);
    }

    public static void draw(int n, double x, double y, double size, double angle) {
        if (n == 0) 
            return;
        drawPokemon(x, y, size, angle);
        double ratio = 2.2;
        draw(n-1, x - size/2, y - size/2, size/ratio, 0);    // lower left
        draw(n-1, x - size/2, y + size/2, size/ratio, 60);    // upper left
        draw(n-1, x + size/2, y - size/2, size/ratio, -60);    // lower right
        draw(n-1, x + size/2, y + size/2, size/ratio, 180);    // upper right
    }

    public static void drawPokemon(double x, double y, double size, double angle) {
    StdDraw.picture(x ,y ,"bulbasaur.png",size,size,angle);
    }

}
