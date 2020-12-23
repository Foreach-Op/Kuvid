package UI;

import Domain.DomainControl.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseWindow {

    private JTextArea textAreaTitle;
    private JPanel panelMain;
    private JButton buttonResume;
    private JButton buttonRestart;
    private JButton buttonSettings;
    private JButton buttonMainMenu;
    private JButton buttonExit;
    private JButton buttonSave;
    private JButton buttonLoad;

    private JFrame pauseFrame;

    private Font titleFont = new Font("Text Me One", Font.PLAIN, 48);
    private Font buttonFont = new Font("Text Me One", Font.PLAIN, 28);

    private GameController gameController;

    public PauseWindow(GameController gameController) {
        this.gameController = gameController;
        CreateUIElements();
        ActionListener();
    }

    private void CreateUIElements() {
        pauseFrame = new JFrame();
        panelMain.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 20));
        pauseFrame.setContentPane(panelMain);
        pauseFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 4, 600);
        pauseFrame.setResizable(false);
        pauseFrame.setUndecorated(true);
        pauseFrame.setVisible(true);

        CenterFrame(pauseFrame);

        textAreaTitle.setFont(titleFont);
        buttonResume.setFont(buttonFont);
        buttonSave.setFont(buttonFont);
        buttonLoad.setFont(buttonFont);
        buttonRestart.setFont(buttonFont);
        buttonSettings.setFont(buttonFont);
        buttonMainMenu.setFont(buttonFont);
        buttonExit.setFont(buttonFont);
    }

    private void ActionListener() {
        buttonResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.Resume();
                ClosePauseWindow();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveWindow();
            }
        });

        buttonLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadWindow();
            }
        });

        buttonRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to restart the game?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    // END GAME
                    // START GAME
                }
            }
        });

        buttonSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingsWindow();
            }
        });

        buttonMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    public void ClosePauseWindow() {
        pauseFrame.dispose();
    }
}
