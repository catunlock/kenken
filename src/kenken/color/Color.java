/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.color;

/**
 *
 * @author xaloc
 */

public enum Color {
    FG_DEFAULT(39),
    FG_BLACK(30),
    FG_RED(31),
    FG_GREEN(32),
    FG_YELLOW(33),
    FG_BLUE(34),
    FG_MAGENTA(35),
    FG_CYAN(36),
    FG_LIGHT_GRAY(37),
    FG_DARK_GRAY(90),
    FG_LIGHT_RED(91),
    FG_LIGHT_GREEN(92),
    FG_LIGHT_YELLOW(93),
    FG_LIGHT_BLUE(94),
    FG_LIGHT_MAGENTA(95),
    FG_LIGHT_CYAN(96),
    FG_WHITE(97),
    BG_RED(41),
    BG_GREEN(42),
    BG_BLUE(44),
    BG_DEFAULT(49);

    private final int code;
    
    private Color(int code) {
        this.code = code;
    }
    
    @Override
    public String toString() {
        return "\033[" + this.code + "m";
    }
}
