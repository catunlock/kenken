/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alberto.lopez.sanchez
 */
public class UserDBController {
   
    public int createUser(User newUser){
      FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(newUser.getName() + ".obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newUser);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
                return 0;
            } catch (IOException ex) {
                Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 1;
    }
    
    public int modifyUser(User user, String oldName){
        return 1;
    }
    
    public int deleteUser(String username){
        return 1;
    }
    
    public User getUser(String username){
      FileInputStream fis = null;
        try {
            fis = new FileInputStream(username + ".obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user = (User) ois.readObject();
            return user;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
                
            } catch (IOException ex) {
                Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }
    
    
}
