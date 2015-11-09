/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;
/**
 *
 * @author SuNLoCK
 * 
 */
public class KenKen {

    /**
     * @param args the command line arguments
     */
    
    
    
    public KenKen() {
        Generator gen = new Generator();
        Board b = gen.generate(4);
        System.out.println("Board: " + b);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Starting Bitches KenKen...");
        KenKen k = new KenKen();        
    }
    
}