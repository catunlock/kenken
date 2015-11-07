/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import static java.time.Clock.system;

/**
 *
 * @author joan pol
 */
public class UserDriver {
    
    public static void main(String[] args)
    {
        User test = new User("test","pass");
        System.out.println("Probando getUsername");
        System.out.println(test.getUsername());
    }
    
}
