package br.unicamp.ic.inf319;
/**
 * <img src="./doc-files/Part.png" alt="Part">
 *
 * @author INF319
 */
public abstract class Part {

    private String description;
    private final PartNumber partNumber;
    
    /**
     *
     * @param thePartNumber
     * @param theDescription
     */
    public Part(PartNumber thePartNumber, String theDescription) {
        description = theDescription;
        partNumber = thePartNumber;
    }
    
    /**
     *
     * @return double
     */
    public abstract double cost();

    /**
     *
     * @return String
     */
    public String getDescription() {
    	return description;
    }
    
    /**
     *
     * @param desc
     */
    public void setDescription(String desc) {
    	description = desc;
    }

    /**
     *
     * @return PartNumber
     */
    public PartNumber getPartNumber() {
        return partNumber;
    }
}
