package UI;


import Domain.DomainControl.GameController;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveWindow {
    private JFrame frame;

    private JPanel panelMain;

    private JPanel panelMenu;
    private JButton buttonBack;

    private JScrollPane scrollPane;
    private JPanel panelSavedGame;
    private JPanel infoPanel;
    private JTextPane textAreaGameTitle;
    private JTextPane textAreaUsername;
    private JTextPane textAreaScore;
    private JTextPane textAreaTime;
    private JTextPane textAreaHealth;
    private JButton buttonSaveNewGame;

    public SaveWindow() {
        CreateUIElements();
        ActionListener();
    }

    private void CreateUIElements() {
        frame = new JFrame();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        //frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setUndecorated(true);

        panelMain = new JPanel(new BorderLayout());

        AddTitle(); // to panelMain
        AddMenu(); // to panelMain
        AddSavedGamePanel(); // to panelMain

        frame.setContentPane(panelMain);
        frame.setVisible(true);
        CenterFrame(frame);
    }

    private void AddTitle() {
        JTextPane title = new JTextPane();
        title.setText("SAVE GAME");
        title.setFont(ScreenInfo.titleFont);
        title.setEditable(false);

        SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        title.setParagraphAttributes(right, false);

        panelMain.add(title, BorderLayout.NORTH);
        title.setMargin(new Insets(ScreenInfo.titleFont.getSize()/2, 0, ScreenInfo.titleFont.getSize()/2, ScreenInfo.titleFont.getSize()));
    }

    private void AddMenu() {
        buttonBack.setFont(ScreenInfo.buttonFont);
        buttonBack.setMargin(new Insets(0, ScreenInfo.buttonFont.getSize(), 0, ScreenInfo.buttonFont.getSize()));
        panelMain.add(panelMenu, BorderLayout.WEST);
    }

    private void AddSavedGamePanel() {
        panelSavedGame = new JPanel();
        //BoxLayout boxLayout = new BoxLayout(panelLoad, BoxLayout.PAGE_AXIS);
        //panelLoad.setLayout(boxLayout);

        panelSavedGame.add(buttonSaveNewGame);
        buttonSaveNewGame.setFont(ScreenInfo.buttonFont);
        buttonSaveNewGame.setBackground(ScreenInfo.buttonBackgroundColor);

        scrollPane = new JScrollPane(panelSavedGame);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        panelMain.add(scrollPane);
    }

    private void ActionListener() {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CloseSaveWindow();
            }
        });

        buttonSaveNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textFieldTitle = new JTextField(10);
                JTextField textFieldUsername = new JTextField(10);

                JPanel myPanel = new JPanel(new GridLayout(2, 2));

                JLabel labelTitle = new JLabel("Game Title: ");
                labelTitle.setHorizontalAlignment(SwingConstants.RIGHT);
                myPanel.add(labelTitle, 0);
                myPanel.add(textFieldTitle, 1);

                JLabel labelUsername = new JLabel("Username: ");
                labelUsername.setHorizontalAlignment(SwingConstants.RIGHT);
                myPanel.add(labelUsername, 2);
                myPanel.add(textFieldUsername, 3);

                String[] options = new String[1];
                options[0] = "Save Game";

                int result = JOptionPane.showOptionDialog(null, myPanel,
                        "", 0, JOptionPane.PLAIN_MESSAGE, null, options, null);

                if (result == 0) {
                    // SAVE GAME
                    SaveGame(textFieldTitle.getText(), textFieldUsername.getText());
                    CloseSaveWindow();
                }
            }
        });
    }

    private void SaveGame(String saveTitle, String username) {

        GameController.getInstance().SaveGameData(saveTitle,username);

    }

    private void CenterFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (dim.width - frame.getSize().width) / 2;
        int y = (dim.height - frame.getSize().height) / 2;

        frame.setLocation(x, y);
    }

    public void CloseSaveWindow() {
        frame.dispose();
    }
}
