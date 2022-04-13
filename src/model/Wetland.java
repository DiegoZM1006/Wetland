package model;

/**
 * Wetland Class
 * Contains wetland information
 * @author Diego F. Zuñiga
 */
public class Wetland
{
    private static final int MAX_SPECIES = 100;
    private static final int MAX_EVENTS = 100;
    private static final int MAX_MANAGEMENTPLANS = 100;
    // Attributes
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
    /**
     * The wetland name of the zone
     */
    private String wetlandNameOfTheZone;

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
	private ManagementPlan[] managementPlan;

    // Constructors
    /**
     * This constructor assigns the values entered by the user.
     * @param wetlandName this parameter defines the name of the wetland
     * @param wetlandZone this parameter defines the zone of the wetland
     * @param wetlandType this parameter defines the type of the wetland
     * @param wetlandKm2 this parameter defines the km2 of the wetland
     * @param wetlandPhotoUrl this parameter defines the photo url of the wetland
     * @param wetlandProtected this parameter defines if the wetland is protected or no
     */
    // name, locationZone, type, size, urlPicture, protection, nameOfTheZone
    public Wetland(
        String wetlandName, String wetlandZone, String wetlandType,
        double wetlandKm2, String wetlandPhotoUrl, boolean wetlandProtected,
        String wetlandNameOfTheZone
    )
    {
        this.wetlandName = wetlandName;
        this.wetlandZone = wetlandZone;
        this.wetlandType = wetlandType;
        this.wetlandKm2 = wetlandKm2;;
        this.wetlandPhotoUrl = wetlandPhotoUrl;
        this.wetlandProtected = wetlandProtected;
        this.setWetlandNameOfTheZone(wetlandNameOfTheZone);
        wetlandSpecies = new Specie[MAX_SPECIES];
        wetlandEvents = new Event[MAX_EVENTS];
        managementPlan = new ManagementPlan[MAX_MANAGEMENTPLANS];
    }
    
    // Accesors and Mutators

    /**
     * @return String return the wetlandNameOfTheZone
     */
    public String getWetlandNameOfTheZone() {
        return wetlandNameOfTheZone;
    }

    /**
     * @param wetlandNameOfTheZone the wetlandNameOfTheZone to set
     */
    public void setWetlandNameOfTheZone(String wetlandNameOfTheZone) {
        this.wetlandNameOfTheZone = wetlandNameOfTheZone;
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
    public String getManagementPlan() {
        String out = "";
        for (int i = 0; i < managementPlan.length && managementPlan[i] != null; i++) {
            out += managementPlan[i].toString();
        }
        return out;
    }

    /**
     * @param managementPlan the managementPlan to set
     */
    public void setManagementPlan(ManagementPlan[] managementPlan) {
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

    public int getEmptyPositionSpecies(){
        boolean emptyPosition = false;
		int position = -1;
		for (int i=0; i< wetlandSpecies.length && !emptyPosition; i++){
			if(wetlandSpecies[i] == null){
				emptyPosition = true;
				position = i;
			}
		}
		return position;
    }

    public String addSpecie(String name, String scientificName, String migratoryType, String type) {
		String out = "";		
		int emptyPos = getEmptyPositionSpecies(); //busco la primera posición vacía
		// si el arreglo está lleno?
		out = "Entra al metodo";
		if(emptyPos == -1){ // está lleno
			//no se puede agregar
			out = "El arreglo está lleno";
		}else{ //Si no está lleno

			wetlandSpecies[emptyPos] = new Specie(name, scientificName, migratoryType, type); 
			out = "El registro fue exitoso";
		}
		return out;
	}

    public int getEmptyPositionEvent(){
        boolean emptyPosition = false;
		int position = -1;
		for (int i=0; i< wetlandEvents.length && !emptyPosition; i++){
			if(wetlandEvents[i] == null){
				emptyPosition = true;
				position = i;
			}
		}
		return position;
    }

    public String addEvent(String manager, String description, double cost, Date theDate) {
		String out = "";		
		int emptyPos = getEmptyPositionEvent(); //busco la primera posición vacía
		// si el arreglo está lleno?
		out = "Entra al metodo";
		if(emptyPos == -1){ // está lleno
			//no se puede agregar
			out = "El arreglo está lleno";
		}else{ //Si no está lleno

			wetlandEvents[emptyPos] = new Event(manager, description, cost, theDate); 
			out = "El registro fue exitoso";
		}
		return out;
	}

    public int getEmptyPositionManagementPlan(){
        boolean emptyPosition = false;
		int position = -1;
		for (int i=0; i< managementPlan.length && !emptyPosition; i++){
			if(managementPlan[i] == null){
				emptyPosition = true;
				position = i;
			}
		}
		return position;
    }

    public String addManagementPlan(String typePlan, double porcentage, Date theDate) {
		String out = "";		
		int emptyPos = getEmptyPositionManagementPlan(); //busco la primera posición vacía
		// si el arreglo está lleno?
		out = "Entra al metodo";
		if(emptyPos == -1){ // está lleno
			//no se puede agregar
			out = "El arreglo está lleno";
		}else{ //Si no está lleno

			managementPlan[emptyPos] = new ManagementPlan(typePlan, porcentage, theDate); 
			out = "El registro fue exitoso";
		}
		return out;
	}

    public int getWetlandSpeciesExisting() {
        int cont = 0;
        for (int i = 0; i < MAX_SPECIES; i++) {
            if (wetlandSpecies[i] != null) {
                cont += 1;
            }
        }
        return cont;
    }

    /* public String printAllSpecie() {
        String out = "";
        for (int i = 0; i < wetlandSpecies.length; i++) {
            if (wetlandSpecies[i] != null) {
                out += wetlandSpecies[i].toString();
            }
        }
        return out;
    } */
    
    // toString()
    /** 
     * @return String this method returns all the information about the wetland
     */
    public String toString()
    {
        return  "\n*** Wetland (" + wetlandName + ") ***" +
                "\nWetland Zone: " + wetlandZone +
                "\nWetland Type; " + wetlandType +
                "\nWetland km2: " + wetlandKm2 + "km2" +
                "\nWetland Photo Url: " + wetlandPhotoUrl +
                "\nWetland Protected: " + wetlandProtected;
                //"\nWetland Species: " + this.getWetlandSpecies().length;
                //"\nWetland Events: " + this.getWetlandEvents().length;
    }
}