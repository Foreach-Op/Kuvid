package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {

    UIController uiController;

    private JPanel panelMain;
    private JButton buttonPlay;
    private JButton buttonOptions;
    private JButton buttonCredits;
    private JButton buttonExit;

    private JFrame homeScreenFrame;

    public HomeScreen() {
        uiController = UIController.GetInstance();
        CreateUIElements();
        ActionListener();
    }

    private void CreateUIElements() {
        homeScreenFrame = new JFrame();
        homeScreenFrame.setContentPane(panelMain);
        homeScreenFrame.setSize(ScreenInfo.WINDOW_WIDTH, ScreenInfo.WINDOW_HEIGHT);
        homeScreenFrame.setResizable(false);
        homeScreenFrame.setUndecorated(true);
        homeScreenFrame.setVisible(true);

        buttonPlay.setFont(ScreenInfo.buttonFont);
        buttonPlay.setBackground(ScreenInfo.buttonBackgroundColor);
        buttonPlay.setForeground(ScreenInfo.buttonTextColor);
        buttonPlay.setBorderPainted(false);

        buttonOptions.setFont(ScreenInfo.buttonFont);
        buttonOptions.setBackground(ScreenInfo.buttonBackgroundColor);
        buttonOptions.setForeground(ScreenInfo.buttonTextColor);
        buttonOptions.setBorderPainted(false);

        buttonCredits.setFont(ScreenInfo.buttonFont);
        buttonCredits.setBackground(ScreenInfo.buttonBackgroundColor);
        buttonCredits.setForeground(ScreenInfo.buttonTextColor);
        buttonCredits.setBorderPainted(false);

        buttonExit.setFont(ScreenInfo.buttonFont);
        buttonExit.setBackground(ScreenInfo.buttonBackgroundColor);
        buttonExit.setForeground(ScreenInfo.buttonTextColor);
        buttonExit.setBorderPainted(false);
    }

    @SuppressWarnings("Convert2Lambda")
    private void ActionListener() {
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[2];
                options[0] = "Create a new game";
                options[1] = "Load a game";
                int result = JOptionPane.showOptionDialog(null, "Do you want to create a new game or continue on an existing game?",
                        "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                if (result == 0) {
                    CloseHomeScreen();
                    uiController.openConfigureScreen();
                } else if (result == 1){
                    CloseHomeScreen();
                    uiController.openLoadWindow();
                }
            }
        });

        buttonOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uiController.openOptionsWindow();
            }
        });

        buttonCredits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uiController.openCreditsWindow();
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game?",
                        "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
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
