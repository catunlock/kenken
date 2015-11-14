/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author GERARD
 */
public class GameDBControllerDriver {
    public static void main(String[] args) throws IOException
    {
        GameDBController test = new GameDBController();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Provant GameDBController");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Guardar un game a la DB --> 0: guardat correctament, -1: ja existent");
        System.out.println("2. Carregar un game de la DB --> 0: correcte, -1: el game no existeix");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        Integer option;
        String boardName;
        int result;
        String userName;
        
        while((option = sc.nextInt()) != -1) {
            switch(option){
                case 1:
                    System.out.println("Introdueix nom de jugador:");
                    userName = sc.next();
                    System.out.println("Introdueix nom de tauler:");
                    boardName = sc.next();
                    result = test.saveGame(null, boardName, userName);
                    if (result == 0){
                        System.out.println("Game creat correctament");
                    }
                    else if (result == -1){
                        System.out.println("Nom de game ja existent");
                    }
                    else{
                        System.out.println("Error intern");
                    }
                    break;
                case 2:
                    System.out.println("Introdueix nom de jugador:");
                    userName = sc.next();
                    System.out.println("Introdueix nom de board:");
                    boardName = sc.next();
                    Game g = test.loadGame(userName, boardName);
                    if (g == null) System.out.println("La partida no existeix.");
                    else System.out.println("Partida recuperada correctament.");
                    break;
            }
        }
    }   
}
