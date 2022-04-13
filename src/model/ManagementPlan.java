package model;

/**
 * Management Plan Class
 * Contains Management Plan information
 * @author Diego F. Zuñiga
 */
public class ManagementPlan
{
    // Attributes
    /**
	 * The management plan porcentage
	 */
    private double porcentage;
    /**
     * The type of the plan
     */
    private String typePlan;
    /**
     * The date of the management plan
     */
    private Date theDate;

    // Constructors
    /**
     * This constructor assigns the values entered by the user.
     * @param eventOrganizer this parameter defines the organizer of the management plan
     * @param eventCost this parameter defines the event cost of the management plan 
     * @param eventDescription this parameter defines the event description of the management plan
     * @param eventDate this parameter defines the event date of the management plan
     * @param managementPlanPorcentage this parameter defines the porcentage of the management plan
     */
    public ManagementPlan(
        String typePlan, double porcentage, Date theDate
    )
    {
        this.typePlan = typePlan;
        this.theDate = theDate;
        this.porcentage = porcentage;
    }

    // Accessors and Mutators

    /**
     * @return double return the porcentage
     */
    public double getPorcentage() {
        return porcentage;
    }

    /**
     * @param porcentage the porcentage to set
     */
    public void setPorcentage(double porcentage) {
        this.porcentage = porcentage;
    }

    /**
     * @return String return the typePlan
     */
    public String getTypePlan() {
        return typePlan;
    }

    /**
     * @param typePlan the typePlan to set
     */
    public void setTypePlan(String typePlan) {
        this.typePlan = typePlan;
    }

    // toString()
    /** 
     * @return String this method returns all the information about the management plan
     */
    public String toString() 
    {
        return  "\n*** Management Plan ***" +
                "\nType plan: " + typePlan +
                "\nManagement Plan Porcentage: " + porcentage +
                "\nDate: " + theDate.toString();
    }

}