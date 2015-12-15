/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.time.Duration;
import java.util.ArrayList;
import kenken.domain.classes.Board;
import kenken.domain.classes.Game;
import kenken.persistance.controllers.GameDBController;
import kenken.domain.algorithms.Generator;
import kenken.domain.algorithms.Resolver;
import kenken.domain.classes.CellKenken;
import kenken.domain.classes.Pos;
import kenken.domain.classes.Region;
import kenken.domain.classes.User;
import kenken.gui.InfoCell;

/**
 *
 * @author GERARD
 */
public class GameController {
    
    private GameDBController gdbc = new GameDBController();
    private BoardController boardController = new BoardController();
    private BoardParser boardParser;
    private Game game;
    private boolean generated = false;

    public int updateAndSave(ArrayList<String> data, String username, String nompartida) {
        Board b = this.game.getBoard();
        int i = 0, j = 0;
        for (int x = 2; x < data.size(); ++x){
            int valor;
            
            if ("".equals(data.get(x))) valor = 0;
            else valor = Integer.parseInt(data.get(x));
            
            b.getCell(i, j).setUserValue(valor);
            ++j;
            if (j == b.size()){
                j = 0;
                ++i;
            }
        }
        this.game.setBoard(b);
        Duration time = Duration.ofSeconds(Long.parseLong(data.get(0)));
        this.game.setTime(time);
        this.game.setHints(Integer.parseInt(data.get(1)));
        return saveGame(this.game, username, nompartida);
    }

    public int getTime() {
        return (int) this.game.getTime().getSeconds();
    }
    
    /*
    Pre: 3 <= size => 9, dificultat != null
    Post: retorna una board generada amb el kenken de size = size
    */
    
    
    
    public int getHint(Pos p) {
        return game.getHint(p);
    }
    
    public int getHints() {
        return game.getHints();
    }
    
    public void resetHints(){
        game.setHints(3);
    }
    
    public void newGame(String boardName, String mode) {
        
        Board board = boardController.loadBoard(boardName);
        game = new Game(Game.Mode.valueOf(mode), board);
        game.setBoard(board);
        
    }
    
    public ArrayList<ArrayList<InfoCell>> getInfoBoard() {
        boardParser = new BoardParser(this.game.getBoard());
        return boardParser.getInfoBoard();
    }
    
    public void newGameGenerateBoard(String mode, int size, float pfRegionSize, float pfOperation, long seed) {
        generated = true;
        Generator generador = new Generator();
               
        Board generated = generador.generate(size, pfRegionSize, pfOperation, seed);
        boardParser = new BoardParser(generated);
        
        game = new Game(Game.Mode.valueOf(mode), generated);
        game.setBoard(generated);
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
    
    public int deleteSavedGame(UserController user, String game){
        String username = user.getLoggedUser().getUsername();
        return gdbc.deleteGame(username, game);
    }
    
    /*
    Pre: username != null
    Post: retorna una llista de strings amb les partides guardades del jugador
    */
    public ArrayList<String> getSavedGames(String username) {
        return gdbc.getSavedGames(username);
    }
    
    public ArrayList<String> getSavedGames(UserController uc) {
        User logged = uc.getLoggedUser();
        String name = logged.getUsername();
        return getSavedGames(name);
    }
    
    public ArrayList<ArrayList<Integer>> getSolutionValues() {
        Board b = game.getBoard();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(b.size());
       
        for (int i = 0; i < b.size(); ++i) 
        {
            result.add(new ArrayList<>(b.size()));
            
            for (int j = 0; j < b.size(); ++j) 
            {
                result.get(i).add(b.getCell(i, j).getSolutionValue());
            }
        }
        
        return result;
    }
    
    /*
    Pre: cert
    Post: es retorna el game el qual estava jugant l'user username i la taula id
    que s'estava jugant
    */
    public ArrayList<Integer> loadGame(String username, String nompartida) {
        this.game = gdbc.loadGame(username, nompartida);
        int tamany = this.game.getBoard().size();
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < tamany; ++i){
            for (int j = 0; j < tamany; ++j){
                data.add(this.game.getBoard().getCell(i, j).getUserValue());
            }
        }
        return data;
    }
    
     public boolean resolve(){
        Resolver resolver = new Resolver();
        return resolver.resolve(game.getBoard());
     }
     
     public boolean isCorrect(){
         return this.game.getBoard().isCorrect();
     }
     
     public void updateValue(int x, int c, int value) {
         game.getBoard().getCell(x, c).setUserValue(value);
     }

    public boolean isGenerated() {
        return generated;
    }
     
     
    
}
