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
*  GetAndDrawCities class which extends the JPanel class. Sets the dimension of the JPanel 1000 pixels long by 600 pixels wide.
*  Calls the paintComponent method of superclass, which is the JPanel class.
*  Calls addCities and addCapitals methods with Graphics object g parameter so that the methods can "paint" onto JPanel.
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
      Double latitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',')+1,citiesFullLine.length()));
      //System.out.println("laty"+latitude);
      Double longitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',',citiesFullLine.lastIndexOf(',')-1)+1,citiesFullLine.lastIndexOf(',')));
      g.setColor(Color.gray);
      g.fillOval((int) ((125-latitude)*(PREF_W/59))+30,(int) ((50-longitude)*(PREF_H/26)),diameter,diameter);
    }
    citiesScanner.close();
  }
  /**
  *  Open up the capitals text file, and, for each city you find in
  *  this file, compare to the cities in cities.txt.  If you find a
  *  match, print a red dot with diameter 12.
  */
  public void addCapitals(Graphics g)
  {
    int diameter = 12;
    Scanner citiesScanner = OpenFile.openToRead("cities.txt");
    while(citiesScanner.hasNextLine())
    {
      String citiesFullLine = citiesScanner.nextLine();
      Double latitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',')+1,citiesFullLine.length()));
      //System.out.println("laty"+latitude);
      Double longitude = Double.parseDouble(citiesFullLine.substring(citiesFullLine.lastIndexOf(',',citiesFullLine.lastIndexOf(',')-1)+1,citiesFullLine.lastIndexOf(',')));
      Scanner capitalsScanner = OpenFile.openToRead("capitals.txt");
      while(capitalsScanner.hasNextLine())
      {
        String capitalsFullLine = capitalsScanner.nextLine();
        String capitalTrue = capitalsFullLine.substring(capitalsFullLine.indexOf(',')+1,capitalsFullLine.length()) +","+ capitalsFullLine.substring(0,capitalsFullLine.indexOf(','));
        String cityTrue = citiesFullLine.substring(citiesFullLine.indexOf(',')+1,citiesFullLine.indexOf(',',citiesFullLine.indexOf(',')+4));
        System.out.println("capitalTrue:"+capitalTrue+"cityTrue:"+cityTrue+"end");
        if(capitalTrue.substring(0,2)=="ME")
        System.out.println("oh");
        if(capitalTrue.equals(cityTrue))
        {
          g.setColor(Color.red);
          g.fillOval((int) ((125-latitude)*(PREF_W/59))+30,(int) ((50-longitude)*(PREF_H/26)),diameter,diameter);
        }
      }
          capitalsScanner.close();
    }
    citiesScanner.close();
  }
  /** Not using this method. No reason for the way I structured my code.
  */
  public boolean checkForCapital(String city,String state)
  {
    return false;
  }
}
