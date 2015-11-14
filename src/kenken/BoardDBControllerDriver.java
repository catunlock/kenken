/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pol
 */
public class BoardDBControllerDriver {
    public static void main(String[] args) throws IOException
    {
        BoardDBController test = new BoardDBController();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Provant BoardDBController");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Crear nova Board a la DB --> 0: creat correctament, -1: ja existent, -2: error intern");
        System.out.println("2. Eliminar Board de la DB --> 0: correcte, -1: Board no existeix, -2: error intern");
        System.out.println("3. Carregar Board de la DB i mostrar informació");
        System.out.println("4. Comprovar si una taula existeix");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        Integer option;
        String boardName;
        int result;
        String enter;
        
        while((option = sc.nextInt()) != -1) {
            //enter = sc.next();
            switch(option){
                case 1:
                    System.out.println("Introdueix nom de tauler:");
                    boardName = sc.next();
                    System.out.println("Introdueix tamany tauler:");
                    int x = sc.nextInt();
                    //enter = sc.next();
                    System.out.println("Introdueix usuari de tauler:");
                    String userBoard = sc.next();
                    System.out.println("Introdueix dificultat de tauler:");
                    String difficulty = sc.next();
                    Board board = new Board(x,x);
                    board.setBoardName(boardName);
                    board.setDifficulty(difficulty);
                    board.setUsername(userBoard);
                    result = test.createBoard(board);
                    if (result == 0){
                        System.out.println("Tauler creat correctament");
                    }
                    else if (result == -1){
                        System.out.println("Nom de tauler ja existent");
                    }
                    else{
                        System.out.println("Error intern");
                    }
                    break;
                case 2:
                    System.out.println("Introdueix nom de tauler a eliminar:");
                    boardName = sc.next();
                    //boardName = boardName.replaceAll("(\\r|\\n)", "");
                    result = test.deleteBoard(boardName);
                    if (result == 0){
                        System.out.println("Tauler eliminat correctament");
                    }
                    else if (result == -1){
                        System.out.println("Nom de tauler inexistent");
                    }
                    else{
                        System.out.println("Error intern");
                    }
                    break;
                case 3:
                    System.out.println("Introdueix nom de tauler a carregar:");
                    boardName = sc.next();
                    Board b = test.loadBoard(boardName);
                    if(b == null){
                        System.out.println("Board no existeix.");
                    }
                    else{
                        System.out.println("Nom tauler carregat: " + b.getBoardName());
                        System.out.println("User del tauler carregat: " + b.getUsername());
                        System.out.println("Dificultat del tauler carregat: " + b.getDifficulty());
                        System.out.println("Mida del tauler carregat: " + b.getSizeX());
                    }
                    break;
                case 4:
                    System.out.println("Introdueix nom de taula a comprovar:");
                    boardName = sc.next();
                    boolean resultc = test.exists(boardName);
                    if (resultc == true){
                        System.out.println("Taula existent");
                    }else{
                        System.out.println("Taula no existent");
                    }
                    break;
            }
        }
    }   
}
