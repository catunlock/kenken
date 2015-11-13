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
        
        System.out.println("-----------------------------------------------");
        System.out.println("Provant RankingDBController");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Crear nou ranking --> 0: creat correctament, -1: usuari existent, -2: error intern");
        System.out.println("2. Modificar ranking --> 0: correcte, -1: usuari existent, -2: error intern");
        System.out.println("3. Obtenir Ranking dels arxius");
        System.out.println("4. Obtenir boardName del ranking associat");
        System.out.println("5. Obtenir la array de Records del ranking");
        System.out.println("6. Obtenir el record segons la posicio de ranking");
        System.out.println("7. Afegir Record");
        System.out.println("8. Afegir Record a una posició donada(En el cas que el ranking ja tingui 10 Records)");
        System.out.println("9. ");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        Integer option;
        String ranking;
        String gameMode;
        
        while((option = scan.nextInt()) != -1) {
            switch(option){
                case 1: 
                    System.out.println("Nom de la Board associada al Ranking que vols crear: ");
                    ranking = scan.nextLine();
                    System.out.println("Mode de Joc:(Normal o TimeAttack)");
                    gameMode = scan.nextLine();
                    int resultat = test.createRanking(ranking, Ranking.GameMode.valueOf(gameMode));
                    System.out.println(resultat);
                    break;
                case 2:
                    System.out.println("BoardName del Ranking a modificar:");
                    ranking = scan.nextLine();
                    System.out.println("Nova contrasenya:");
                    pass = "";
                    User usuari2 = new User(user,pass);
                    test.modifyUser(usuari2,user);
                    break;                    
                case 3:
                    /*System.out.println("Introdueix el nou nom d'usuari:");
                    user = sc.nextLine();
                    test.setUsername(user);*/
                    break;
                case 4:
                    /*System.out.println("Introdueix la nova contrasenya:");
                    pass = sc.nextLine();
                    test.setPassword(pass);*/
                    break;            
                case 5:
                    /*test.incrementSolvedGames();*/
                    break;
                case 6:
                    //test.incrementStartedGames();
                    break;
                case 7:
                    //test.incrementTotalCreatedBoards();
                    break;
                case 8:
                    /*System.out.println("Introdueix els segons a incrementar:");
                    long segons = sc.nextLong();
                    Duration temps = Duration.ofSeconds(segons);
                    test.incrementTotalTimePlayed(temps);*/
                    break;
            }
        }
    }
}
