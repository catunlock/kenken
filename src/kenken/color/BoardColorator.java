/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.color;

import kenken.Board;

/**
 *
 * @author xaloc
 */
public class BoardColorator {
    private Color colorRegion(int region) {
        switch (region) {
        case 1:
          return Color.FG_LIGHT_GREEN;
        case 2:
          return Color.FG_LIGHT_GRAY;
        case 3:
          return Color.FG_LIGHT_CYAN;
        case 4:
          return Color.FG_LIGHT_RED;
        case 5:
          return Color.FG_LIGHT_YELLOW;
        case 6:
          return Color.FG_LIGHT_BLUE;
        case 7:
          return Color.FG_LIGHT_MAGENTA;
        }
        return Color.FG_DEFAULT;
    }

    public void print(Board board) {
      
        for (int f = 0; f < board.size(); ++f) {
            for (int c = 0; c < board.size(); ++c) {
                board.getCell(f, c).get
                Color color = colorRegion(1);
                cout << color << c.c << " " << def;
            }
            cout << endl;
        }
    }
}
