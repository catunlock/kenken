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
import kenken.domain.classes.User;
import kenken.gui.InfoCell;

/**
 *
 * @author GERARD
 */
public class GameController {
    
    GameDBController gdbc = new GameDBController();
    Game game;
    
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
    
    public ArrayList<ArrayList<InfoCell>> parseBoard(Board board) {
        ArrayList<ArrayList<InfoCell>> infoCells = new ArrayList<>(board.size());
        
        for (int f = 0; f < infoCells.size(); ++f) {
            infoCells.add(new ArrayList<InfoCell>(board.size()));
            for (int c = 0; c < infoCells.size(); ++c) {
                infoCells.get(f).set(c, new InfoCell());
            }
        }
        
        for (int f = 0; f < infoCells.size(); ++f) {
            for (int c = 1; c < infoCells.size(); ++c) {
                if ( board.getCell(f, c-1).getRegion() != board.getCell(f, c).getRegion()) {
                    infoCells.get(f).get(c).borderVertical = true;
                }
            }
        }
        
        return infoCells;
    }
    
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
    
    public int deleteSavedGame(UserController user, String game){
        String username = user.getLoggedUser().getUsername();
        return gdbc.deleteGame(username, game);
    }
    
    /*
    Pre: username != null
    Post: retorna una llista de strings amb les partides guardades del jugador
    */
    public ArrayList<String> getSavedGames(String username){
        return gdbc.getSavedGames(username);
    }
    
    public ArrayList<String> getSavedGames(UserController uc){
        User logged = uc.getLoggedUser();
        String name = logged.getUsername();
        return getSavedGames(name);
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
