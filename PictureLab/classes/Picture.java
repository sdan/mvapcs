import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
* A class that represents a picture.  This class inherits from  
* SimplePicture and allows the student to add functionality to
* the Picture class.   
*  
* @author Barbara Ericson ericson@cc.gatech.edu
*/
public class Picture extends SimplePicture  
{
    ///////////////////// constructors //////////////////////////////////

    /**
    * Constructor that takes no arguments  
    */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
        * child constructors always call a parent constructor  
        */
        super();   
    }

    /**
    * Constructor that takes a file name and creates the picture  
    * @param fileName the name of the file to create the picture from
    */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
    * Constructor that takes the width and height
    * @param height the height of the desired picture
    * @param width the width of the desired picture
    */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
    * Constructor that takes a picture and creates a  
    * copy of that picture
    * @param copyPicture the picture to copy
    */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
    * Constructor that takes a buffered image
    * @param image the buffered image to use
    */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
    * Method to return a string with information about this picture.
    * @return a string with information about the picture such as fileName,
    * height and width.
    */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() +  
        " height " + getHeight()  
        + " width " + getWidth();
        return output;

    }
    /*
    * Method that returns height of current Picture
    * @return Height of the Picture in pixels
    */
    public int height()
    {
        return getHeight();
    }

    /*
    * Method that returns widtth of current Picture
    * @return Width of the Picture in pixels
    */
    public  int width()
    {
        return getWidth();
    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
            //pixelObj.setRed(0);
            }
        }
    }

    /**
    * Keeps only blue values in Picture
    */ 
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }  
    }

    /**
    * Reverses all pixel values
    */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(255-pixelObj.getRed());
                pixelObj.setGreen(255-pixelObj.getGreen());
                pixelObj.setBlue(255-pixelObj.getBlue());
            }
        }   
    }

    /**
    * Formats Picture in Grayscale filter
    */
    public void grayscale()
    {
        int average = 0;
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                average = (pixelObj.getRed()+pixelObj.getBlue()+pixelObj.getGreen())/3;   
                pixelObj.setRed(average);
                pixelObj.setGreen(average);
                pixelObj.setBlue(average);
            }
        }   
    }

    /**
    *   Highlights certain values under a threshold to clear the Picture
    */
    public void fixUnderwater()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                if(pixelObj.getRed()<20||pixelObj.getGreen()<20)
                {
                    pixelObj.setBlue(pixelObj.getBlue()+50);
                }
                else
                {
                    pixelObj.setRed(pixelObj.getRed()-160);
                    pixelObj.setGreen(pixelObj.getGreen()-160);
                    pixelObj.setBlue(pixelObj.getBlue()-160);
                }

            }
        }   
    }

    /** Method that mirrors the picture around a  
    * vertical mirror in the center of the picture
    * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }  
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                leftPixel = pixels[row][col];       
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
    *   Mirrors Picture vertically right to left
    */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        for(int i = 0;i<pixels.length;i++)
        {
            for(int j = 0;j<pixels[0].length/2;j++)
            {
                pixels[i][j].setColor(pixels[i][pixels[0].length-1-j].getColor());
            }
        } 
    }

    /**
    *   Mirrors Picture horizontally
    */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        for(int i = 0;i<pixels.length/2;i++)
        {
            for(int j = 0;j<pixels[0].length;j++)
            {
                pixels[pixels.length-1-i][j].setColor(pixels[i][j].getColor());
            }
        }
    }

    /**
    *   Mirrors Picture from bottom to top
    */
    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        for(int i = 0;i<pixels.length/2;i++)
        {
            for(int j = 0;j<pixels[0].length;j++)
            {
                pixels[i][j].setColor(pixels[pixels.length-1-i][j].getColor());
            }
        }
    }

    /**
    *   Mirrors Picture diagonally
    */
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        for(int i = 0;i<pixels.length;i++)
        {
            for(int j = 0;j<i;j++)
            {
                pixels[j][i].setColor(pixels[i][j].getColor());
            }
        }
    }

    /**
    *   Flips Picture Vertically
    */
    public void flipVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int i = 0;i<pixels.length/2;i++) {
            for (int j = 0;j<pixels[0].length;j++) {
                Color temp = pixels[i][j].getColor();
                pixels[i][j].setColor(pixels[pixels.length-1-i][j].getColor());
                pixels[pixels.length-1-i][j].setColor(temp);
            }
        }
    }

    /**
    *   Flips Picture Horizontally
    */
    public void flipHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        for(int i = 0;i<pixels.length;i++)
        {
            for(int j = 0;j<pixels[0].length/2;j++)
            {
                Color temp = pixels[i][j].getColor();
                pixels[i][j].setColor(pixels[i][pixels[0].length-1-j].getColor());
                pixels[i][pixels[0].length-1-j].setColor(temp);
            }
        } 
    }


    /**
    *   Saturates Picture for RGB values over a certain threshold
    */
    public void extremeContrast()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                if(pixelObj.getRed()<128)
                    pixelObj.setRed(0);
                else if(pixelObj.getRed()>=128)
                    pixelObj.setRed(255);
                if(pixelObj.getGreen()<128)
                    pixelObj.setGreen(0);
                else if(pixelObj.getGreen()>=128)
                    pixelObj.setGreen(255);
                if(pixelObj.getBlue()<128)
                    pixelObj.setBlue(0);
                else if(pixelObj.getBlue()>=128)
                    pixelObj.setBlue(255);
            }
        }   
    }

    /**
    *   Quiz question
    */
    public void flip(Picture tempPicture)
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] tempArray = tempPicture.getPixels2D();
        for (int i = 0;i<pixels.length;i++)
            for (int j = 0;j<pixels[0].length;j++)
                pixels[i][j].setColor(tempArray[tempArray.length-1-i][tempArray[0].length-1-j].getColor());
    }


    /**
    *   Pixelates 20x20 pixel regions in Picture by averaging RGB values
    */
    public void pixelated()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        //double average = 0.0;
        double red = 0.0;
        double green = 0.0;
        double blue = 0.0;
        int normal = 0;
        for (int row = 0; row < pixels.length; row+=20)
        {
            for (int col = 0; col < pixels[0].length; col+=20)
            {
                //search within block
                //average = 0.0;
                blue = 0.0;
                green = 0.0;
                red = 0.0;
                normal = 0;
                for(int i = 0;i<20;i++)
                {
                    for(int j = 0;j<20;j++)
                    {
                        normal = row+i;
                        if((normal)>=getHeight())
                            normal = getHeight()-1;
                        red+=pixels[normal][col+j].getRed();
                        blue+=pixels[normal][col+j].getBlue();
                        green+=pixels[normal][col+j].getGreen();
                    }
                }
                //System.out.println("AVERAGE: "+average);
                //System.out.println("AV 400: "+average/400);
                //average = average/400;
                red = red/400;
                green = green/400;
                blue = blue/400;
                normal = 0;
                Color colur = new Color((int)red, (int)green, (int)blue);
                for(int i = 0;i<20;i++)
                {
                    for(int j = 0;j<20;j++)
                    {
                        normal = row+i;
                        if(normal>=getHeight())
                            normal = getHeight()-1;
                        pixels[normal][col+j].setColor(colur);
                    }
                }   
            }
        }
    }

    /**
    *   Rotates Picture counterclockwise
    */
    public void rotate(double degree, Picture tempPicture)
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] tempArray = tempPicture.getPixels2D();
        double angle = Math.toRadians(degree);
        angle = -angle;
        int xnew = 0;
        int ynew = 0;
        double yCenter = (getWidth()  - 1)/2.0 ;
        double xCenter = (getHeight() - 1)/2.0;

        for (int i = 0; i < getWidth(); i++) 
        {
            for (int j = 0; j < getHeight(); j++) 
            {
                xnew = (int) ((i - yCenter)*Math.cos(angle)-(j - xCenter)*Math.sin(angle)+yCenter);
                ynew = (int) ((i - yCenter)*Math.sin(angle)+(j - xCenter)*Math.cos(angle)+xCenter);

                if (xnew >= 0 && xnew < getWidth() && ynew >= 0 && ynew < getHeight())
                    pixels[j][i].setColor(tempArray[ynew][xnew].getColor());
                else
                {
                    Color colur = new Color(0,0,0);
                    pixels[j][i].setColor(colur);
                }
            }
        }   
    }

    /**
    *   Overlays tempPicture Picture over current Picture on dominant green values in current Picture
    */
    public void greenScreen(Picture tempPicture)
    {
        //weatherman
        Pixel[][] pixels = this.getPixels2D();
        //mountain
        Pixel[][] tempArray = tempPicture.getPixels2D();
        for(int i = 0;i<pixels.length;i++)
        {
            for(int j = 0;j<pixels[0].length;j++)
            {
                if(pixels[i][j].getGreen()>(pixels[i][j].getBlue()+pixels[i][j].getRed()))
                    pixels[i][j].setColor(tempArray[i][j].getColor());
            }
        } 
    }

    /**
    *  Blurs current Picture with brush with size Range
    *  @param tempPicture of Picture type and range of int
    */
    public void blur(Picture tempPicture, int range)
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] tempArray = tempPicture.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        //double average = 0.0;
        double red = 0.0;
        double green = 0.0;
        double blue = 0.0;
        int normalR = 0;
        int normalC = 0;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                //search within block
                //average = 0.0;
                blue = 0.0;
                green = 0.0;
                red = 0.0;
                normalR = 0;
                normalC = 0;
                for(int i = 0;i<range;i++)
                {
                    for(int j = 0;j<range;j++)
                    {
                        normalR = i+row;
                        normalC = j+col;
                        if((normalR)>=getHeight())
                            normalR = getHeight()-1;
                        if((normalC)>=getWidth())
                            normalC = getWidth()-1;
                        if(normalR<=0)
                            normalR = 0;
                        if(normalC<=0)
                            normalC = 0;
                        //     System.out.println("fRED: "+red);
                        // System.out.println("fGREEN: "+green);
                        // System.out.println("fBLUE: "+blue);
                        red+=tempArray[normalR][normalC].getRed();
                        blue+=tempArray[normalR][normalC].getBlue();
                        green+=tempArray[normalR][normalC].getGreen();
                    }
                }

                red = red/(range*range);
                green = green/(range*range);
                blue = blue/(range*range);
                // System.out.println("RED: "+red);
                // System.out.println("GREEN: "+green);
                // System.out.println("BLUE: "+blue);
                normalR = 0;
                normalC = 0;
                Color colur = new Color((int)red, (int)green, (int)blue);
                pixels[row][col].setColor(colur);

            }
        }
    }

    /**
    *    Enhances current Picture with brush of size Range
    */
    public void enhance(Picture tempPicture, int range)
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] tempArray = tempPicture.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        //double average = 0.0;
        double red = 0.0;
        double green = 0.0;
        double blue = 0.0;
        int normalR = 0;
        int normalC = 0;
        for (int row = 0; row < pixels.length; row++)
        {
        for (int col = 0; col < pixels[0].length; col++)
        {
        //search within block
        //average = 0.0;
        blue = 0.0;
        green = 0.0;
        red = 0.0;
        normalR = 0;
        normalC = 0;
        for(int i = row-(range/2);i<row+(range/2);i++)
        {
        for(int j = col-(range/2);j<col+(range/2);j++)
        {
        normalR = i;
        normalC = j;
        if((normalR)>=getHeight())
        normalR = getHeight()-1;
        if((normalC)>=getWidth())
        normalC = getWidth()-1;
        if(normalR<=0)
        normalR = 0;
        if(normalC<=0)
        normalC = 0;
        //     System.out.println("fRED: "+red);
        // System.out.println("fGREEN: "+green);
        // System.out.println("fBLUE: "+blue);
        red+=tempArray[normalR][normalC].getRed();
        blue+=tempArray[normalR][normalC].getBlue();
        green+=tempArray[normalR][normalC].getGreen();
        }
        }

        red = red/(range*range);
        green = green/(range*range);
        blue = blue/(range*range);
        System.out.println("RED: "+red);
        System.out.println("GREEN: "+green);
        System.out.println("BLUE: "+blue);
        normalR = 0;
        normalC = 0;

        if(2*tempArray[row][col].getRed()-red>= 0)
        pixels[row][col].setRed(2*tempArray[row][col].getRed() - (int)red);
        else
        pixels[row][col].setRed(0);
        if(2*tempArray[row][col].getGreen()-green>= 0)
        pixels[row][col].setGreen(2*tempArray[row][col].getGreen() - (int)green);
        else
        pixels[row][col].setGreen(0);
        if(2*tempArray[row][col].getBlue()-blue>= 0)
        pixels[row][col].setBlue(2*tempArray[row][col].getBlue() - (int)blue);
        else
        pixels[row][col].setBlue(0);




        }
        }
    }





    /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
    public void copy(Picture fromPic,  
    int startRow, int startCol)
    {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;  
    fromRow < fromPixels.length &&
    toRow < toPixels.length;  
    fromRow++, toRow++)
    {
    for (int fromCol = 0, toCol = startCol;  
    fromCol < fromPixels[0].length &&
    toCol < toPixels[0].length;   
    fromCol++, toCol++)
    {
    fromPixel = fromPixels[fromRow][fromCol];
    toPixel = toPixels[toRow][toCol];
    toPixel.setColor(fromPixel.getColor());
    }
    }    
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
    }


    /** Method to show large changes in color  
    * @param edgeDist the distance for finding edges
    */
    public void edgeDetection(int edgeDist)
    {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    for (int row = 0; row < pixels.length-1; row++)
    {
    for (int col = 0; 
    col < pixels[0].length-1; col++)
    {
    leftPixel = pixels[row][col];
    rightPixel = pixels[row][col+1];
    topPixel = pixels[row][col];
    bottomPixel = pixels[row + 1][col];
    if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist)
    leftPixel.setColor(Color.BLACK);
    else if(topPixel.colorDistance(bottomPixel.getColor()) > edgeDist)  
    leftPixel.setColor(Color.BLACK);
    else
    leftPixel.setColor(Color.WHITE);
    }
    }
    }


    /* Main method for testing - each class in Java can have a main  
    * method  
    */
    public static void main(String[] args)  
    {
    Picture beach = new Picture("jedi.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this=