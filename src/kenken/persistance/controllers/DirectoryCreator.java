/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.persistance.controllers;

import java.io.File;

/**
 *
 * @author GERARD
 */
public class DirectoryCreator {
    /**
     * The Default construcotr of DirectoryCreator
     */
    public DirectoryCreator(){}
    /**
     * Creates a new Directory for each new user created.
     * @param username The name of the user to create the directory
     * @return An Integer with the error code  0 : Directory succesfully created. -1 : The directory already exists.
     */
    public int createUser(String username){
        File newuser = new File("Users/"+username+"/");
        File usergames = new File("Users/"+username+"/Games/");
        if (newuser.exists()){
            return -1;
        }
        else {
            newuser.mkdir();
            usergames.mkdir();
            return 0;
        }
    }
    /**
     * Creates the Initial Directories to save the files into the database.
     */
    public void createInitial(){
        File dirusers = new File("Users/");
        if (dirusers.exists()){
            
        }
        else {
            dirusers.mkdir();
        }
        File dirboards = new File("Boards/");
        if (dirboards.exists()){
            
        }
        else {
            dirboards.mkdir();
            File dirinfo = new File("Boards/info");
            File dirobj = new File("Boards/brd");
            dirinfo.mkdir();
            dirobj.mkdir();
        }
        File dirranking = new File("Rankings/");
        if (dirranking.exists()){
            
        }
        else {
            dirranking.mkdir();
        }
    }
}
