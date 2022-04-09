package model;

/**
 * Date Class
 * Contains Date information
 * @author Diego F. Zuñiga
 */
public class Date
{
    // Attributes
    /**
	 * the day of the date 
	 */
    private int day;
    /**
	 * the month of the date 
	 */
    private int month;
    /**
	 * the year of the date 
	 */
    private int year;

    // Constructors
    /**
     * This constructor contains default values.
     */
    public Date()
    {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }
    /**
     * This constructor assigns the values entered by the user.
     * @param day this parameter defines the day of the date
     * @param month this parameter defines the month of the date
     * @param year this parameter defines the year of the date
     */
    public Date(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Accessors and Mutators

    /**
     * @return int return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return int return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return int return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    // toString
    /** 
     * @return String this method returns the date
     */
    public String toString()
    {
        return day + "/" + month + "/" + year;
    }
}