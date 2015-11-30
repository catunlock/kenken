/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package kenken.gui;

/*
 * CardLayoutDemo.java
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import kenken.domain.controllers.BoardController;
import kenken.domain.controllers.GameController;
import kenken.domain.controllers.RankingController;
import kenken.domain.controllers.UserController;

public class MainWindow {
    JPanel cards; //a panel that uses CardLayout
    
    private BoardController bc = new BoardController();
    private GameController gc = new GameController();
    private RankingController rc = new RankingController();
    private UserController uc = new UserController();

    public BoardController getBoardController() {
        return bc;
    }

    public GameController getGameController() {
        return gc;
    }

    public RankingController getRankingController() {
        return rc;
    }

    public UserController getUserController() {
        return uc;
    }
    
    
    enum Panels {
        PANELONE,
        PANELTWO,
        CreateBoardPanel,
        ExportBoardPanel,
        MainMenuPanel;
        
        public static String[] getStrings() {
            int length = Panels.values().length;
            String[] ss = new String[length];
            
            for (int i = 0; i < length; i++) {
                ss[i] = Panels.values()[i].name();
            }
            
            return ss;
        }
    };
    
    public void setPanel(Panels p) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, p.name());
    }
    
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        
        //Create the "cards".
        CreateBoardPanel cbw = new CreateBoardPanel(this);
        ExportBoardPanel ebp = new ExportBoardPanel(this);
        MainMenuPanel mmp = new MainMenuPanel(this);
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        
        cards.add(mmp, Panels.MainMenuPanel.name());
        cards.add(cbw, Panels.CreateBoardPanel.name());
        cards.add(ebp, Panels.ExportBoardPanel.name());
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        MainWindow demo = new MainWindow();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}