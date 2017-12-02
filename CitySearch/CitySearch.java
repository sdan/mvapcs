/**
 *  CitySearch.java
 *  E            D            I    T            H    E            R            E
 *  @author Surya Dantuluri
 *  @version 1.0
 *  @since 11/28/2017
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class CitySearch
{
    /**    The ArrayList of the Cities   */
    private ArrayList<City> cities = new ArrayList<City>();
    /**
     *  Constructor for the CitySearch object
     *  Loads the information from the specified file.
     *
     * @param  fName  name of file to opened (contains city data)
     */
    public CitySearch(String fName)
    {
        loadFile(fName);
    }
    /**
     *  Constructor for the CitySearch object
     *  Loads the information from the file "cities.txt.
     */
    public CitySearch ( )
    {
        this("cities.txt");
    }
    /**
     *  Runs the program
     */
    public static void main(String [] args)
    {
        CitySearch run = new CitySearch("cities.txt");
        run.menu();
    }

    /**
     *  Provide the user with a menu of 4 choices (plus exit).  Prompt
     *  the user to make a choice, and act on this choice.  Loops until
     *  the user decides to exit.
     */
    public void menu ( )
    {
        char choice;
        do
        {
            choice = getUserInput();
            switch(choice)
            {
                case '1':
                    mergeSortName(cities,0,cities.size()-1);
                    displayCities();
                    break;
                case '2':
                    insertionSortPopulation(cities);
                    displayCities();
                    break;
                case '3':
                    insertionSortPopulation(cities);
                    displayCitiesForState();
                    break;
                case '4':
                    mergeSortName(cities,0,cities.size()-1);
                    findCity(cities);
                    break;
            }
        }while(choice >= '1' && choice <= '4');
        goodBye();
    }

    /**
     *  Prompts the user to enter a char, from the list of '1', '2',
     *  '3', '4', or '5'.  Keeps asking until one of these is chosen.
     */
    public char getUserInput ()
    {
        char choice = '0';
        System.out.println("\n\n1: Display Cities sorted by name");
        System.out.println("2: Display Cities sorted by population");
        System.out.println("3: Display Cities in a given state");
        System.out.println("4: Search for one City by name");
        System.out.println("5: Exit");

        do
        {
            choice = Prompt.getChar("\nPlease Enter 1 through 5, indicating your choice from the menu above: ");
        }
        while(choice < '1' || choice > '5');
        return choice;
    }
    /**
     *  Opens the text file, and creates the city data, saving the information
     *  into the ArrayList cities.  A typical line from cities.txt looks like this:
     *  170,Sunnyvale,CA,147559,11.9%
     *  This method will pull out the city name (a String), the state (a String),
     *  and the population (an int).  These three values will then be used to
     *  create a City object, and added to the ArrayList of cities.
     *  @param  inFileName  name of file to opened (contains city data)
     */
    private void loadFile(String inFileName)
    {
        String temp;
        String cityName = "";
        String stateName = "";
        int population = 0;
        try
        {
            Scanner inFile = new Scanner(new File(inFileName));
            inFile.nextLine();
            while(inFile.hasNext())
            {
                temp = inFile.nextLine();
                temp = temp.substring(temp.indexOf(',')+1);
                cityName = temp.substring(0,temp.indexOf(','));
                temp = temp.substring(temp.indexOf(',')+1);
                stateName = temp.substring(0,temp.indexOf(','));
                temp = temp.substring(temp.indexOf(',')+1);
                population = Integer.parseInt(temp.substring(0,temp.indexOf(',')));
                //System.out.println("city "+cityName);
                //System.out.println("state "+stateName);
                //System.out.println("pop "+population);
                cities.add(new City(cityName,stateName,population));
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /**
     *  Displays the cities, using a frame, and the toString method from the
     *  City class.
     */
    public void displayCities ( )
    {
        System.out.println("\n\n\n+------------------+");
        System.out.println("| List of Cities   |");
        System.out.println("+----------------------------------------------+");
        System.out.println("|                                              |");
        System.out.println("|  Rank  City                State Population  |");
        for (int i = 0; i < cities.size(); i++)
        {
            if (i%5 == 0)
            {
                System.out.println("|                                              |");
            }
            System.out.print("|  ");
            System.out.printf("%4d  ",(i+1));
            System.out.println(cities.get(i) + "  |");
        }
        System.out.println("|                                              |");
        System.out.println("+----------------------------------------------+");
    }
    /**
     *  Displays the cities from a chosen state, using a frame, and the toString
     *  method from the City class.  The user is prompted to enter a state name
     *  (the two-char abbreviation), then the related cities are printed.  The
     *  user continues to be prompted, until entering -1 to exit.
     */
    public void displayCitiesForState ( )
    {
        String st = Prompt.getString("\nEnter the name of the state(-1 to exit): ");
        while(!st.equals("-1"))
        {
            System.out.println("\n\n\n+------------------+");
            System.out.println("| List of Cities   |");
            System.out.println("+----------------------------------------------+");
            System.out.println("|                                              |");
            System.out.println("|  Rank  City                State Population  |");
            int counter = 0;

            //  Figure out how to print out the cities that belong to the chosen state.

            System.out.println("|                                              |");
            System.out.println("+----------------------------------------------+");
            st = Prompt.getString("\nEnter the name of the state(-1 to exit): ");
        }
    }

    /**
     *  A merge sort implementation, sorting the cities by city name (primary), and
     *  state name (secondary).
     */
    public void mergeSortName(ArrayList<City> list, int first, int last)
    {

    }

    /**
     *  A helper method for the mergeSortName method, merging two "halves" into
     *  an ordered "whole".
     */
    private void merge(ArrayList<City> list, int first, int mid, int last)
    {

    }

    /**
     *  Swaps the elements in the ArrayList at i and j.
     */
    private void swap(ArrayList<City> list, int i, int j)
    {
        City temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    /**
     *  An insertion sort implementation, sorting the cities by population.
     */
    public void insertionSortPopulation(ArrayList<City> list)
    {
      System.out.println("");
      System.out.println("listpop");
      for(int i = 1;i<list.size();i++)
      {
        int temp = list.get(i);
        int pos = i;
        while(pos>0&&temp<list.get(pos-1))
        {
          list.set(pos,list.get(pos-1));
          pos--;
        }
        list.set(pos,temp);
      }
    }

    /**
     *  A selection sort implementation, sorting the cities by population.
     */
    public void selectionSortPopulation(ArrayList<City> list)
    {
      for(int i = list.size();i>1;i++)
      {
        int max = 0;
        for(int j = 1;j<i;j++)
        {
          if(list.get(max)<list.get(j))
          max = j;
        }
        int temp = list.set(max,list.get(i-1));
        list.set(i-1,temp);
      }
    }
    /**
     *  Prompts the user to enter the name of a city and state in the form of:
     *  Cupertino, CA
     *  Calls a binary search algorithm to accomplish the search.  Continues to
     *  prompt the user until -1 is entered.
     */
    public void findCity(ArrayList<City> list)
    {
        String cityName = new String("");
        do
        {
            System.out.println("\n\n----------------------------------------------------------------\n");
            cityName = Prompt.getString("Please enter a City and State (City, State) to search for (-1 to exit): ");

            //  Call the binary search algorithm (method).

        }while(!cityName.equals("-1"));
    }

    /**
     *  A binary search.  A counter is kept, so that the number of steps (times inside the loop)
     *  can be displayed after each search.
     */
    public int binarySearch (ArrayList<City> list, City city)
    {
        int counter = 0;
        int low = 0;
        int high = list.size() - 1;
        int mid;
        //  Use a binary search algorithm to find the city.
        System.out.println("\nThe binary search took " + counter + " steps to determine that this City does not exist in the list.");
        return -1;
    }
    /**
     *  An exit message.
     */
    public void goodBye ( )
    {
        System.out.println("\n\nThanks for reviewing the City Search results!\n\n\n");
    }
}
