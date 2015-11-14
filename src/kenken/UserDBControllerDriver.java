/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

/**
 *
 * @author joan.pol.alejandre
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
        System.out.println("2. Modificar usuari --> 0: correcte, -1: usuari existent, -2: error intern");
        System.out.println("3. Canviar nom d'usuari");
        System.out.println("4. Canviar contrasenya");
        System.out.println("5. Incrementar SolvedGames");
        System.out.println("6. Incrementar StartedGames");
        System.out.println("7. Incrementar TotalCreatedBoards");
        System.out.println("8. Incrementar TotalTimePlayed");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        Integer option;
        String user;
        String pass;
        
        while((option = sc.nextInt()) != -1) {
            String enter = sc.nextLine();
            switch(option){
                case 1: 
                    System.out.println("Nom d'usuari:");
                    user = sc.nextLine();
                    System.out.println("Contrasenya d'usuari:");
                    pass = sc.nextLine();
                    User usuari = new User(user,pass);
                    Integer resultat = test.createUser(usuari);
                    System.out.println(resultat);
                    break;
                case 2:
                    System.out.println("Nom usuari a modificar:");
                    user = sc.nextLine();
                    System.out.println("Nova contrasenya:");
                    pass = "";
                    User usuari2 = new User(user,pass);
                    test.modifyUser(usuari2,user);
                    break;                    
                case 3:
                    break;
            }
        }
    }
        
    
}
