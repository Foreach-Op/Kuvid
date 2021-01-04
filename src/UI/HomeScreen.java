package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {

    UIListener uiListener;

    private JPanel panelMain;
    private JButton buttonPlay;
    private JButton buttonOptions;
    private JButton buttonCredits;
    private JButton buttonExit;

    private JFrame homeScreenFrame;

    public HomeScreen() {
        uiListener = UIController.GetInstance();
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

        SetButtonType(buttonPlay);
        SetButtonType(buttonOptions);
        SetButtonType(buttonCredits);
        SetButtonType(buttonExit);
    }

    private void SetButtonType(JButton button){
        button.setFont(ScreenInfo.buttonFont);
        button.setBackground(ScreenInfo.buttonBackgroundColor);
        button.setForeground(ScreenInfo.buttonTextColor);
        button.setBorderPainted(false);
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
                    uiListener.onConfigureScreen();
                } else if (result == 1){
                    CloseHomeScreen();
                    uiListener.onLoadScreen();
                }
            }
        });

        buttonOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uiListener.onOptions();
            }
        });

        buttonCredits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uiListener.onCredits();
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
