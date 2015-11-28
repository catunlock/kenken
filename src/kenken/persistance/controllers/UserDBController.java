/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.persistance.controllers;

import kenken.domain.classes.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alberto.lopez.sanchez
 * 
 * Detalles que no tienen sentido de la especificacion:
 * 
 */
public class UserDBController {
   
    private static final String Directory = "Users/";
    private static final String Extension = ".obj";
    
    /* Pre:  cert
    ** Post: Retorna un int el qual, segons el valor que tingui, indicara que
             s’ha creat a la base de dades un nou usuari amb valors newUser, 
             o be que hi ha hagut alguna excepcio.
        Return:
             0 = usuari creat correctament
            -1 = usuari existent
            -2 = error intern
    */
    public int createUser(User newUser){
        int result = 1;
        String filepath = getPath(newUser);
        DirectoryCreator dc = new DirectoryCreator();
        if (new File(filepath).isDirectory()){
            result = -1;
        }
        else {
            dc.createUser(newUser.getUsername());
            result = writeUser(newUser, filepath+"/user.obj");
        }
       
        return result;
    }
    
    /*  Pre: user != NULL
    ** Post: Retorna un int el qual, segons el valor que tingui, indicara si 
       s’ha modificat a la base de dades l’usuari que, abans de la modificacio, 
       tenia com a nom oldname, i se li ha donat uns nous valors user amb exit, 
       o be indicara si hi ha hagut alguna excepcio.
    Return:
        0 = usuari modificat correctament
        -1 = usuari inexistent
        -2 = error intern
    */
    public int modifyUser(User user, String oldName){
        int result = -2;
        try{
            if (oldName != null && ! exists(user)) {
                Path oldpath = FileSystems.getDefault().getPath(Directory+oldName);
                Path newPath = FileSystems.getDefault().getPath(Directory+user.getUsername());
                Files.move(oldpath, newPath);
                Path path = FileSystems.getDefault().getPath(Directory+user.getUsername()+"/user.obj");
                Files.delete(path);
                result = writeUser(user, getPath(user)+"/user.obj");
            }
            else if (oldName == null){
                if (exists(user)) {
                    Path path = FileSystems.getDefault().getPath(Directory+user.getUsername()+"/user.obj");
                    Files.delete(path);
                    result = writeUser(user, getPath(user)+"/user.obj");
                }
                else {
                    result = -1;
                }
            }
            else if (exists(user)){
                result = -3;
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        }    
            
        return result;
    }
    
    /*  Pre: username != NULL
    ** Post: Retorna un int el qual, segons el valor que tingui, indicara si 
             s’ha eliminal de la base de dades l’usuari amb nom username, o be 
             si s’ha produit alguna excepcio.
    Return:
         0 = usuari eliminat correctament
        -1 = usuari no existent
        -2= s’esta intentant eliminar un usuari que no es el loguejat
        -3 = error intern
    */
    public int deleteUser(String username){
        int result = -3;
        
        if(!exists(username)){
            result = -1;
        }else {
            File dir = new File(Directory+username);
            deleteFolder(dir);
            result = 0;
        }
        
        return result;
    }
    
    /*
    Pre: username != NULL
    Post: Retorna un User amb els atributs de l'usuari a la base de dades amb 
    nom username, si no existeix el usuari, retorna null
    */
    public User getUser(String username){
        
        FileInputStream fis;
        User user = null;
        
        if (exists(username)){
            try {
                fis = new FileInputStream(getPath(username)+"/user.obj");
                ObjectInputStream ois = new ObjectInputStream(fis);
                user = (User) ois.readObject();
                fis.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }
    
    private String getPath(User user) {
        return getPath(user.getUsername());
    }
    
    private String getPath(String username) {
        return Directory+username;
    }
    
    private boolean exists(User user) {
        return exists(user.getUsername());
    }
    
    private boolean exists(String username) {
        return (new File(getPath(username)).isDirectory());
    }
    
    
    private int writeUser(User user, String filepath) {
        int result = -2;
        
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            fos.close();
            result = 0;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        } catch (IOException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        }        
        
        return result;
    }
    
        public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if(files!=null) { //some JVMs return null for empty dirs
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
