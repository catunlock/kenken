/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GERARD
 */
public class GameControllerDriver {
    public static void main(String[] args)
    {
        GameController test = new GameController();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Provant GameController");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Genera una Board");
        System.out.println("2. Guarda una partida --> 0: correcte, -1: ja existeix una partida amb aquest nom");
        System.out.println("3. Mostrar llista de partides guardades");
        System.out.println("4. Carrega una partida");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        Integer option;
        String gameName;
        int result;
        String userName;
        int size;
        
        while((option = sc.nextInt()) != -1) {
            switch(option){
                case 1:
                    System.out.println("Introdueix mesura de la taula a generar:");
                    Generator gen = new Generator();
                    size = sc.nextInt();
                    Board b = gen.generate(size);
                    break;
                case 2:
                    System.out.println("Introdueix nom de jugador:");
                    userName = sc.next();
                    System.out.println("Introdueix nom de partida:");
                    gameName = sc.next();
                    Game g = new Game("Normal");
                    result = test.saveGame(g, userName, gameName);
                    if (result == -1) System.out.println("Ja hi ha una partida amb aquest nom.");
                    else System.out.println("Partida guardada correctament.");
                    break;
                case 3:
                    System.out.println("Introdueix nom de jugador:");
                    userName = sc.next();
                    ArrayList<String> llista = null;
                    llista = test.getSavedGames(userName);
                    if (llista == null) System.out.println("Aquest usuari no te cap partida guardada.");
                    else System.out.println(llista);
                    break;
                case 4:
                    Game load = new Game("Normal");
                    System.out.println("Introdueix nom de jugador:");
                    userName = sc.next();
                    System.out.println("Introdueix nom de partida:");
                    gameName = sc.next();
                    load = test.loadGame(userName, gameName);
                    if (load == null) System.out.println("No existeix aquesta partida.");
                    else System.out.println("Partida "+gameName+" recuperada amb èxit.");
            }
        }
    }   
}
