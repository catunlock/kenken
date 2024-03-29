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
import kenken.persistance.controllers.DirectoryCreator;

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

    /**
     * Creates a user directory.
     * @param username The owner of the directory.
     * @return An integer with error code 0 : Directory succesfully created. -1 : The User already exists.
     */
    public int createGames(String username){
        DirectoryCreator dc = new DirectoryCreator();
        return dc.createUser(username);
    }
    
    /**
     * Deletes a user Directory.
     * @param username The owner of the directory.
     * @return An integer with error code 0 : Directory succesfully deleted. -1 : The User doesn't exist.
     */
    public int deleteGames(String username){
        DirectoryCreator dc = new DirectoryCreator();
        return dc.deleteUser(username);
    }
    
    /**
     * Updates the data of a game and then saves it to the database.
     * @param data Contains the data.
     * @param username The owner of the game.
     * @param nompartida The name of the game.
     * @return An Integer with the error code  0 : Saved succesfully. -1 : The game already exists. -2 : Internal error.
     */
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

    /**
     * Gets the time of the game.
     * @return An integer with the time in seconds.
     */
    public int getTime() {
        return (int) this.game.getTime().getSeconds();
    }
    
    /*
    Pre: 3 <= size => 9, dificultat != null
    Post: retorna una board generada amb el kenken de size = size
    */
    
    /**
     * Gets the name of the board.
     * @return A string with the boardname.
     */
    public String getBoardName(){
        return this.game.getBoard().getBoardName();
    }
    
    /**
     * Gets a hint from a position.
     * @param p The position to be hinted.
     * @return 
     */
    public int getHint(Pos p) {
        int hint = game.getHint(p);
        game.getBoard().getCell(p.c, p.f).setUserValue(hint);
        return hint;
    }
    
    /**
     * Gets the number of hints avaliable.
     * @return An int with the hints.
     */
    public int getHints() {
        return game.getHints();
    }
    
    /**
     * Reset the number of hints avaliable.
     */
    public void resetHints(){
        game.setHints(3);
    }
    
    /**
     * Sets a new Game with a board and a mode
     * @param boardName The board to be loaded.
     * @param mode The mode to be played.
     */
    public void newGame(String boardName, String mode) {
        
        Board board = boardController.loadBoard(boardName);
        game = new Game(Game.Mode.valueOf(mode), board);
        game.setBoard(board);
        
    }
    
    /**
     * Gets the info from the board.
     * @return A matrix as a board of info cells.
     */
    public ArrayList<ArrayList<InfoCell>> getInfoBoard() {
        boardParser = new BoardParser(this.game.getBoard());
        return boardParser.getInfoBoard();
    }
    
    /**
     * 
     * @param mode
     * @param size
     * @param pfRegionSize
     * @param pfOperation
     * @param seed 
     */
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
    
    public String gameMode(){
        return this.game.getMode();
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
