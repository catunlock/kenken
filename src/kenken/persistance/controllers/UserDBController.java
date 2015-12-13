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
 * @author Alberto López Sánchez
 *
 */
public class UserDBController {

    private static final String Directory = "Users/";

    /**
     * Creates a user in the database.
     * @param  newUser The new User to store in the database.
     * @return         An Integer with the error code 0 : User succesfully created.  -1 : Already exists a User newUser. -2 : Internal error.
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

   /**
    * Modify de oldName User with a User user in the database.
    * @param   user The user modified to be stored into the database.
    * @param   oldName The old userName to be modified.
    * @return  An Integer with the error code 0 : User succesfully modified.  -1 : The user oldName doesn't exist. -2 : Internal error.
    */
    public int modifyUser(User user, String oldName){
        int result = -2;
        try{
            if (oldName != null && ! exists(user)) {
                Path oldpath = FileSystems.getDefault().getPath(Directory+oldName);
                Path newPath = FileSystems.getDefault().getPath(Directory+user.getUsername());

                Files.move(oldpath, newPath);

                Path oldUserFile = FileSystems.getDefault().getPath(newPath + "/user.obj");
                Files.delete(oldUserFile);

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

   /**
    * Deletes the username User from the database.
    * @param  username The desired user to delete.
    * @return          An Integer with the error code 0 : User succesfully deleted. -1 : The User username doesn't exist. -2 : Tried to delete an unlogged User. -3 : Internal error.
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

   /**
    * Gets a User from the database.
    * @param  username The User username to be extracted from the database.
    * @return          The User username extracted from the database, if user == NULL, means no User could be extracted.
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

    /**
     * A getter of the filepath.
     * @param  user The User to get the path.
     * @return      A String with the filepath of the user.
     */
    private String getPath(User user) {
        return getPath(user.getUsername());
    }

    /**
     * A getter of the filepath.
     * @param  username the username from the User to get the filepath.
     * @return          A String with the filepath of the username.
     */
    private String getPath(String username) {
        return Directory+username;
    }

    /**
     * A checker of the existance of the user.
     * @param  user The user desired to check in the databse.
     * @return      A boolean true if exists, otherwise returns false.
     */
    private boolean exists(User user) {
        return exists(user.getUsername());
    }

    /**
     * A checker of the existance of the user.
     * @param  username The username desired to check in the database.
     * @return          A boolean true if exists, otherwise returns false.
     */
    private boolean exists(String username) {
        return (new File(getPath(username)).isDirectory());
    }


    /**
     * Writes the user at the filepath in the database.
     * @param user  The user to be written into the database.
     * @param   filepath The filepath with the location of the user.
     * @return  An Integer with the error code 0 : User succesfully written. -2 : Internal error.
     */
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

    /**
     * Deletes a folder when we delete a User to not leave residual files.
     * @param folder The folder to erase from the database.
     */
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
