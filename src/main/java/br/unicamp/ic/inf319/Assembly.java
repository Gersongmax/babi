package br.unicamp.ic.inf319;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <img src="./doc-files/Assembly.png" alt="Assembly">
 *
 * @author INF319
 */
public class Assembly extends Part {

    private final Set<Part> parts;

    /**
     *
     * @param thePartNumber
     * @param theDescription
     */
    public Assembly(PartNumber thePartNumber, String theDescription) {
        super(thePartNumber, theDescription);
        parts = new HashSet<>();
    }

    /**
     *
     * @return
     */
    @Override
    public double cost() {
        double totalCost = 0.0;
        // 1 - for opção
                for (Iterator<Part> i = parts.iterator(); i.hasNext();) {
                    Part part = (Part) i.next();
                    totalCost += part.cost();
                }
        //2 - for-loop
        //       for (Part part : parts) {
        //           totalCost += part.cost();
        //       }
        // 3 - Can use functional operations (lambda expression)
        // totalCost = parts.stream().map(part -> part.cost()).reduce(totalCost, (accumulator, _item) -> accumulator + _item);
        return totalCost;
    }

    /**
     *
     * @param thePart
     */

public void addPart(Part thePart) {
    parts.add(thePart);
}

/**
 *
 * @return
 */
public Set<Part> getParts() {
    return parts;
}

 public String print(Integer level) {
    	StringBuilder printedLines = new StringBuilder();
    	
    	printedLines.append (super.print(level));
    	
    	List<Part> sorted = getParts().stream()
    			.sorted((p1,p2) -> Integer.compare(p1.getPartNumber().getNumber(), p2.getPartNumber().getNumber() ))
    			.collect(Collectors.toList());
    	
    	for (Part part :sorted) {
    		
    		printedLines.append(part.print(level+1));
    		
    		//System.out.println(part.toString());
    	}
    	return printedLines.toString();
 }
}
    	
    
 

