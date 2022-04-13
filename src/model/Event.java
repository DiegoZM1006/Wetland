package model;

/**
 * Event Class
 * Contains Event information
 * @author Diego F. Zuñiga
 */
public class Event
{
    // Attributes
    /**
	 * The event organizer
	 */
    private String eventOrganizer;
    /**
	 * The event cost
	 */
    private double eventCost;
    /**
	 * The event description
	 */
    private String eventDescription;

    // Associations
    private Date eventDate;

    // Constructors
    /**
     * This constructor assigns the values entered by the user.
     * @param eventOrganizer this parameter defines the organizer of the event
     * @param eventCost this parameter defines the id cost the event
     * @param eventDescription this parameter defines the description of the event
     * @param eventDate this parameter defines the date of the event
     */
    public Event(
        String eventOrganizer, 
        String eventDescription,
        double eventCost, 
        Date eventDate
    )
    {
        this.eventOrganizer = eventOrganizer;
        this.eventCost = eventCost;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    // Accessors and Mutators

    /**
     * @return String return the eventOrganizer
     */
    public String getEventOrganizer() {
        return eventOrganizer;
    }

    /**
     * @param eventOrganizer the eventOrganizer to set
     */
    public void setEventOrganizer(String eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    /**
     * @return double return the eventCost
     */
    public double getEventCost() {
        return eventCost;
    }

    /**
     * @param eventCost the eventCost to set
     */
    public void setEventCost(double eventCost) {
        this.eventCost = eventCost;
    }

    /**
     * @return String return the eventDescription
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * @param eventDescription the eventDescription to set
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * @return Date return the eventDate
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    // toString()
    /** 
     * @return String this method returns all the information about the event
     */
    public String toString() 
    {
        return  "\n*** Event ***" +
                "\nEvent Organizer: " + eventOrganizer +
                "\nEvent Cost: " + eventCost +
                "\nEvent Description: " + eventDescription +
                "\nEvent Date: " + eventDate.toString();
    }
}