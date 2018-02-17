 import java.awt.Color;

public class Rotation {

    public static void main(String[] args) {
        Picture pic1 = new Picture(args[0]);
        pic1.show();
        int width  = pic1.width();
        int height = pic1.height();

        double angle = Math.toRadians(Double.parseDouble(args[1]));
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        double x0 = 0.5 * (width  - 1);     // point to rotate about
        double y0 = 0.5 * (height - 1);     // center of image

        Picture pic2 = new Picture(width, height);

        // rotation
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double a = x - x0;
                double b = y - y0;
                int xx = (int) (+a * cos - b * sin + x0);
                int yy = (int) (+a * sin + b * cos + y0);

                // plot pixel (x, y) the same color as (xx, yy) if it's in bounds
                if (xx >= 0 && xx < width && yy >= 0 && yy < height) {
                    pic2.set(x, y, pic1.get(xx, yy));
                }
            }
        }

        pic2.show();
    }
 

   
}