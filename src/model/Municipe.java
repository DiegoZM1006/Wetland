package model;

public class Municipe {
    
    public static final int MAX_WETLANDS = 80;
    private int indexWetlands;
    private String nameMunicipe;
    private Wetland[] wetlands;

    /**
     * This is the constructor of the class Municipe
     * @param nameMunicipe, must be declared and initialized, String is the name of the municipality
     */
    public Municipe(String nameMunicipe) {
        this.nameMunicipe = nameMunicipe;
        wetlands = new Wetland[MAX_WETLANDS];
    }

    // Setters and Getters

    /**
     * @return String return the nameMunicipe
     */
    public String getNameMunicipe() {
        return nameMunicipe;
    }

    /**
     * @param nameMunicipe the nameMunicipe to set
     */
    public void setNameMunicipe(String nameMunicipe) {
        this.nameMunicipe = nameMunicipe;
    }

    /**
     * @return Wetland[] return the wetlands
     */
    public Wetland[] getWetlands() {
        return wetlands;
    }

    /**
     * @param wetlands the wetlands to set
     */
    public void setWetlands(Wetland[] wetlands) {
        this.wetlands = wetlands;
    }

    /**
     * This method is to know if there is enough space in wetlands[].
     * @return boolean, true if there is space in the wetlands[], 
     * otherwise it will return false if no space is found
     */
    public boolean hasSpace(){
		indexWetlands = -1;
		boolean emptyPosition= false;
		for (int i=0; i<MAX_WETLANDS && !emptyPosition; i++){
			if(wetlands[i] == null){
				emptyPosition= true;
				indexWetlands=i; // Esa es la posicion vacia 
			}
		}
		return emptyPosition;
	}
    /**
     * This method is used to find the index of the empty position in wetlands[].
     * @return int, returns the number (index) where I find an empty position in wetlands[], 
     * otherwise, it will return -1 if no space is found
     */
    public int hasSpace2(){
		indexWetlands = -1;
		boolean emptyPosition= false;
		for (int i=0; i<MAX_WETLANDS && !emptyPosition; i++){
			if(wetlands[i] == null){
				emptyPosition= true;
				indexWetlands=i; // Esa es la posicion vacia 
			}
		}
		return indexWetlands;
	}
    /**
     * This method is used to add a wetland to wetlands[]
     * @param name, is the name of the wetland
     * @param locationZone, is the location of the wetland
     * @param type, is the type of wetland
     * @param size, is the size of the wetland
     * @param urlPicture, is the url picture of the wetland
     * @param protection, means if the wetland is protected or not
     * @param nameOfTheZone, is the name of the zone of the wetland
     * @return String, returns a message depending on whether the wetland was added or not
     */
    public String addWetland(
        String name, String locationZone, String type, 
        double size, String urlPicture, boolean protection,
        String nameOfTheZone
    ) {
		String out="";
		int pos = hasSpace2();
		if(pos == -1){
			out="El arreglo esta lleno";
		} else {
		    wetlands[pos] = new Wetland (name, locationZone, type, size, urlPicture, protection, nameOfTheZone);
			out="The wetland was added";
		}
		return out;
	}
    /**
     * This method is to know if the name of the wetland is already added in wetlands[]
     * @param nameToSearch, is the name of the wetland to search
     * @return boolean, returns true if the wetland is already added
     * otherwise, it will return false if the wetland is not already added
     */
    public boolean findWetland(String nameToSearch) {
		boolean found = false;
		for (int i=0; i < MAX_WETLANDS && !found; i++){
			if (wetlands[i] != null) {
                if(wetlands[i].getWetlandName().equals(nameToSearch)){
                    found= true;
                }
            }
		}
		return found;
    }
    /**
     * This method is used to add a species to a specific wetland 
     * @param wetlandName, it is the name of the wetland where the species will be added
     * @param name, is the name of the specie
     * @param scientificName, is the scientific name of the specie
     * @param migratoryType, means if the specie is migratory or not
     * @param type, is the type of the specie
     * @return String, returns a message depending on whether the specie was added or not
     */
    public String addSpecieToWetland(String wetlandName, String name, String scientificName, String migratoryType, String type) {
        String out = "";
        boolean control = true;

        for(int i=0; i < MAX_WETLANDS && control == true; i++){
            if(wetlands[i].getWetlandName().equals(wetlandName)){
                control = false; // Para que no se repita 
                wetlands[i].addSpecie(name, scientificName, migratoryType, type);
                out = "The specie "+name+" was successfully registered in the wetland "+wetlandName;
            }else{
                // control = false;
                out = "The register was not successful because the wetland "+ wetlandName+" doesn't exist";
            }
        }
        return out;
    }
    /**
     * This method is used to add a event to a specific wetland 
     * @param wetlandName, it is the name of the wetland where the species will be added
     * @param manager, it is the name of the manager who organizes the event
     * @param description, is the description of the event
     * @param cost, is the cost of the event
     * @param day, is the day of the event
     * @param month, is the month of the event
     * @param year, is the year of the event
     * @return String, returns a message depending on whether the event was added or not
     */
    public String addEventToEvent(
        String wetlandName, String manager, 
        String description, double cost,
        int day, int month, int year
    ) {
        String out = "";
        boolean control = true;

        for(int i=0; i < MAX_WETLANDS && control == true; i++){
            if(wetlands[i].getWetlandName().equals(wetlandName)){
                control = false; // Para que no se repita 
                Date theDate = new Date(day, month, year);
                wetlands[i].addEvent(manager, description, cost, theDate);
                out = "The Event of " + manager + " was successfully registered in the wetland "+ wetlandName;
            }else{
                // control = false;
                out = "The register was not successful because the wetland "+ wetlandName+" doesn't exist";
            }
        }
        return out;
    }
    /**
     * This method is used to add a management plan to a specific wetland 
     * @param wetlandName, it is the name of the wetland where the species will be added
     * @param typePlan, is the type of the management plan
     * @param porcentage, is the porcentage of the management plan
     * @param day, is the day of the event
     * @param month, is the month of the event
     * @param year, is the year of the event
     * @return String, returns a message depending on whether the management plan was added or not
     */
    public String addManagementPlanToWetland(
        String wetlandName, String typePlan, 
        double porcentage, int day, int month, int year
    ) {
        String out = "";
        boolean control = true;

        for(int i=0; i < MAX_WETLANDS && control == true; i++){
            if(wetlands[i].getWetlandName().equals(wetlandName)){
                control = false; // Para que no se repita 
                Date theDate = new Date(day, month, year);
                wetlands[i].addManagementPlan(typePlan, porcentage, theDate);
                out = "The Event of " + typePlan + " was successfully registered in the wetland "+ wetlandName;
            }else{
                // control = false;
                out = "The register was not successful because the wetland "+ wetlandName+" doesn't exist";
            }
        }
        return out;
    }
    /**
     * This method is used to know the management of environmental plans of wetlands
     * @return String, returns a message with all the environmental plans of the wetlands 
     */
    public String showMaintenanceInWetland() {
        String out = "";
        for (int i=0; i < MAX_WETLANDS ; i++) {
            if (wetlands[i] != null) {
                out += "\n\n" +
                "Wetland: " + wetlands[i].getWetlandName() +
                wetlands[i].getManagementPlan();
            }
        } 
        return out;
    }
    /**
     * This method is used to know ¿What is the wetland with less species?
     * @return String, return the name of the wetland with less species
     */
    public String wetlandWithFewerSpecies() {
        String out = "There is not :C";
        int minSpecies = 1;
        for (int i=0; i < MAX_WETLANDS; i++) {
            if (wetlands[i] != null) {
                if(wetlands[i].getWetlandSpeciesExisting() < minSpecies) {
                    out = wetlands[i].getWetlandName();
                } 
            }
        }
        return out;
    }
    /**
     * This method is used to know ¿What is the wetland with most species?
     * @return String, return the name of the wetland with most species
     */
    public String wetlandWithMostSpecies() {
        String out = "There is not :C";
        int minSpecies = 0;
        for (int i=0; i < MAX_WETLANDS; i++) {
            if (wetlands[i] != null) {
                if(wetlands[i].getWetlandSpeciesExisting() > minSpecies) {
                    out = wetlands[i].getWetlandName();
                } 
            }
        }
        return out;
    }
    /**
     * This method is to know the name of the wetlands that have a species introduced by the user
     * @param nts, name of the specie to search
     * @return String, returns a message with the name of the wetlands that have a specific specie
     */
    public String searchSpecieInWetlands(String nts) {
        String out = "";
        for (int i=0; i < MAX_WETLANDS; i++) {
            if (wetlands[i] != null) {
                if (wetlands[i].findSpecieInWetland(nts)) {
                    out += "\nWetland Name: " + wetlands[i].getWetlandName();
                }
            }
        }
        return out;
    }
    /**
     * This method is used to see the information of all the wetlands
     * @return String, return a message with all information about the wetlands registered
     */
    public String showAllWetlands() {
        String out = "";
        for (int i=0; i < MAX_WETLANDS; i++) {
            if (wetlands[i] != null) {
                out += "\n" + wetlands[i].toString();
            }
        }
        return out;
    }

}
