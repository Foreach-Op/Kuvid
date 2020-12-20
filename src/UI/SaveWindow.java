package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveWindow {
    private JPanel panelMain;

    private JTextArea textAreaTitle;

    private JPanel panelMenu;
    private JButton buttonBack;

    private JScrollPane scrollPane;
    private JPanel panelLoad;

    private JPanel savedGamePanel;
    private JButton button1;
    private JButton buttonloadGame;
    private JPanel infoPanel;
    private JTextArea textAreaUsername;
    private JTextArea textAreaGameTitle;
    private JTextArea textAreaScore;
    private JTextArea textAreaTime;
    private JTextArea textAreaHealth;
    private JPanel savedNewGamePanel;

    private JFrame loadFrame;

    private Font titleFont = new Font("Text Me One", Font.PLAIN, 72);
    private Font buttonFont = new Font("Text Me One", Font.PLAIN, 48);
    private Font font = new Font("Text Me One", Font.PLAIN, 36);

    public SaveWindow(){
        CreateUIElements();
        ActionListener();
    }

    private void CreateUIElements() {
        loadFrame = new JFrame();
        loadFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        loadFrame.setResizable(false);
        loadFrame.setUndecorated(true);
        loadFrame.setContentPane(panelMain);
        loadFrame.setVisible(true);

        CenterFrame(loadFrame);

        textAreaTitle.setFont(titleFont);
        buttonBack.setFont(buttonFont);

        SetSavedGameInfo();
    }

    private void SetSavedGameInfo() {
        textAreaGameTitle.setText("Game: " + "game1");
        textAreaGameTitle.setFont(font);

        textAreaUsername.setText("Username: " + "alperklnc");
        textAreaUsername.setFont(font);

        textAreaScore.setText("Score: " + String.valueOf(100));
        textAreaScore.setFont(font);

        textAreaTime.setText("Time: " + String.valueOf(25.2));
        textAreaTime.setFont(font);

        textAreaHealth.setText("Health: " + String.valueOf(50));
        textAreaHealth.setFont(font);

        buttonloadGame.setFont(buttonFont);
    }

    private void ActionListener() {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Close();
            }
        });

        buttonloadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to load this game?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    // LOAD GAME
                    Close();
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

    public void Close() {
        loadFrame.dispose();
    }
}
