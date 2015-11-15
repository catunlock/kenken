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
 * @author GERARD
 */
public class BoardDriver {
    public static void main(String[] args) throws IOException
    {
        Board test;
        Region r;
        Scanner sc = new Scanner(System.in);
        int size, option;
        int posX, posY, solution;
        boolean original;
        
        System.out.println("-----------------------------------------------");
        System.out.println("Provant Board");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix size del Board:");
        size = sc.nextInt();
        test = new Board(size);
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Dona nom a la Board");
        System.out.println("2. Dona el nom de l'usuari creador de la Board");
        System.out.println("3. Mostra el nom de la Board");
        System.out.println("4. Mostra el nom del creador de la Board");
        System.out.println("5. Afegeix una cell");
        System.out.println("6. Mostra una Cell");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        while((option = sc.nextInt()) != -1) {
            switch(option){
                case 1:
                    System.out.print("Dona nom a la Board:");
                    test.setBoardName(sc.next());
                    break;
                case 2:
                    System.out.print("Dona nom del creador de la board:");
                    test.setUsername(sc.next());
                    break;
                case 3:
                    System.out.print("Nom de la Board:");
                    System.out.println(test.getBoardName());
                    break;
                case 4:
                    System.out.print("Creador:");
                    System.out.println(test.getUsername());
                    break;
                case 5:
                    System.out.println("Introdueix posició X de la Cell:");
                    posX = sc.nextInt();
                    System.out.println("Introdueix posició Y de la Cell:");
                    posY = sc.nextInt();
                    System.out.println("Introdueix valor de la solució de la Cell");
                    solution = sc.nextInt();
                    System.out.println("Introdueix si la Cell és original (1 = sí, 2 = no):");
                    if (sc.nextInt() == 1) original = true;
                    else original = false;
                    Cell c;
                    c = new Cell(posX, posY, original, solution);
                    test.setCell(posX, posY, c);
                    break;
                case 6:
                    System.out.println("Introdueix posició X de la Cell:");
                    posX = sc.nextInt();
                    System.out.println("Introdueix posició Y de la Cell:");
                    posY = sc.nextInt();
                    c = test.getCell(posX, posY);
                    System.out.println("Posició X = "+c.getPosX()+", posició Y = "+c.getPosY()+", valor correcte = "+c.getSolutionValue());
                    break;
            }
        }
    }
}
