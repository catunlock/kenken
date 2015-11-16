/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.color;

import kenken.Board;
import kenken.Board;
import kenken.Cell;
import kenken.CellKenken;
import kenken.Region;

/**
 *
 * @author xaloc
 */
public class BoardColorator {
    private static Color colorByRegion(int region) {
        switch (region) {
        case 1:
          return Color.FG_GREEN;
        case 2:
          return Color.FG_DEFAULT;
        case 3:
          return Color.FG_CYAN;
        case 4:
          return Color.FG_RED;
        case 5:
          return Color.FG_YELLOW;
        case 6:
          return Color.FG_BLUE;
        case 7:
          return Color.FG_MAGENTA;
        }
        return Color.FG_DEFAULT;
    }

    public static void print(Board board) {
      
        for (int f = 0; f < board.size(); ++f) {
            for (int c = 0; c < board.size(); ++c) {
                CellKenken cell = board.getCell(f, c);
                
                Color color = colorByRegion(cell.getRegion());
                
                System.out.print(color + String.valueOf(cell.getSolutionValue()) + "-" + String.valueOf(cell.getRegion()) + Color.FG_DEFAULT + " ");
            }
            System.out.println();
        }
    }
    
    public static void printRegions(Board board) {
        for (Region r : board.getRegions()) {
            System.out.println("Region " + r.getId() + ": Operation: " + r.getOperationType() + " Result: " + r.getResult());
            System.out.print("\tValues: ");
            for (CellKenken c : r.getCellList()) {
                System.out.print(c.getSolutionValue() + " ");
            }
            System.out.println();
        }
    }
}
