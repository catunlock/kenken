/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.util.ArrayList;
import kenken.domain.classes.User;

/**
 *
 * @author GERARD
 */
public class UserDataGetter {
    public ArrayList<String> toString(UserController uc){
        User user = uc.getLoggedUser();
        ArrayList<String> dades = new ArrayList<>(3);
        dades.add((Long.toString(user.getTotalTimePlayed().getSeconds())));
        dades.add(Integer.toString(user.getTotalCreatedBoards()));
        int userSolved, userStarted, percent;
        userSolved = user.getSolvedGames();
        userStarted = user.getStartedGames();
        if (userStarted == 0) percent = 0;
        else percent = (userSolved/userStarted)*100;
        dades.add(Integer.toString(percent) + "%");
        return dades;
    }
}
