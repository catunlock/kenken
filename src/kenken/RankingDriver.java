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
        System.out.println("3. Obtenir tot el Ranking.");
        System.out.println("4. Afegeix un Record al Ranking.");
        System.out.println("5. Obtenir el mode del joc del Ranking.");
        System.out.println("6. Obtenir el nom del Tauler associat al Ranking.");
        System.out.println("7. Obtenir quants records té el Ranking.");
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
                    int posicio;
                    for(int i = 0; i < ranking.getRecordListSize(); i++){
                        posicio = i + 1;
                        System.out.println(posicio + ". Jugador: " + ranking.getRecordByPos(i).getNamePlayer() + " Temps tardat: " + ranking.getRecordByPos(i).getTime().getSeconds() );
                    }
                    break;
                case 4:
                    System.out.print("Introdueix el nom del Record: ");
                    String nomPlayer = scan.next();
                    System.out.print("Introdueix el temps (en segons) del Record: ");
                    long temps = scan.nextLong();
                    Record record = new Record(nomPlayer, temps);
                    ranking.addRecord(record);
                    break;
                case 5:
                    System.out.println(ranking.getGameMode());
                    break;
                case 6:
                    System.out.println(ranking.getBoardName());
                    break;
                case 7:
                    System.out.println(ranking.getRecordListSize());
                    break;
                default:
                    System.out.println("Si us plau, introdueix un número vàlid.");
                    break;
            }
            System.out.println("--------------------------");
            System.out.println("1. Crea un Ranking nou.");
            System.out.println("2. Obtenir el Record segons una posició existent donada[0..9]");
            System.out.println("3. Obtenir tot el Ranking.");
            System.out.println("4. Afegeix un Record al Ranking.");
            System.out.println("5. Obtenir el mode del joc del Ranking.");
            System.out.println("6. Obtenir el nom del Tauler associat al Ranking.");
            System.out.println("7. Obtenir quants records té el Ranking.");
            System.out.println("-1. Sortir.");
            System.out.println("--------------------------");
        }
        
    }
}
