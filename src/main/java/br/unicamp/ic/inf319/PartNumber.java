package br.unicamp.ic.inf319;
/**
 * <img src="./doc-files/PartNumber.png" alt="PartNumber">
 *
 * @author INF319
 */
public class PartNumber {

    private final int number;
    
    /**
     *
     * @param theNumber
     */
    public PartNumber(int theNumber) {
        number = theNumber;
    }

    /**
     *
     * @return
     */
    public int getNumber() {
        return number;
    }
    
   //adicionando partNumbertostring 
    
    public String partNumberToString() {
    	
    	
    	return Integer.toString(number);
    	
    	
  }
}
