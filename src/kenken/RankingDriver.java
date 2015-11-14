/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.Scanner;

/**
 *
 * @author Marc
 */
public class RankingDriver {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int opt;
        Ranking ranking = new Ranking("Tauler", Ranking.GameMode.Normal);
        System.out.println("Per defecte hem creat un ranking buit amb el nom de Tauler 'Tauler' i amb gameMode Normal");
        System.out.println("Escull una de les seguents opcions:");
        System.out.println("1. Crea un Ranking nou.");
        System.out.println("2. Obtenir el Record segons una posició existent donada[0..9]");
        System.out.println("3. Afegeix un Record al Ranking.");
        System.out.println("4. Obtenir el mode del joc del Ranking.");
        System.out.println("-1. Sortir.");
        while((opt = scan.nextInt()) != -1){
            switch(opt){
                case 1:
                    System.out.print("Introdueix el nom del Tauler associat al Ranking: ");
                    String nomTauler = scan.next();
                    System.out.print("Introdueix el mode de joc[Normal, TimeAttack]: ");
                    String modeJoc = scan.next();
                    ranking = new Ranking(nomTauler, Ranking.GameMode.valueOf(modeJoc));
                    break;
                case 2:
                    int pos = scan.nextInt();
                    System.out.println(ranking.getRecordByPos(pos).getNamePlayer());
                    break;
                case 3:
                    Record record = new Record("Pepe", 60);
                    ranking.addRecord(record);
                    break;
                case 4:
                    System.out.println(ranking.getGameMode());
                default:
                    System.out.println("Si us plau, introdueix un número vàlid.");
                    break;
            }
            System.out.println("--------------------------");
            System.out.println("Escull una de les seguents opcions:");
            System.out.println("1. Crea un Record nou.");
            System.out.println("2. Obtenir el nom del jugador del Record.");
            System.out.println("3. Obtenir el Temps obtingut per al Record.");
            System.out.println("-1. Sortir.");
            System.out.println("--------------------------");
        }
        
    }
}
