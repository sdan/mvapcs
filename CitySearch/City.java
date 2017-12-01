/**
 *  City.java
 *  Represents a City within the United States of America,
 *  with attributes for name, state, and population.  Contains
 *  methods for comparison (compareTo, compareToPopulation, and
 *  equals), and a toString method.
 *  @author Surya Dantuluri
 *  @version 1.0
 *  @since 11/28/2017
 */
public class City implements Comparable<City>
{
    /**    The name of the City   */
    private String name;

    /**    The state this City belongs to   */
    private String state;

    /**    The population of this City   */
    private int population;
    /**
     *  Constructor for the City object
     *
     * @param  n  name of City
     * @param  s  state of City
     * @param  p  population number
     */
    public City(String n, String s, int p)
    {
        name = n;
        state = s;
        population = p;
    }
    /**
     *  You will need to write methods to compare Cities according to name
     *  and population.  The comparison methods will be used in the sorting
     *  algorithms.  You may need to write other methods, as well.
     */

    /**
     *  Compares the names of the Cities, returning a negative number if
     *  the calling City is less than the City passed as an argument.  A
     *  positive number is returned if the calling City is greater than
     *  the City passed as an argument.  Use the name (primary) and state
     *  (secondary) to make the comparison.
     *  @param other      The City to be compared
     *  @return           a negative integer, zero, or a positive integer
     *                    as this City is less than, equal to, or greater
     *                    than the City to be compared
     */
     public int compareTo(City other)
     {
        return name.compareTo(other.name);
     }
    /**
     *  Compares two City objects by their populations
     *
     * @param  other      City object to compare to
     * @return            positive int if population > other.population
     *                    0 if population equals other.population
     *                    negative int if population < other.population
     */
    public int compareToPopulation(City other)
    {
        return this.population-other.population;
    }
    /**
     *  Compares the City to the specified object.  The Cities should
     *  be considered equal if they have the same name and state
     *  (you may disregard population).  This method should make use
     *  of the compareTo method (see above).
     *
     * @param  other      City object to compare to
     * @return            true if equal, false otherwise
     */
    public boolean equals(Object obj)
    {
        boolean isequal = false;
        if(obj!=null)
        {
            if(compareTo((City)obj)==0)
            isequal=true;
        }
        return isequal;
    }
    /**
     *  Returns all of the information for this City as a String.
     *  @return           The String representing the City
     */
    public String toString()
    {
        return String.format("%-22s %-4s  %7d",name,state, population);
    }
}
