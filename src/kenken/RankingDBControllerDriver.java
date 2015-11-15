/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marc
 */
public class RankingDBControllerDriver {
    public static void main(String[] args) throws IOException{
        RankingController test = new RankingController();
        Scanner scan = new Scanner(System.in);
        Ranking testRanking = new Ranking("Tauler", Ranking.GameMode.Normal);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Provant RankingDBController");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Crear nou ranking --> 0: creat correctament, -1: usuari existent, -2: error intern.");
        System.out.println("2. Modificar ranking --> 0: correcte, -1: usuari existent, -2: error intern.");
        System.out.println("3. Obtenir Ranking dels arxius.");
        System.out.println("4. Esborrar ranking dels arxius.");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        Integer option;
        String ranking;
        String gameMode;
        
        while((option = scan.nextInt()) != -1) {
            switch(option){
                case 1: 
                    System.out.println("Introdueix el nom del Tauler associat al Ranking que vols crear: ");
                    ranking = scan.next();
                    System.out.println("Introdueix el Mode de joc del qual sera el ranking: ");
                    gameMode = scan.next();
                    System.out.println(test.createRanking(ranking, Ranking.GameMode.valueOf(gameMode)));
                    break;
                case 2:
                    System.out.println("Introdueix el nom i el temps del record que vols afegir al ranking");
                    String nom = scan.next();
                    long temps = scan.nextLong();
                    Record newRecord = new Record(nom, temps);
                    System.out.println(test.modifyRanking(testRanking, newRecord));
                    break;                    
                case 3:
                    System.out.println("Introdueix el nom del tauler asociat: ");
                    String nom1 = scan.next();
                    Ranking rankingGet = test.getRanking(nom1);
                    if (rankingGet == null) {
                        System.out.println("Aquest board no existeix.");
                    }
                    break;
                case 4:
                    System.out.println("Introdueix el nom del tauler asociat: ");
                    String nom2 = scan.next();
                    System.out.println(test.deleteRanking(nom2));
                    break;            
                
            }
        }
    }
}
