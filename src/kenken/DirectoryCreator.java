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
    
    public void create(){
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
    }
}