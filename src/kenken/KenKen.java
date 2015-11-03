/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author SuNLoCK
 */
public class KenKen {

    /**
     * @param args the command line arguments
     */
    UserDBController db = new UserDBController();
    UserKenKen marc = new UserKenKen("Marc", "12345");
    
    public KenKen() {
        marc.setKekeniadas(133);
        marc.setTablerosCreados(43);
        db.createUser(marc);
        
        UserKenKen marc2 = (UserKenKen) db.getUser("Marc");
        
        System.out.printf("Kenkeniadas: %d, TablerosCreados: %d", 
                marc2.getKekeniadas(), marc2.getTablerosCreados());       
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Starting Bitches KenKen...");
        KenKen k = new KenKen();        
    }
    
}