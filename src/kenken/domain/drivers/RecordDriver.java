/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.drivers;

import java.util.Scanner;
import kenken.domain.classes.Record;

/**
 *
 * @author Marc Ferré Monné
 */
public class RecordDriver {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int opt;
        Record record = new Record("Pepe", 40);
        System.out.println("Per defecte hem creat un record amb el nom de jugador 'Pepe' i amb un temps de 40 segons");
        System.out.println("Escull una de les seguents opcions:");
        System.out.println("1. Crea un Record nou.");
        System.out.println("2. Obtenir el nom del jugador del Record.");
        System.out.println("3. Obtenir el Temps obtingut per al Record.");
        System.out.println("-1. Sortir.");
        while((opt = scan.nextInt()) != -1){
            switch(opt){
                case 1:
                    System.out.print("Introdueix el nom del Jugador: ");
                    String nomJugador = scan.next();
                    System.out.print("Introdueix el Temps del Jugador: ");
                    String temps = scan.next();
                    record = new Record(nomJugador, Long.parseLong(temps));
                    break;
                case 2:
                    System.out.println(record.getNamePlayer());
                    break;
                case 3:
                    System.out.println(record.getTime().getSeconds());
                    break;
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
