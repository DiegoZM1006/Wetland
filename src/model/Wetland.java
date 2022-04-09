package model;

/**
 * Wetland Class
 * Contains wetland information
 * @author Diego F. Zuñiga
 */
public class Wetland
{
    // Attributes
    /**
	 * The wetland ID
	 */
    private String wetlandId;
    /**
	 * The wetland Name
	 */
    private String wetlandName;
    /**
	 * The wetland Zone
	 */
    private String wetlandZone;
    /**
	 * The wetland Type
	 */
    private String wetlandType;
    /**
	 * The wetland Km2
	 */
    private double wetlandKm2;
    /**
	 * The wetland Photo Url
	 */
    private String wetlandPhotoUrl;
    /**
	 * If the wetland is protected or no
	 */
    private boolean wetlandProtected;

    // Associations
    /**
	 * The species in the wetland
	 */
    private Specie[] wetlandSpecies;
    /**
	 * The events in the wetland
	 */
    private Event[] wetlandEvents;
    /**
	 * Management of the wetland environmental plan
	 */
	private ManagementPlan managementPlan;

    // Constructors
    /**
     * This constructor contains default values.
     */
    public Wetland()
    {
        this.wetlandId = "Unspecified";
        this.wetlandName = "Unspecified";
        this.wetlandZone = "Unspecified";
        this.wetlandType = "Unspecified";
        this.wetlandKm2 = 0.00;
        this.wetlandPhotoUrl = "Unspecified";
        this.wetlandProtected = false;
    }
    /**
     * This constructor assigns the values entered by the user.
     * @param wetlandId this parameter defines the id of the wetland
     * @param wetlandName this parameter defines the name of the wetland
     * @param wetlandZone this parameter defines the zone of the wetland
     * @param wetlandType this parameter defines the type of the wetland
     * @param wetlandKm2 this parameter defines the km2 of the wetland
     * @param wetlandPhotoUrl this parameter defines the photo url of the wetland
     * @param wetlandProtected this parameter defines if the wetland is protected or no
     */
    public Wetland(
        String wetlandId, String wetlandName, String wetlandZone, 
        String wetlandType, double wetlandKm2, String wetlandPhotoUrl,
        boolean wetlandProtected
    )
    {
        this.wetlandId = wetlandId;
        this.wetlandName = wetlandName;
        this.wetlandZone = wetlandZone;
        this.wetlandType = wetlandType;
        this.wetlandKm2 = wetlandKm2;;
        this.wetlandPhotoUrl = wetlandPhotoUrl;
        this.wetlandProtected = wetlandProtected;
    }
    
    // Accesors and Mutators

    /**
     * @return String return the wetlandId
     */
    public String getWetlandId() {
        return wetlandId;
    }

    /**
     * @param wetlandId the wetlandId to set
     */
    public void setWetlandId(String wetlandId) {
        this.wetlandId = wetlandId;
    }

    /**
     * @return String return the wetlandName
     */
    public String getWetlandName() {
        return wetlandName;
    }

    /**
     * @param wetlandName the wetlandName to set
     */
    public void setWetlandName(String wetlandName) {
        this.wetlandName = wetlandName;
    }

    /**
     * @return String return the wetlandZone
     */
    public String getWetlandZone() {
        return wetlandZone;
    }

    /**
     * @param wetlandZone the wetlandZone to set
     */
    public void setWetlandZone(String wetlandZone) {
        this.wetlandZone = wetlandZone;
    }

    /**
     * @return String return the wetlandType
     */
    public String getWetlandType() {
        return wetlandType;
    }

    /**
     * @param wetlandType the wetlandType to set
     */
    public void setWetlandType(String wetlandType) {
        this.wetlandType = wetlandType;
    }

    /**
     * @return double return the wetlandKm2
     */
    public double getWetlandKm2() {
        return wetlandKm2;
    }

    /**
     * @param wetlandKm2 the wetlandKm2 to set
     */
    public void setWetlandKm2(double wetlandKm2) {
        this.wetlandKm2 = wetlandKm2;
    }

    /**
     * @return String return the wetlandPhotoUrl
     */
    public String getWetlandPhotoUrl() {
        return wetlandPhotoUrl;
    }

    /**
     * @param wetlandPhotoUrl the wetlandPhotoUrl to set
     */
    public void setWetlandPhotoUrl(String wetlandPhotoUrl) {
        this.wetlandPhotoUrl = wetlandPhotoUrl;
    }

    /**
     * @return boolean return the wetlandProtected
     */
    public boolean isWetlandProtected() {
        return wetlandProtected;
    }

    /**
     * @param wetlandProtected the wetlandProtected to set
     */
    public void setWetlandProtected(boolean wetlandProtected) {
        this.wetlandProtected = wetlandProtected;
    }

    /**
     * @return Specie[] return the wetlandSpecies
     */
    public Specie[] getWetlandSpecies() {
        return wetlandSpecies;
    }

    /**
     * @param wetlandSpecies the wetlandSpecies to set
     */
    public void setWetlandSpecies(Specie[] wetlandSpecies) {
        this.wetlandSpecies = wetlandSpecies;
    }

    /**
     * @return Event[] return the wetlandEvents
     */
    public Event[] getWetlandEvents() {
        return wetlandEvents;
    }

    /**
     * @param wetlandEvents the wetlandEvents to set
     */
    public void setWetlandEvents(Event[] wetlandEvents) {
        this.wetlandEvents = wetlandEvents;
    }

    /**
     * @return ManagementPlan return the managementPlan
     */
    public ManagementPlan getManagementPlan() {
        return managementPlan;
    }

    /**
     * @param managementPlan the managementPlan to set
     */
    public void setManagementPlan(ManagementPlan managementPlan) {
        this.managementPlan = managementPlan;
    }

    public void setContAnimals(int contAnimals)
    {
        wetlandSpecies = new Specie[contAnimals];
    }

    public void setContEvents(int contEvents)
    {
        wetlandSpecies = new Specie[contEvents];
    } 
    
    // toString()
    /** 
     * @return String this method returns all the information about the wetland
     */
    public String toString()
    {
        return  "\n*** Wetland (" + wetlandName + ") ***" +
                "\nWetland Id: " + wetlandId +
                "\nWetland Zone: " + wetlandZone +
                "\nWetland Type; " + wetlandType +
                "\nWetland km2: " + wetlandKm2 + "km2" +
                "\nWetland Photo Url: " + wetlandPhotoUrl +
                "\nWetland Protected: " + wetlandProtected +
                "\nWetland Species: " + this.getWetlandSpecies().length +
                "\nWetland Events: " + this.getWetlandEvents().length;
    }
}