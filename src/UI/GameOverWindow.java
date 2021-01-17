package UI;

import Domain.DomainControl.GameController;
import UI.Audio.AudioController;
import UI.Audio.AudioListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverWindow {

    private GameController gameController;
    private UIController uiController;
    private AudioListener audioListener;

    private JTextArea textAreaTitle;
    private JPanel panelMain;

    private JButton buttonRestart;
    private JButton buttonMainMenu;
    private JButton buttonExit;

    private JTextArea textAreaScore;
    private JTextArea textAreaHighscore;

    private JFrame gameOverFrame;

    private Font titleFont = new Font("Text Me One", Font.PLAIN, 48);
    private Font buttonFont = new Font("Text Me One", Font.PLAIN, 28);

    public GameOverWindow(GameController gameController) {
        audioListener = AudioController.GetInstance();
        uiController = UIController.GetInstance();
        this.gameController = gameController;
        CreateUIElements();
        ActionListener();
    }

    private void CreateUIElements() {
        gameOverFrame = new JFrame();
        panelMain.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 20));
        gameOverFrame.setContentPane(panelMain);
        gameOverFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 4, 600);
        gameOverFrame.setResizable(false);
        gameOverFrame.setUndecorated(true);
        gameOverFrame.setVisible(true);

        CenterFrame(gameOverFrame);

        textAreaTitle.setFont(titleFont);
        textAreaScore.setFont(buttonFont);
        textAreaHighscore.setFont(buttonFont);

        buttonRestart.setFont(buttonFont);
        buttonMainMenu.setFont(buttonFont);
        buttonExit.setFont(buttonFont);
    }

    private void ActionListener() {
        buttonRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CloseGameOverWindow();
                uiController.restartNewGame();
            }
        });

        buttonMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                audioListener.onButtonClick();
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game and go back to main menu?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    // END GAME
                    // HOME SCREEN
                }
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                audioListener.onButtonClick();
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(-1);
                }
            }
        });
    }

    private void CenterFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (dim.width - frame.getSize().width) / 2;
        int y = (dim.height - frame.getSize().height) / 2;

        frame.setLocation(x, y);
    }

    public void CloseGameOverWindow() {
        gameOverFrame.dispose();
    }
}
