/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marc
 */
public class RegionDriver {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Provant Region");
        System.out.println("---------------");
        System.out.println("Escull una opcio: ");
        System.out.println("1. Consulta el tipus d'operacio de la regio.");
        System.out.println("2. Consulta el resultat que hauria de donar al realitzar les operacions.");
        System.out.println("3. Comprova si els nombres de dins la regio operats donen el resultat.");
        System.out.println("4. Modifica el tipus d'operacio [None, Add, Subtract, Multiply, Divide].");
        System.out.println("5. Modifica el resultat de la regio.");
        System.out.println("6. Modifica si es valid la combinacio.");
        System.out.println("-1. Sortir.");
        System.out.println("---------------");
        
        Region region = new Region(1, new ArrayList<Cell>(), Region.OperationType.None, 3, false);
        
        int opt = 0;
        while ((opt = scan.nextInt()) != -1){
            switch(opt){
                case 1:
                    System.out.println(region.getOperationType());
                    break;
                case 2:
                    System.out.println(region.getResult());
                    break;
                case 3:
                    System.out.println(region.isValid());
                    break;
                case 4:
                    String op = scan.next();
                    region.setOperationType(Region.OperationType.valueOf(op));
                    System.out.println(region.getOperationType());
                    break;
                case 5:
                    int res = scan.nextInt();
                    region.setResult(res);
                    System.out.println(region.getResult());
                    break;
                case 6:
                    boolean valid = scan.nextBoolean();
                    region.setValid(valid);
                    System.out.println(region.isValid());
                    break;
                default:
                    System.out.println("introdueix un nombre valid si us plau.");
                    break;
                
            }
            System.out.println("Escull una opcio: ");
            System.out.println("1. Consulta el tipus d'operacio de la regio.");
            System.out.println("2. Consulta el resultat que hauria de donar al realitzar les operacions.");
            System.out.println("3. Comprova si els nombres de dins la regio operats donen el resultat.");
            System.out.println("4. Modifica el tipus d'operacio [None, Add, Subtract, Multiply, Divide].");
            System.out.println("5. Modifica el resultat de la regio.");
            System.out.println("6. Modifica si es valid la combinacio.");
            System.out.println("-1. Sortir.");
            System.out.println("---------------");
        }
    }
}
