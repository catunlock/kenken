/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.ArrayList;

/**
 *
 * @author Marc
 */
public class RankingDriver {
    public static void main(String[] args){
        Ranking ranking = new Ranking("Tauler", Ranking.GameMode.Normal);
        Record record = new Record("Marc", 30);
        Record record1 = new Record("Joan", 40);
        ranking.addRecord(record);
        ranking.addRecord(record1);
        System.out.println(ranking.getRecordByPos(1).getNamePlayer());
        ArrayList<String> strings = ranking.rankingToString();
        System.out.println(strings.size());
        Ranking ranking1 = Ranking.stringToRanking(strings);
        System.out.println(ranking1.getRecordByPos(1).getTime().getSeconds());
    }
}
