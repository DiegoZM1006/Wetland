package model;

/**
 * Management Plan Class
 * Contains Management Plan information
 * @author Diego F. Zuñiga
 */
public class ManagementPlan extends Event
{
    // Attributes
    /**
	 * The management plan porcentage
	 */
    private double managementPlanPorcentage;

    // Constructors
    /**
     * This constructor contains default values.
     */
    public ManagementPlan()
    {
        super();
        this.managementPlanPorcentage = 0;
    }
    /**
     * This constructor assigns the values entered by the user.
     * @param eventOrganizer this parameter defines the organizer of the management plan
     * @param eventCost this parameter defines the event cost of the management plan 
     * @param eventDescription this parameter defines the event description of the management plan
     * @param eventDate this parameter defines the event date of the management plan
     * @param managementPlanPorcentage this parameter defines the porcentage of the management plan
     */
    public ManagementPlan(
        String eventOrganizer, double eventCost, 
        String eventDescription, Date eventDate, Double managementPlanPorcentage
    )
    {
        super(eventOrganizer, eventCost, eventDescription, eventDate);
        this.managementPlanPorcentage = managementPlanPorcentage;
    }

    // Accessors and Mutators

    /**
     * @return double return the managementPlanPorcentage
     */
    public double getManagementPlanPorcentage() {
        return managementPlanPorcentage;
    }

    /**
     * @param managementPlanPorcentage the managementPlanPorcentage to set
     */
    public void setManagementPlanPorcentage(double managementPlanPorcentage) {
        this.managementPlanPorcentage = managementPlanPorcentage;
    }

    // toString()
    /** 
     * @return String this method returns all the information about the management plan
     */
    public String toString() 
    {
        return  "\n*** Event ***" +
                "\nEvent Organizer: " + this.getEventOrganizer() +
                "\nEvent Cost: " + this.getEventCost() +
                "\nEvent Description: " + this.getEventDescription() +
                "\nEvent Date: " + this.getEventDate() +
                "\nManagement Plan Porcentage: " + managementPlanPorcentage;
    }
}