package br.unicamp.ic.inf319;

import junit.framework.TestCase;

public class ListaMateriaisTest extends TestCase {

    public void testPart() {
        PartNumber number = new PartNumber(42);
        Part part = new PiecePart(number, "description", 23);
        assertEquals(42, part.getPartNumber().getNumber());
        assertEquals("description", part.getDescription());
        part.setDescription("new description");
        assertEquals("new description", part.getDescription());
    }
    
    public void testPiecePart() {
        PartNumber number = new PartNumber(42);
        PiecePart part = new PiecePart(number, "description", 23);
        assertEquals(23, part.cost(), 0);
        part.setCost(5);
        assertEquals(5, part.cost(), 0);
    }
    
    public void testAssembly() {
        PartNumber number1 = new PartNumber(23);
        PartNumber number2 = new PartNumber(42);
        PartNumber number3 = new PartNumber(69);

        Assembly assembly1 = new Assembly(number1, "assembly1");
        Assembly assembly2 = new Assembly(number2, "assembly2");
        Assembly assembly3 = new Assembly(number3, "assembly3");

        for (int i = 0; i < 10; i++) {
            assembly1.addPart(new PiecePart(new PartNumber(i), "pp" + i, i));
        }
        assertEquals(((9 + 0) * 10)/2, assembly1.cost(), 0);

        for (int i = 10; i < 20; i++) {
            assembly2.addPart(new PiecePart(new PartNumber(i), "pp" + i, i));
        }
        assertEquals(((19 + 10) * 10)/2, assembly2.cost(), 0);
        
        assembly3.addPart(assembly1);
        assembly3.addPart(assembly2);
        assertEquals(assembly1.cost() + assembly2.cost(), assembly3.cost(), 0);

        double cost = assembly3.cost();
        assembly2.addPart(new PiecePart(new PartNumber(75), "piece", 10));
        assertEquals(cost + 10, assembly3.cost(), 0);
    }
    
    public void testList() {
    	
    	// Átomos para a roda dianteira
    	PiecePart aroDianteiro = new PiecePart(new PartNumber(51), "Aro Dianteiro", 20.0);
    	PiecePart cuboDianteiro = new PiecePart(new PartNumber(52), "Cubo Dianteiro", 30.0);
    	PiecePart raiosDianteiro = new PiecePart(new PartNumber(53), "Raios Dianteiro", 5.0);
    	PiecePart pneuDianteiro = new PiecePart(new PartNumber(54), "Pneu Dianteiro", 15.0);
    	
    	// Roda dianteira
    	Assembly rodaDianteira = new Assembly(new PartNumber(5), "Roda Dianteira");
    	rodaDianteira.addPart(aroDianteiro);
    	rodaDianteira.addPart(cuboDianteiro);
    	rodaDianteira.addPart(raiosDianteiro);
    	rodaDianteira.addPart(pneuDianteiro);
    	
    	// Átomos para a roda traseira
       	PiecePart aroTraseiro = new PiecePart(new PartNumber(61), "Aro Traseiro", 20.0);
    	PiecePart cuboTraseiro = new PiecePart(new PartNumber(62), "Cubo Traseiro", 30.0);
    	PiecePart raiosTraseiro = new PiecePart(new PartNumber(63), "Raios Traseiro", 5.0);
    	PiecePart pneuTraseiro = new PiecePart(new PartNumber(64), "Pneu Traseiro", 15.0);
    	
    	//Roda Traseira
    	Assembly rodaTraseira = new Assembly(new PartNumber(6), "Roda Traseira");
    	rodaTraseira.addPart(aroTraseiro);
    	rodaTraseira.addPart(cuboTraseiro);
    	rodaTraseira.addPart(raiosTraseiro);
    	rodaTraseira.addPart(pneuTraseiro);
    	
    	Assembly motocicleta = new Assembly(new PartNumber(7), "Motocicleta");
    	motocicleta.addPart(rodaDianteira);
    	motocicleta.addPart(rodaTraseira);
    
    	assertEquals(140.0, motocicleta.cost());
    	
    	
    }
    
    public void testListAssembly() {
       // Assembly floppy = null;
      
        // partes da Tampa corredica
        PiecePart folhaAluminio = new PiecePart(new PartNumber (3), "Folha de aluminio",3.0);
        PiecePart mola = new PiecePart(new PartNumber (4), "Mola",1.0);
        
       // partes do disco
        PiecePart Anel = new PiecePart(new PartNumber(5), "Anel de tracao", 2.0);
    	PiecePart DiscoMagnetico = new PiecePart(new PartNumber(6), "Disco magnetico", 15.0);
        
    	// parte Caixa
    	
    	PiecePart CaixaPlastica = new PiecePart(new PartNumber(12), "Caixa plastica", 5.0);
    	
    	// Caixa
    	
    	//Assembly Caixa = new Assembly(new PartNumber(12), "Caixa Plastica");
    	//Caixa.addPart(CaixaPlastica);
    	
    	//Tampa corredica montada
    	Assembly TampaCorredica = new Assembly(new PartNumber(13), "Tampa corredica");
    	TampaCorredica.addPart(folhaAluminio);
    	TampaCorredica.addPart(mola);
    	
    	// Disco montado
    	Assembly Disco = new Assembly(new PartNumber(11), "Disco");
    	Disco.addPart(Anel);
    	Disco.addPart(DiscoMagnetico);
    	
    	 // Disquete montado   	
        Assembly Disquete = new Assembly(new PartNumber(1), "Disquete");
        Disquete.addPart(TampaCorredica);
        Disquete.addPart(Disco);
        Disquete.addPart(CaixaPlastica);
       
        
        assertEquals(26.0, Disquete.cost());
        assertEquals(4.0 , TampaCorredica.cost());
        assertEquals(17.0 , Disco.cost());
        assertEquals(5.0 , CaixaPlastica.cost());
    
    
        StringBuilder expected = new StringBuilder();
      
        expected.append(String.format ("Parte: 1; Descricao: Disquete; Custo: 26.0\n"  ));
        expected.append(String.format (" Parte: 11; Descricao: Disco; Custo: 17.0\n" ));
        expected.append(String.format ("  Parte: 5; Descricao: Anel de tracao; Custo: 2.0\n" ));
        expected.append(String.format ("  Parte: 6; Descricao: Disco magnetico; Custo: 15.0\n"));
        expected.append(String.format (" Parte: 12; Descricao: Caixa plastica; Custo: 5.0\n" ));
        expected.append(String.format (" Parte: 13; Descricao: Tampa corredica; Custo: 4.0\n"));
        expected.append(String.format ("  Parte: 3; Descricao: Folha de aluminio; Custo: 3.0\n"));
        expected.append(String.format ("  Parte: 4; Descricao: Mola; Custo: 1.0\n"));
        
       
        
        String result = Disquete.print(0);
        assertEquals(expected.toString(), result);
    }
}
