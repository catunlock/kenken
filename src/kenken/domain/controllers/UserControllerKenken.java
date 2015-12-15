/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

/**
 *
 * @author asus
 */
public class UserControllerKenken extends UserController{
    
    public String getUsername() {
        if (this.getLoggedUser() == null) return "";
        else return this.getLoggedUser().getUsername();
    }
}
