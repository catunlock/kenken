/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.Scanner;

/**
 *
 * @author Gerard
 * 
 */
public class KenKen {

    /**
     * @param args the command line arguments
     */
    
    
    
    /*public KenKen() {
        Generator gen = new Generator();
        Board b = gen.generate(4);
        System.out.println("Board: " + b);
    }*/
    
    public static void main(String[] args) {
        // TODO code application logic here
        DirectoryCreator dc = new DirectoryCreator();
        dc.createInitial();
        UserController uc = new UserController();
        Scanner sc = new Scanner(System.in);
        int optionuser;
        int error = -1;
        String nom;
        String pass;
        while (error != 0){
            System.out.println("Vols registrar un usuari, fer login, o jugar com a convidat?");
            System.out.println("1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Jugar com a convidat");
            optionuser = sc.nextInt();
            switch(optionuser){
                case 1:
                    System.out.print("Nom de l'usuari:");
                    nom = sc.next();
                    System.out.print("Password de l'usuari:");
                    pass = sc.next();
                    if (dc.createUser(nom) == -1) {
                        System.out.println("Ja hi ha un usuari amb aquest nom");
                    }
                    else {
                        error = uc.createUser(nom,pass);
                    }
                    break;
                case 2:
                    System.out.print("Nom de l'usuari:");
                    nom = sc.next();
                    System.out.print("Password de l'usuari:");
                    pass = sc.next();
                    error = uc.login(nom, pass);
                    if (error == -1) System.out.println("Nom d'usuari incorrecte");
                    else if (error == -2) System.out.println("Password incorrecte");
                    break;
                case 3:
                    error = 0;
                    break;
            }
        }
        
        //System.out.println("Starting Bitches KenKen...");
        //KenKen k = new KenKen();        
    }
    
}