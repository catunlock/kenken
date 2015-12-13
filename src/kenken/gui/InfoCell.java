/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

/**
 *
 * @author SuNLoCK
 */
public class InfoCell {

    public String operation = "";
    public String result = "";
    public String value = "";
    public boolean borderHoritzontal = false;
    public boolean borderVertical = false;
    public boolean hinted = false;
    public boolean showIsCorrect = false;
    public boolean correct = false;

    String getValue() {
        return value;
    }
}
