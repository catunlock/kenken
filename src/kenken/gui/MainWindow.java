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
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import static java.nio.file.StandardCopyOption.*;
import kenken.domain.controllers.BoardController;
import kenken.domain.controllers.CreatorController;
import kenken.domain.controllers.GameController;
import kenken.domain.controllers.RankingController;
import kenken.domain.controllers.UserController;
import kenken.domain.controllers.UserControllerKenken;
import kenken.domain.controllers.UserDataGetter;
import kenken.persistance.controllers.DirectoryCreator;

public class MainWindow {

    JPanel cards; //a panel that uses CardLayout

    Hashtable<String, JPanel> panels = new Hashtable<>();

    private BoardController bc = new BoardController();
    private GameController gc = new GameController();
    private RankingController rc = new RankingController();
    private UserControllerKenken uc = new UserControllerKenken();
    private UserDataGetter dg = new UserDataGetter();
    private CreatorController cc = new CreatorController();

    public MainWindow() {

        try {
            DirectoryCreator dc = new DirectoryCreator();
            dc.createInitial();

            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, you can set the GUI to another look and feel.
            }
            GraphicsEnvironment ge
                    = GraphicsEnvironment.getLocalGraphicsEnvironment();
            try {

                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("FLUBBER.TTF")));
            } catch (FontFormatException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            Files.copy(getClass().getResourceAsStream("/kenken/boards/Boards/brd/KenKen 3x3 2.brd"), Paths.get("Boards/brd/KenKen 3x3 2.brd"), REPLACE_EXISTING);
            Files.copy(getClass().getResourceAsStream("/kenken/boards/Boards/info/KenKen 3x3 2.inf"), Paths.get("Boards/info/KenKen 3x3 2.inf"), REPLACE_EXISTING);
            
            Files.copy(getClass().getResourceAsStream("/kenken/boards/Boards/brd/KenKen3x3.brd"), Paths.get("Boards/brd/KenKen 3x3.brd"), REPLACE_EXISTING);
            Files.copy(getClass().getResourceAsStream("/kenken/boards/Boards/info/KenKen3x3.inf"), Paths.get("Boards/info/KenKen 3x3.inf"), REPLACE_EXISTING);
            
            Files.copy(getClass().getResourceAsStream("/kenken/boards/Boards/brd/Original 4x4.brd"), Paths.get("Boards/brd/Original 4x4.brd"), REPLACE_EXISTING);
            Files.copy(getClass().getResourceAsStream("/kenken/boards/Boards/info/Original 4x4.inf"), Paths.get("Boards/info/Original 4x4.inf"), REPLACE_EXISTING);
            
            Files.copy(getClass().getResourceAsStream("/kenken/boards/Boards/brd/Original3x3.brd"), Paths.get("Boards/brd/Original 3x3.brd"), REPLACE_EXISTING);
            Files.copy(getClass().getResourceAsStream("/kenken/boards/Boards/info/Original3x3.inf"), Paths.get("Boards/info/Original 3x3.inf"), REPLACE_EXISTING);

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter of Creator Controller.
     *
     * @return The creator controller.
     */
    public CreatorController getCreatorController() {
        return cc;
    }

    /**
     * Getter of Board Controller.
     *
     * @return The Board controller.
     */
    public BoardController getBoardController() {
        return bc;
    }

    /**
     * Getter of Game Controller.
     *
     * @return The Game controller.
     */
    public GameController getGameController() {
        return gc;
    }

    /**
     * Getter of Ranking Controller.
     *
     * @return The ranking controller.
     */
    public RankingController getRankingController() {
        return rc;
    }

    /**
     * Getter of user Controller.
     *
     * @return The user controller.
     */
    public UserControllerKenken getUserController() {
        return uc;
    }

    /**
     * Getter of UserDataGetter.
     *
     * @return The UserDataGetter.
     */
    public UserDataGetter getUserDataGetter() {
        return dg;
    }

    public int login(String username, String password) {
        return uc.login(username, password);
    }

    enum Panels {

        CreateBoardPanel,
        ExportBoardPanel,
        MainMenuPanel,
        EndGamePanel,
        GenerateBoardPanel,
        NewGamePanel,
        PlayPanel,
        LoadBoardPanel,
        LoadGamePanel,
        RankingPanel,
        RegisterPanel,
        LoginPanel,
        OptionsPanel,
        ChooseRankingPanel,
        DeleteBoardPanel,
        CreatePanel,
        GuestPanel;

        public static String[] getStrings() {
            int length = Panels.values().length;
            String[] ss = new String[length];

            for (int i = 0; i < length; i++) {
                ss[i] = Panels.values()[i].name();
            }

            return ss;
        }
    };

    /**
     * Resets User Controller with a new one.
     */
    public void resetUserController() {
        this.uc = new UserControllerKenken();
    }

    /**
     * Setter of Panels.
     *
     * @param p Sets the old panel with the panel p.
     */
    public void setPanel(Panels p) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, p.name());
    }

    /**
     * Getter of panel name.
     *
     * @param p The panel whose want to get the name.
     * @return The JPanel wanted.
     */
    public JPanel getPanel(Panels p) {
        return panels.get(p.name());
    }

    /**
     * Create all the panels existing in the program.
     */
    private void createPanels() {
        panels.put("LoginPanel", new LoginPanel(this));
        panels.put("CreateBoardPanel", new CreateBoardPanel(this));
        panels.put("ExportBoardPanel", new ExportBoardPanel(this));
        panels.put("MainMenuPanel", new MainMenuPanel(this));
        panels.put("EndGamePanel", new EndGamePanel(this));
        panels.put("GenerateBoardPanel", new GenerateBoardPanel(this));
        panels.put("NewGamePanel", new NewGamePanel(this));
        panels.put("PlayPanel", new PlayPanel(this));
        panels.put("LoadBoardPanel", new LoadBoardPanel(this));
        panels.put("LoadGamePanel", new LoadGamePanel(this));
        panels.put("RankingPanel", new RankingPanel(this));
        panels.put("RegisterPanel", new RegisterPanel(this));
        panels.put("OptionsPanel", new OptionsPanel(this));
        panels.put("ChooseRankingPanel", new ChooseRankingPanel(this));
        panels.put("DeleteBoardPanel", new DeleteBoardPanel(this));
        panels.put("CreatePanel", new CreatePanel(this));
        panels.put("GuestPanel", new GuestPanel(this));
    }

    /**
     * Adds every panel existing in the CardPanel
     */
    private void addPanelsToCardPanel() {
        for (Entry<String, JPanel> e : panels.entrySet()) {
            cards.add(e.getKey(), e.getValue());
        }
    }

    /**
     * Adds components to the pane.
     *
     * @param pane The pane to be filled.
     */
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout

        //Create the "cards".
        createPanels();

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());

        // Add the panels to the panel with de cardlayout.
        addPanelsToCardPanel();

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PlayPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MainWindow demo = new MainWindow();
        demo.addComponentToPane(frame.getContentPane());
        demo.setPanel(Panels.LoginPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
