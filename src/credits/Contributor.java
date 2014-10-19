/*
Changelog
=====================
19 October 2014
    -1400 hours
        *initial creation
        *created all the getters and setters
        *used refactor to encapsulate fields
        *created getInfo() to print info
            - should change it to output a string later.
*/
package credits;

import java.util.ArrayList;

/**
 * Java class for contributors. This class is used for creating contributors.
 * The contributors will later be used to show credits at the end of the game.
 * 
 * @author Jackson
 * @version 1.00 19 October 2014
 */
public class Contributor {
    
    private String firstName;
    private String lastName;
    private ArrayList<String> contribution;
    
    /**
     * Creates a contributor for use in the credits. 
     * This class is set up for XML reading and writing.
     */
    public Contributor()
    {
        contribution = new ArrayList();
    }
    
    /**
     * Gets the first name of the contributor.
     * @return the first name of the contributor
     * @since version 1.00
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Gets the last name of the contributor.
     * @return the last name of the contributor
     * @since version 1.00
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * Sets the first name of the contributor.
     * @param firstName the first name of the contributor
     * @since version 1.00
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    /**
     * Sets the last name of the contributor.
     * @param lastName the last name of the contributor
     * @since version 1.00
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    /**
     * Gets the contribution at a certain spot
     * @param number contribution number to grab
     * @return the contribution at a certain number
     * @since version 1.00
     */
    public String getContribution(int number)
    {
        return this.getContribution().get(number);
    }
    /**
     * Changes the value of a specific contribution
     * @param contribution the new value of the contribution
     * @param number the position of the old contribution
     * @since version 1.00
     */
    public void changeContribution(String contribution, int number)
    {
        this.getContribution().set(number, contribution);
    }
    /**
     * Adds a contribution for the contributor
     * @param contribution contribution to add
     * @since version 1.00
     */
    public void addContribution(String contribution)
    {
        this.getContribution().add(contribution);
    }

    /**
     * @return the contribution
     * @since version 1.00
     */
    public ArrayList<String> getContribution() {
        return contribution;
    }

    /**
     * @param contribution the contribution to set
     * @since version 1.00
     */
    public void setContribution(ArrayList<String> contribution) {
        this.contribution = contribution;
    }
    
    /**
     * Prints out the first name and last name of the contributor followed by their contributions.
     * @since version 1.00
     */
    public void getInfo()
    {
        System.out.println(firstName + " " + lastName);
        for(int i =0; i < contribution.size(); i++)
        {
            System.out.println(contribution.get(i));
        }
    }
}
