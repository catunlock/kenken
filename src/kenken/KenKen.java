/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import kenken.persistance.controllers.DirectoryCreator;
import kenken.domain.algorithms.Generator;
import kenken.domain.classes.Ranking;
import kenken.domain.classes.Game;
import kenken.domain.classes.Board;
import kenken.domain.controllers.UserController;
import kenken.domain.controllers.GameController;
import kenken.domain.controllers.RankingController;
import kenken.domain.controllers.BoardController;
import java.util.Scanner;

/**
 *
 * @author Gerard
 * 
 */
public class KenKen {

    /**
     * @param args the command line arguments
     */
    
    
    
    /*public KenKen() {
        Generator gen = new Generator();
        Board b = gen.generate(4);
        System.out.println("Board: " + b);
    }*/
    
    public static void main(String[] args) {
        // TODO code application logic here
        DirectoryCreator dc = new DirectoryCreator();
        dc.createInitial();
        UserController uc = new UserController();
        BoardController bc = new BoardController();
        GameController gc = new GameController();
        RankingController rc = new RankingController();
        Generator gen = new Generator();
        Scanner sc = new Scanner(System.in);
        int optionuser = 0;
        int error = -1;
        boolean salir = false;
        String nom;
        String pass;
        while (!salir){
            /*
            Seleccionamos registro, login o invitado
            */
            while (error != 0 && !salir){
                System.out.println("Vols registrar un usuari, fer login, o jugar com a convidat?");
                System.out.println("1. Registrar");
                System.out.println("2. Login");
                System.out.println("3. Jugar com a convidat");
                System.out.println("4. Sortir");
                optionuser = sc.nextInt();
                switch(optionuser){
                    case 1:
                        System.out.print("Nom de l'usuari:");
                        nom = sc.next();
                        System.out.print("Password de l'usuari:");
                        pass = sc.next();
                        if (uc.createUser(nom, pass) == -1) {
                            System.out.println("Ja hi ha un usuari amb aquest nom");
                        }
                        else {
                            error = uc.login(nom, pass);
                        }
                        break;
                    case 2:
                        System.out.print("Nom de l'usuari:");
                        nom = sc.next();
                        System.out.print("Password de l'usuari:");
                        pass = sc.next();
                        error = uc.login(nom, pass);
                        if (error == -1) System.out.println("Nom d'usuari incorrecte");
                        else if (error == -2) System.out.println("Password incorrecte");
                        break;
                    case 3:
                        error = 0;
                        break;
                    case 4:
                        salir = true;
                        break;
                }
            }
            /*
            Seleccionamos que queremos hacer si nos hemos logueado
            */
            if (!salir && optionuser != 3){
                int mainoptionlogged;
                error = -1;
                while (error != 0 && !salir){
                    System.out.println("Vols jugar, continuar una partida, generar un kenken o veure els rankings?");
                    System.out.println("1. Jugar");
                    System.out.println("2. Continuar partida");
                    System.out.println("3. Generar");
                    System.out.println("4. Veure rankings");
                    System.out.println("5. Sortir");
                    mainoptionlogged = sc.nextInt();
                    switch(mainoptionlogged){
                        case 1:
                            System.out.print("Nom de la board que vols jugar:");
                            nom = sc.next();
                            Board b = bc.exportBoard(nom);
                            if (b == null) {
                                System.out.println("No existeix cap board amb aquest nom.");
                                error = -1;
                            }
                            else {
                                System.out.println("A quin mode vols jugar?");
                                System.out.println("1. Normal");
                                System.out.println("2. TimeAttack");
                                if (sc.nextInt() == 1) {
                                    Game g = new Game("Normal");
                                    g.setBoard(b);
                                }
                                else{
                                    Game g = new Game("TimeAttack");
                                    g.setBoard(b);
                                }
                                error = 0;
                            }
                            break;
                        case 2:
                            System.out.println("Tens aquestes partides guardades:");
                            System.out.println(gc.getSavedGames(uc.getLoggedUser().getUsername()));
                            System.out.print("Nom de la partida que vols carregar:");
                            nom = sc.next();
                            Game g = gc.loadGame(uc.getLoggedUser().getUsername(), nom);
                            if (g == null) {
                                System.out.println("No existeix aquesta partida");
                                error = -1;
                            }
                            else  error = 0;
                            break;
                        case 3:
                            System.out.print("Introdueix grandaria de la board que vols generar: ");
                            int size = sc.nextInt();
                            Board genb;
                            genb = gen.generate(size, 1, 1, System.nanoTime());
                            genb.setUsername(uc.getLoggedUser().getUsername());
                            System.out.print("Nom de la Board que acabes de crear:");
                            nom = sc.next();
                            genb.setBoardName(nom);
                            error = bc.importBoard(genb);
                            if (error == -1) System.out.println("Ja existeix una board amb aquest nom!");
                            else if (error == -2) System.out.print("Error intern.");
                            break;
                        case 4:
                            System.out.print("Nom de la Board de la que es vol veure el ranking:");
                            nom = sc.next();
                            Ranking rk = rc.getRanking(nom);
                            if (rk == null) System.out.println("Aquest ranking encara no eisteix!");
                            else System.out.println(rc.getRanking(nom).getRecordList());
                            break;
                        case 5:
                            salir = true;
                            break;
                    }
                }
            }
            /*
            Seleccionamos que queremos hacer si estamos como invitado
            */
            else if (!salir && optionuser == 3){
                int mainoptionnotlogged;
                error = -1;
                while (error != 0 && !salir){
                    System.out.println("Vols jugar o veure els rankings?");
                    System.out.println("1. Jugar");
                    System.out.println("2. Veure rankings");
                    System.out.println("3. Sortir");
                    mainoptionnotlogged = sc.nextInt();
                    switch(mainoptionnotlogged){
                        case 1:
                            System.out.println("Vols jugar una board ja creada o generar una?");
                            System.out.println("1. Jugar una existent");
                            System.out.println("2. Generar");
                            System.out.println("3. Sortir");
                            int optiongameguest = sc.nextInt();
                            if (optiongameguest == 1){
                                System.out.print("Nom de la board que vols jugar:");
                                nom = sc.next();
                                Board b = bc.exportBoard(nom);
                                if (b == null) {
                                    System.out.println("No existeix cap board amb aquest nom.");
                                    error = -1;
                                }
                                else {
                                    System.out.println("A quin mode vols jugar?");
                                    System.out.println("1. Normal");
                                    System.out.println("2. TimeAttack");
                                    if (sc.nextInt() == 1) {
                                        Game g = new Game("Normal");
                                        g.setBoard(b);
                                    }
                                    else{
                                        Game g = new Game("TimeAttack");
                                        g.setBoard(b);
                                    }
                                    error = 0;
                                }
                            }
                            else if(optiongameguest == 2){
                                System.out.print("Introdueix grandaria de la board que vols generar: ");
                                int size = sc.nextInt();
                                Board genb;
                                genb = gen.generate(size, 1, 1, System.nanoTime());
                                System.out.println("A quin mode vols jugar?");
                                System.out.println("1. Normal");
                                System.out.println("2. TimeAttack");
                                if (sc.nextInt() == 1) {
                                    Game g = new Game("Normal");
                                    g.setBoard(genb);
                                }
                                else{
                                    Game g = new Game("TimeAttack");
                                    g.setBoard(genb);
                                }
                                error = 0;
                            }
                            else salir = true;
                            break;
                        case 2:
                            System.out.print("Nom de la Board de la que es vol veure el ranking:");
                            nom = sc.next();
                            Ranking rk = rc.getRanking(nom);
                            if (rk == null) System.out.println("Aquest ranking encara no eisteix!");
                            else System.out.println(rc.getRanking(nom).getRecordList());
                            break;
                        case 3:
                            salir = true;
                            break;
                    }
                }
            }
            //System.out.println("Starting Bitches KenKen...");
            //KenKen k = new KenKen();        
        }
    }
    
}