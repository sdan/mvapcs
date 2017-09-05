/**
*  ShowUSA.java
*  Provide a description here.
*  @author Surya Dantuluri
*  @version 1.0
*  @since 9/4/2017
*/
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
import java.lang.Double;
public class ShowUSA extends JFrame
{
  /**
  *  Creates a ShowUSA object, adding a JPanel
  *  to the JFrame.
  */
  public ShowUSA()
  {
    super("United States of America");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GetAndDrawCities cities = new GetAndDrawCities();
    getContentPane().add(cities);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args)
  {
    new ShowUSA();
  }
}
/**
*  Add comments.
*/
class GetAndDrawCities extends JPanel
{
  private static final int PREF_W = 1000;
  private static final int PREF_H = 600;

  public GetAndDrawCities()
  {
    setBackground(Color.white);
  }
  @Override
  public Dimension getPreferredSize()
  {
    return new Dimension(PREF_W, PREF_H);
  }

  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    addCities(g);
    addCapitals(g);
  }

  /**
  *  Here, you should open up the cities text file, and translate the
  *  numbers you find to coordinate values to be plotted.  The
  *  dots should be gray and of diameter 4.
  */
  public void addCities(Graphics g)
  {
    int diameter = 4;
    Scanner citiesScanner = OpenFile.openToRead("cities.txt");
    while(citiesScanner.hasNextLine())
    {
      String citiesFullLine = citiesScanner.nextLine();
      Double latitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',')+2,citiesFullLine.length()));
      Double longitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',',citiesFullLine.lastIndexOf(',')-1)+1,citiesFullLine.lastIndexOf(',')));
      g.setColor(Color.gray);
      g.fillOval((int) ((125-latitude)*(PREF_W/59)),(int) ((50-longitude)*(PREF_H/26)),4,4);
    }

    System.out.println("done");

  }

  /**
  *  Open up the capitals text file, and, for each city you find in
  *  this file, compare to the cities in cities.txt.  If you find a
  *  match, print a red dot with diameter 12.
  */
  public void addCapitals(Graphics g)
  {
    Scanner citiesScanner = OpenFile.openToRead("cities.txt");
    while(citiesScanner.hasNextLine())
    {
      String citiesFullLine = citiesScanner.nextLine();
      Double latitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',')+2,citiesFullLine.length()));
      Double longitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',',citiesFullLine.lastIndexOf(',')-1)+1,citiesFullLine.lastIndexOf(',')));
      Scanner capitalsScanner = OpenFile.openToRead("capitals.txt");
      while(capitalsScanner.hasNextLine())
      {
        String capitalsFullLine = capitalsScanner.nextLine();
        String capitalTrue = capitalsFullLine.substring(capitalsFullLine.indexOf(',')+2,capitalsFullLine.length()) +","+ capitalsFullLine.substring(0,capitalsFullLine.indexOf(','));
        String cityTrue = citiesFullLine.substring(6,citiesFullLine.indexOf(',',9));
        if(capitalTrue.equals(cityTrue))
        {
          System.out.println(capitalTrue);
          g.setColor(Color.red);
          g.fillOval((int) ((125-latitude)*(PREF_W/59)),(int) ((50-longitude)*(PREF_H/26)),12,12);
        }

      }
    }
  }

  public boolean checkForCapital(String city,String state)
  {
    return true;
  }
}
