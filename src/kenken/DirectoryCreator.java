/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.File;

/**
 *
 * @author GERARD
 */
public class DirectoryCreator {
    
    public DirectoryCreator(){}
    
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
        }
        File dirranking = new File("Rankings/");
        if (dirboards.exists()){
            
        }
        else {
            dirranking.mkdir();
        }
    }
}
