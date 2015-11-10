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
        String testString = testRecord.getTimeAsString();
        System.out.println(testString);
    }
}
