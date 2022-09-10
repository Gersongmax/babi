package br.unicamp.ic.inf319;
/**
 * <img src="./doc-files/PiecePart.png" alt="PiecePart">
 *
 * @author INF319
 */
public class PiecePart extends Part {

    private double cost;
    
    /**
     *
     * @param thePartNumber
     * @param theDescription
     * @param theCost
     */
    public PiecePart(PartNumber thePartNumber, String theDescription,
                     double theCost) {
        super(thePartNumber, theDescription);
        cost = theCost;
    }

    /**
     *
     * @return
     */
    @Override
    public double cost() {
        return cost;
    }
    
    /**
     *
     * @param c
     */
    public void setCost(double c) {
    	cost = c;
    }
}
