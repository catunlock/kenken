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
public class CellDriver {
    public static void main(String[] args) throws IOException
    {
        Cell test;
        Scanner sc = new Scanner(System.in);
        int posX, posY, solution, option;
        boolean original;
        
        System.out.println("-----------------------------------------------");
        System.out.println("Provant Cell");
        System.out.println("-----------------------------------------------");
        System.out.println("Introdueix posició X de la Cell:");
        posX = sc.nextInt();
        System.out.println("Introdueix posició Y de la Cell:");
        posY = sc.nextInt();
        System.out.println("Introdueix valor de la solució de la Cell");
        solution = sc.nextInt();
        System.out.println("Introdueix si la Cell és original:");
        System.out.println("1. Sí");
        System.out.println("2. No");
        if (sc.nextInt() == 1) original = true;
        else original = false;
        test = new Cell(posX, posY, original, solution);
        System.out.println("Introdueix un numero per a executar la operació:");
        System.out.println("-----------------------------------------------"); 
        System.out.println("1. Mostra posició X de la Cell");
        System.out.println("2. Mostra posició Y de la Cell");
        System.out.println("3. Mostra el valor correcte de la Cell");
        System.out.println("4. Dona un valor a la cell");
        System.out.println("5. Mostra el valor que li dona l'usuari a la Cell");
        System.out.println("6. Mostra si la cell és original");
        System.out.println("7. Mostra si el valor que l'usuari li dona a la Cell és el correcte");
        System.out.println("8. Afegeix un valor a la llista de valors possibles de la Cell");
        System.out.println("9. Elimina un valor de la llista de valors possibles de la Cell");
        System.out.println("10. Mostra el valors possibles de la Cell");
        System.out.println("11. Mostra la size de la llista de valors possibles de la Cell");
        System.out.println("-1. Exit");
        System.out.println("-----------------------------------------------");
        
        while((option = sc.nextInt()) != -1) {
            switch(option){
                case 1:
                    System.out.println(test.getPosX());
                    break;
                case 2:
                    System.out.println(test.getPosY());
                    break;
                case 3:
                    System.out.println(test.getSolutionValue());
                    break;
                case 4:
                    System.out.print("Valor:");
                    test.setUserValue(sc.nextInt());
                    break;
                case 5:
                    System.out.println(test.getUserValue());
                    break;
                case 6:
                    System.out.println(test.isOriginal());
                    break;
                case 7:
                    System.out.println(test.isCorrect());
                    break;
                case 8:
                    System.out.print("Valor a afegir:");
                    test.addPossibleValue(sc.nextInt());
                    break;
                case 9:
                    System.out.print("Valor a eliminar:");
                    test.removePossibleValue(sc.nextInt());
                    break;
                case 10:
                    System.out.println(test.getPossibleValues());
                    break;
                case 11:
                    System.out.println(test.getSizePossibleValues());
                    break;
            }
        }
    }
}
