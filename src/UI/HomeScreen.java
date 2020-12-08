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
        homeScreenFrame.pack();
        homeScreenFrame.setVisible(true);
        homeScreenFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        homeScreenFrame.setResizable(false);
    }

    private void ActionListener() {
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CloseHomeScreen();
                new ConfigureScreen();
            }
        });

        buttonSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                System.exit(-1);
            }
        });
    }

    private void CloseHomeScreen() {
        homeScreenFrame.dispose();
    }
}
