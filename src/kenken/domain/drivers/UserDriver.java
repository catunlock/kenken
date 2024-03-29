/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.drivers;

import kenken.domain.classes.User;
import kenken.domain.classes.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.time.Clock.system;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joan pol
 */
public class UserDriver {
    private static Object sTexto;
    
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("--- Per tal de poder provar aquesta classe, necessitem crear un nou Usuari ---");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Introdueix nom d'usuari:");
        String user = sc.next();
        System.out.println("Introdueix contrasenya:");
        String pass = sc.next();
        User test = new User(user,pass);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix un número d'operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Mostrar usuari y contrasenya");
        System.out.println("2. Mostrar SolvedGames, StartedGames, TotalTimePlayed, TotalCreatedBoards y ActualCreatedBoards");
        System.out.println("3. Canviar nom d'usuari");
        System.out.println("4. Canviar contrasenya");
        System.out.println("5. Incrementar SolvedGames");
        System.out.println("6. Incrementar StartedGames");
        System.out.println("7. Incrementar TotalCreatedBoards");
        System.out.println("8. Incrementar TotalTimePlayed");
        System.out.println("9. Afegir una board a l'usuari");
        System.out.println("10. Llistar informacio de taulers de l'usuari");
        System.out.println("11. Eliminar una board del usuari");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        Integer option;
        
        while((option = sc.nextInt()) != -1) {
        
            switch(option){
                case 1: 
                    System.out.println("Nom d'usuari:" + test.getUsername());
                    System.out.println("Contrasenya d'usuari:" + test.getPassword());
                    break;
                case 2:
                    System.out.println("Solved Games:" + test.getSolvedGames());
                    System.out.println("Started Games:" + test.getStartedGames());
                    System.out.println("Total Time Played:" + test.getTotalTimePlayed().getSeconds());
                    System.out.println("Total Created Boards:" + test.getTotalCreatedBoards());
                    System.out.println("Actual Created Boards:" + test.getActualCreatedBoard());
                    break;                    
                case 3:
                    System.out.println("Introdueix el nou nom d'usuari:");
                    user = sc.next();
                    test.setUsername(user);
                    break;
                case 4:
                    System.out.println("Introdueix la nova contrasenya:");
                    pass = sc.next();
                    test.setPassword(pass);
                    break;            
                case 5:
                    test.incrementSolvedGames();
                    break;
                case 6:
                    test.incrementStartedGames();
                    break;
                case 7:
                    test.incrementTotalCreatedBoards();
                    break;
                case 8:
                    System.out.println("Introdueix els segons a incrementar:");
                    long segons = sc.nextLong();
                    Duration temps = Duration.ofSeconds(segons);
                    test.incrementTotalTimePlayed(temps);
                    break;
                case 9:
                    System.out.println("Introdueix nom del board:");
                    String boardname = sc.next();
                    System.out.println("Introdueix el tamany:");
                    int size = sc.nextInt();
                    Board b = new Board(size);
                    b.setUsername(test.getUsername());
                    b.setBoardName(boardname);
                    test.addBoard(b);
                    break;
                case 10:
                    System.out.println("-- Taulers de l'usuari -- ");
                    ArrayList<Board> boards = test.getCreatedBoards();
                    for(int i=0; i < boards.size(); i++) {
                        System.out.println("-- Tauler " + i + " -- ");
                        System.out.println("Nom tauler: " + boards.get(i).getBoardName());
                        System.out.println("Usuari: " + boards.get(i).getUsername());
                        System.out.println("Mida: " + boards.get(i).size());
                    }
                    break;
                case 11:
                    System.out.println("Introdueix posicio del board a eliminar:");
                    int pos = sc.nextInt();
                    test.deleteBoard(pos);
            }
        }

        /*
        //apartado de accesos a tableros, falta UserController para poder
        //probar del todo la funcionalidad
        
        ArrayListArrayList<Board> getCreatedBoards(){
        return createdBoards;
        }
        public Board getCreatedBoard(int pos){
        return createdBoards.get(pos);
        }
        public void addBoard(Board newBoard){
        createdBoards.add(newBoard);
        }
        public void deleteBoard(int pos){
        createdBoards.remove(pos);
        }
         */

    }
    
}
