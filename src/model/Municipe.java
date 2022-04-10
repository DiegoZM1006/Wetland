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

    public String addWetland(
        String name, String locationZone, String type, 
        double size, String urlPicture, boolean protection,
        String nameOfTheZone, int numberOfSpecies
    ) {

		String out="";
	
		int pos = indexWetlands; //Busco la primera posicion vacia

		if(pos == -1){//Si el arreglo esta lleno

			out="El arreglo esta lleno";

		}else{ //Si el arreglo no esta lleno

		    wetlands[pos] = new Wetland (name, locationZone, type, size, urlPicture, protection, nameOfTheZone, numberOfSpecies);
			out="The wetland was added";

		}
		return out;
	}

    public boolean findWetland(String nameToSearch) {
		boolean emptyPosition = false;
		for (int i=0; i < MAX_WETLANDS && !emptyPosition; i++){
			if (wetlands[i] != null) {
                if(wetlands[i].getWetlandName().equals(nameToSearch)){
                    emptyPosition= true;
                }
            }
		}
		return emptyPosition;
    }

}
