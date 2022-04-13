package model;

public class Municipe {
    
    public static final int MAX_WETLANDS = 80;
    private int indexWetlands;

    // Attributes
    private String nameMunicipe;
    private Wetland[] wetlands;

    // Constructor
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

    public String addWetland(
        String name, String locationZone, String type, 
        double size, String urlPicture, boolean protection,
        String nameOfTheZone
    ) {

		String out="";
	
		int pos = hasSpace2(); //Busco la primera posicion vacia

		if(pos == -1){//Si el arreglo esta lleno

			out="El arreglo esta lleno";

		}else{ //Si el arreglo no esta lleno

		    wetlands[pos] = new Wetland (name, locationZone, type, size, urlPicture, protection, nameOfTheZone);
			out="The wetland was added";

		}
		return out;
	}

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
