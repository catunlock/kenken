/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.persistance.drivers;

import kenken.persistance.controllers.UserDBController;
import kenken.domain.classes.User;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

/**
 *
 * @author joan.pol.alejandre + Gerard
 */
public class UserDBControllerDriver {
    public static void main(String[] args) throws IOException
    {
        UserDBController test = new UserDBController();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Provant UserDBController");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Crear nou usuari --> 0: creat correctament, -1: usuari existent, -2: error intern");
        System.out.println("2. Modificar usuari --> 0: correcte, -1: usuari inexistent, -2: error intern");
        System.out.println("3. Elimina usuari --> 0: correcte, -1: usuari inexistent, -3: error intern");
        System.out.println("4. Treballa amb l'usuari que es demani");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        User usernow;
        Integer option;
        String user;
        String newuser;
        String pass;
        
        while((option = sc.nextInt()) != -1) {
            switch(option){
                case 1: 
                    System.out.println("Nom d'usuari:");
                    user = sc.next();
                    System.out.println("Contrasenya d'usuari:");
                    pass = sc.next();
                    User usuari = new User(user,pass);
                    Integer resultat = test.createUser(usuari);
                    System.out.println(resultat);
                    break;
                case 2:
                    System.out.println("Nom usuari a modificar:");
                    user = sc.next();
                    User usuari2 = test.getUser(user);
                    if (usuari2 == null) System.out.println("No existeix aquest usuari");
                    else{
                        System.out.println("Nou nom de l'usuari a modificar:");
                        usuari2.setUsername(sc.next());
                        System.out.println("Nova contrasenya:");
                        usuari2.setPassword(sc.next());
                        int result = test.modifyUser(usuari2,user);
                        if (result == 0){
                            System.out.println("Usuari actualitzat correctament");
                        }
                        else if (result == -1) {
                            System.out.println("No existeix l'usuari");
                        }
                        else if (result == -2) {
                            System.out.println("Errors interns");
                        }
                        else if (result == -3){
                            System.out.println("Ja hi ha un usuari amb aquest nom");
                        }
                    }
                    break;                    
                case 3:
                    System.out.println("Nom usuari a eliminar:");
                    user = sc.next();
                    if (test.deleteUser(user) == -1) {
                        System.out.println("No existeix aquest usuari.");
                    }
                    else {
                        System.out.println("Usuari eliminat amb èxit.");
                    }
                    break;
                case 4:
                    System.out.println("Nom d'usuari amb el que es vol treballar:");
                    usernow = test.getUser(sc.next());
                    if (usernow == null) {
                        System.out.println("No existeix aquest usuari");
                    }
                    else {
                        System.out.println(usernow.getUsername());
                        System.out.println(usernow.getPassword());
                    }
            }
        }
    }
        
    
}
