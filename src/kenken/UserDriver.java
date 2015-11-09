/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import static java.time.Clock.system;
import java.time.Duration;
import java.util.ArrayList;

/**
 *
 * @author joan pol
 */
public class UserDriver {
    
    public static void main(String[] args)
    {
        User test = new User("test","pass");
        System.out.println("Probando getUsername");
        System.out.println(test.getUsername());
        System.out.println("Todo tendria que estar a cero:");
        System.out.println(test.getSolvedGames());
        System.out.println(test.getStartedGames());
        System.out.println(test.getTotalTimePlayed());
        System.out.println(test.getTotalCreatedBoards());
        //System.out.println(test.getActualCreatedBoard());
        
        test.setUsername("manolo");
        System.out.println("L'usuari ara es dira Manolo:");
        System.out.println(test.getUsername());
        System.out.println(test.getPassword());
        
        System.out.println("Incrementar resolts, started, totalcreatedboards, incrementar duration 2m");
        test.incrementSolvedGames();
        test.incrementStartedGames();
        test.incrementTotalCreatedBoards();
        System.out.println("Solved Games: " + test.getSolvedGames());
        System.out.println("Started Games: " + test.getStartedGames());
        System.out.println("Created boards: " + test.getTotalCreatedBoards());
        
        //salta error NullPointerException desde la classe User
        Duration temps = Duration.ofMinutes(2);
        test.incrementTotalTimePlayed(temps);
        System.out.println(test.getTotalTimePlayed().getSeconds());       
        
        //apartado de accesos a tableros, falta UserController para poder
        //probar del todo la funcionalidad
        
        /*
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
