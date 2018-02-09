/**
 * This class contains class (static) methods
 * that will help you test the Picture class  
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *  
 * @author Barbara Ericson  
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("jedi.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
   
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
   
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
   
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
   
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
   
   
  public static void testKeepOnlyBlue()
  {
          Picture jedi = new Picture("jedi.jpg");
      jedi.explore();
        jedi.keepOnlyBlue();
        jedi.explore();
  }
   
  public static void testNegate()
  {
      Picture jedi = new Picture("jedi.jpg");
      jedi.explore();
        jedi.negate();
        jedi.explore();
  }
   
  public static void testGrayscale()
  {
      Picture jedi = new Picture("jedi.jpg");
      jedi.explore();
        jedi.grayscale();
        jedi.explore();
  }
   
  public static void testFixUnderwater()
  {
      Picture water = new Picture("water.jpg");
      water.explore();
        water.fixUnderwater();
        water.explore();
  }
   
  public static void testMirrorVerticalRightToLeft()
  {
        Picture jedi = new Picture("jedi.jpg");
        jedi.explore();
        jedi.mirrorVerticalRightToLeft();
        jedi.explore();
  }
     
   public static void testMirrorHorizontal()
   {
        Picture jedi = new Picture("jedi.jpg");
        jedi.explore();
        jedi.mirrorHorizontal();
        jedi.explore();
   }
    
   public static void testMirrorHorizontalBotToTop()
   {
         Picture jedi = new Picture("jedi.jpg");
        jedi.explore();
        jedi.mirrorHorizontalBotToTop();
        jedi.explore();
   }
    
   public static void testMirrorDiagonal()
   {
        Picture jedi = new Picture("jedi.jpg");
        jedi.explore();
        jedi.mirrorDiagonal();
        jedi.explore();
   }
    
   public static void testFlipVertical()
   {
        Picture jedi = new Picture("jedi.jpg");
        jedi.explore();
        jedi.flipVertical();
        jedi.explore();
   }
    
   public static void testFlipHorizontal()
   {
        Picture jedi = new Picture("jedi.jpg");
        jedi.explore();
        jedi.flipHorizontal();
        jedi.explore();
   }
    
   public static void testExtremeContrast()
   {
        Picture jedi = new Picture("jedi.jpg");
        jedi.explore();
        jedi.extremeContrast();
        jedi.explore();
   }
    
   public static void testPixelated()
   {
        Picture jedi = new Picture("jedi.jpg");
        jedi.explore();
        jedi.pixelated();
        jedi.explore();
   }
    
    
   public static void pictureLab3()
   {
       testKeepOnlyBlue();
       testNegate();
       testGrayscale();
       testFixUnderwater();
   }
    
   public static void pictureLab4()
   {
        //testMirrorVerticalRightToLeft();
        //testMirrorHorizontal();
        //testMirrorHorizontalBotToTop();
        testMirrorDiagonal();
   }
    
   public static void pictureLab5()
   {
       //testFlipVertical();
       //testFlipHorizontal();
       //testExtremeContrast();
   }
   
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //pictureLab3();
    pictureLab4();
    //pictureLab5();
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}