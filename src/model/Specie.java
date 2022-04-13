package model;

/**
 * Specie Class
 * Contains Specie information
 * @author Diego F. Zuñiga
 */
public class Specie
{
    // Attributes
    /**
	 * The specie Name
	 */
    private String specieName;
    /**
	 * The specie Scientific Name
	 */
    private String specieScientificName;
    /**
	 * The specie Migratory
	 */
    private String specieMigratory;
    /**
	 * The specie Type
	 */
    private String specieType;

    // Constructors
    /**
     * This constructor assigns the values entered by the user.
     * @param specieName this parameter defines the name of the specie
     * @param specieScientificName this parameter defines the scientific name of the specie
     * @param specieMigratory this parameter defines the specie is migratory or no
     * @param specieType this parameter defines the type of the specie
     */
    public Specie(
        String specieName, String specieScientificName, 
        String specieMigratory, String specieType
        )
    {
        this.specieName = specieName;
        this.specieScientificName = specieScientificName;
        this.specieMigratory = specieMigratory;
        this.specieType = specieType;
    }

    // Accessors and Mutators

    /**
     * @return String return the specieName
     */
    public String getSpecieName() {
        return specieName;
    }

    /**
     * @param specieName the specieName to set
     */
    public void setSpecieName(String specieName) {
        this.specieName = specieName;
    }

    /**
     * @return String return the specieScientificName
     */
    public String getSpecieScientificName() {
        return specieScientificName;
    }

    /**
     * @param specieScientificName the specieScientificName to set
     */
    public void setSpecieScientificName(String specieScientificName) {
        this.specieScientificName = specieScientificName;
    }

    /**
     * @return boolean return the specieMigratory
     */
    public String isSpecieMigratory() {
        return specieMigratory;
    }

    /**
     * @param specieMigratory the specieMigratory to set
     */
    public void setSpecieMigratory(String specieMigratory) {
        this.specieMigratory = specieMigratory;
    }

    /**
     * @return String return the specieType
     */
    public String getSpecieType() {
        return specieType;
    }

    /**
     * @param specieType the specieType to set
     */
    public void setSpecieType(String specieType) {
        this.specieType = specieType;
    }

    // toString()
    /** 
     * @return String this method returns all the information about the specie
     */
    public String toString()
    {
        return  "\n*** Specie ***" +
                "\nSpecie Name: " + specieName +
                "\nSpecie Scientific Name: " + specieScientificName +
                "\nSpecie Migratory: " + specieMigratory +
                "\nSpecie Type: " + specieType;
    }
}