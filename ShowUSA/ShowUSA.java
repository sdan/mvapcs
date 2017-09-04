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
    g.setColor(Color.gray);
    Scanner citiesScanner = OpenFile.openToRead("cities.txt");
    Scanner capitalsScanner = OpenFile.openToRead("capitals.txt");
    while(citiesScanner.hasNext())
    {
      String citiesFullLine = citiesScanner.nextLine();
      Double latitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',')+2,citiesFullLine.length()));
      Double longitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',',citiesFullLine.lastIndexOf(',')-1)+1,citiesFullLine.lastIndexOf(',')));
      //System.out.println("latitude: "+(125-latitude)*16.9491525424+", longitude: "+(50-longitude)*23.0769230769);
      int laty = (int) ((125-latitude)*(PREF_W/59));
      int longy = (int) ((50-longitude)*(PREF_H/26));
      System.out.println(citiesFullLine.substring(9,citiesFullLine.indexOf(',',9)));
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

  }

  public boolean checkForCapital(String city,String state)
  {
    return true;
  }
}
