package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {

    private JPanel panelMain;
    private JButton buttonPlay;
    private JButton buttonSettings;
    private JButton buttonCredits;
    private JButton buttonExit;

    private JFrame homeScreenFrame;

    public HomeScreen() {
        CreateUIElements();
        ActionListener();
    }

    private void CreateUIElements() {
        homeScreenFrame = new JFrame("KUVID GAME");
        homeScreenFrame.setContentPane(panelMain);
        homeScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeScreenFrame.setVisible(true);
        homeScreenFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        homeScreenFrame.setResizable(false);
    }

    private void ActionListener() {
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[2];
                options[0] = "Create a new game";
                options[1] = "Load a game";
                int result = JOptionPane.showOptionDialog(null, "Do you want to create a new game or continue on an existing game?", "", 0, JOptionPane.PLAIN_MESSAGE, null, options, null);
                if (result == 0) {
                    CloseHomeScreen();
                    new ConfigureScreen();
                } else {
                    // LOAD WINDOW
                }
            }
        });

        buttonSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingsWindow();
            }
        });

        buttonCredits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(-1);
                }
            }
        });
    }

    private void CloseHomeScreen() {
        homeScreenFrame.dispose();
    }
}
