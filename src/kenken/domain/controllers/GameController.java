/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.util.ArrayList;
import kenken.domain.classes.Board;
import kenken.domain.classes.Game;
import kenken.persistance.controllers.GameDBController;
import kenken.domain.algorithms.Generator;

/**
 *
 * @author GERARD
 */
public class GameController {
    
    GameDBController gdbc = new GameDBController();
    
    /*
    Pre: 3 <= size => 9, dificultat != null
    Post: retorna una board generada amb el kenken de size = size
    */
    
    public Board generateBoard(int size){
        Generator generador = new Generator();
                float pfRegionSize = 2f;
        float pfOperation = 2f;
        
        Board generated = generador.generate(9, pfRegionSize, pfOperation, System.nanoTime());
        return generated;
    }
    
    /*
    public Board createBoard(int size, String boardname){
        
    }
    */
    
    /*
    Pre: cert
    Post: es guarda a la DB el game actual i retorna
    0 si s'ha guardat amb èxit
    -1 si ja existeix
    -2 si hi ha errors interns
    */
    public int saveGame(Game game, String username, String nompartida){
        return gdbc.saveGame(game, username, nompartida);
    }
    
    /*
    Pre: username != null
    Post: retorna una llista de strings amb les partides guardades del jugador
    */
    public ArrayList<String> getSavedGames(String username){
        return gdbc.getSavedGames(username);
    }
    
    /*
    Pre: cert
    Post: es retorna el game el qual estava jugant l'user username i la taula id
    que s'estava jugant
    */
    public Game loadGame(String username, String nompartida){
        return gdbc.loadGame(username, nompartida);
    }
    
}
