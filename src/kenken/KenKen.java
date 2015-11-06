/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SuNLoCK
 * 
 */
public class KenKen {

    /**
     * @param args the command line arguments
     */
    UserDBController db = new UserDBController();
    
    
    public KenKen() {
        UserKenKen marc = new UserKenKen("Marc", "12345");
        
        marc.setKekeniadas(133);
        marc.setTablerosCreados(43);
        db.createUser(marc);
        if (db.createUser(marc) == -1) {
            System.err.println("Error al crear usuario: Usuario ya existente.");
        }
        
        marc.setTablerosCreados(60);
        if (db.modifyUser(marc, null) == 0) {
            System.out.println("Usuario modificado correctamente.");
        }
        
        if (db.modifyUser(marc, "asdfwsdf") != 0) {
            System.err.println("Error al modificar usuario : El anterior no existe.");
        }
        
        if (db.modifyUser(marc, "Marc") != 0) {
            System.err.println("Error al modificar usuario : El anterior no existe.");
        }
        
        marc.setUsername("rodolfo");
        if (db.modifyUser(marc, "Marc") != 0) {
            System.err.println("Error al modificar usuario: rodolfo ya existe.");
        }
                
        
        UserKenKen marc2;
        try {
            marc2 = (UserKenKen) db.getUser("alsdkfj");
            
            System.out.printf("%s, Kenkeniadas: %d, TablerosCreados: %d", 
                marc2.getUsername(), marc2.getKekeniadas(), marc2.getTablerosCreados());
            
        } catch (IOException ex) {
            System.err.println("El usuario no existe o no se puede acceder a disco.");
        }
        
        db.deleteUser("Marc");
        db.deleteUser("rodolfo");
        
        if(db.deleteUser("manuala") != 0) {
            System.err.println("Error al borrar el usuario.");
        }
               
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Starting Bitches KenKen...");
        KenKen k = new KenKen();        
    }
    
}