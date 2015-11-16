/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.drivers;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import kenken.domain.classes.Board;
import kenken.domain.classes.Game;
import kenken.domain.classes.User;

/**
 *
 * @author asus
 */
public class GameDriver {
    public static void main(String[] args) throws IOException
    {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("Provant Game");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix mode de joc: (opcions -> Normal o TimeAttack)");
        String mode;
        
        while(!"Normal".equals(mode = sc.next()) && !"TimeAttack".equals(mode)){
            System.out.println("Mode incorrecte.");
        }
        Game testGame = new Game(mode);
        
        System.out.println("Introdueix nom del usuari del joc");
        String user = sc.next();
        System.out.println("Introdueix contrasenya:");
        String pass = sc.next();
        User newuser = new User(user,pass);
        testGame.setUser(newuser);
        
        System.out.println("Introdueix size del Board:");
        int size = sc.nextInt();
        Board newboard = new Board(size);
        testGame.setBoard(newboard);

        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Afegir temps");
        System.out.println("2. Mostrar tota informació del joc i de la taula del joc");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        Integer option;
           
        while((option = sc.nextInt()) != -1) {
            switch(option){
                case 1: 
                    System.out.println("Introdueix la quantitat en segons:");
                    long segons = sc.nextLong();
                    Duration temps = Duration.ofSeconds(segons);
                    testGame.addTime(temps);
                    break;
                case 2:
                    System.out.println("Usuari: " + testGame.getUser());
                    System.out.println("Mode: " + testGame.getMode());
                    System.out.println("Temps: " + testGame.getTime()); 
                    System.out.println("Board size: " + testGame.getBoard().size());
                    break;                    
            }
        }
    }
    
}
