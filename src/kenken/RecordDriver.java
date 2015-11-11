/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.time.Duration;
import java.util.ArrayList;

/**
 *
 * @author Marc Ferré Monné
 */
public class RecordDriver {
    public static void main (String[] args){
        Record testRecord = new Record("Marc", 60);
        ArrayList<String> test = testRecord.recordToString();
        int size = test.size();
        for (int i = 0; i < size; i++){
            System.out.println(test.get(i));
        }
        System.out.println("Actualment llegit del vector de Strings.");
        testRecord = Record.stringToRecord(test);
        System.out.println(testRecord.getNamePlayer());
        System.out.println(testRecord.getTime().getSeconds());
        System.out.println("Actualment llegit de l'objecte Record.");
        
    }
}
