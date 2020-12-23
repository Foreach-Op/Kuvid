package UI;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SaveWindow {
    private JFrame frame;

    private JPanel panelMain;

    private JPanel panelMenu;
    private JButton buttonBack;

    private JScrollPane scrollPane;
    private JPanel panelLoad;
    private JPanel infoPanel;
    private JTextPane textAreaGameTitle;
    private JTextPane textAreaUsername;
    private JTextPane textAreaScore;
    private JTextPane textAreaTime;
    private JTextPane textAreaHealth;
    private JButton buttonSaveNewGame;

    private Font titleFont = new Font("Text Me One", Font.PLAIN, 72);
    private Font buttonFont = new Font("Text Me One", Font.PLAIN, 48);
    private Font font = new Font("Text Me One", Font.PLAIN, 36);

    private int buttonIndex = 0;

    public SaveWindow() {
        CreateUIElements();
        ActionListener();
    }

    private void CreateUIElements() {
        frame = new JFrame();
        //loadFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setUndecorated(true);

        panelMain = new JPanel(new BorderLayout());

        AddTitle();
        AddMenu();
        AddLoadPanel();

        frame.setContentPane(panelMain);
        frame.setVisible(true);
        CenterFrame(frame);
    }

    private void AddTitle() {
        JTextPane title = new JTextPane();
        title.setText("SAVE GAME");
        title.setFont(titleFont);
        title.setEditable(false);

        SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        title.setParagraphAttributes(right, false);

        panelMain.add(title, BorderLayout.NORTH);
        title.setMargin(new Insets(20, 0, 20, 50));
    }

    private void AddMenu() {
        buttonBack.setFont(buttonFont);
        buttonBack.setMargin(new Insets(0, 50, 0, 50));
        panelMain.add(panelMenu, BorderLayout.WEST);
    }

    private void AddLoadPanel() {
        panelLoad = new JPanel();
        //BoxLayout boxLayout = new BoxLayout(panelLoad, BoxLayout.PAGE_AXIS);
        //panelLoad.setLayout(boxLayout);

        panelLoad.add(buttonSaveNewGame);
        buttonSaveNewGame.setFont(ScreenInfo.buttonFont);
        buttonSaveNewGame.setBackground(Color.GRAY);

        scrollPane = new JScrollPane(panelLoad);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        panelMain.add(scrollPane);
    }

    private void AddNewSaveGameArea(){
        JButton buttonSaveNewGame = new JButton("SAVE GAME");
        buttonSaveNewGame.setFont(buttonFont);
        buttonSaveNewGame.setBackground(Color.RED);
        buttonSaveNewGame.setBorderPainted(false);
        panelLoad.add(buttonSaveNewGame);
        panelLoad.add(Box.createRigidArea(new Dimension(0, 20)));

        buttonSaveNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textFieldTitle = new JTextField(10);
                JTextField textFieldUsername = new JTextField(10);

                JPanel myPanel = new JPanel(new GridLayout(2,2));

                JLabel labelTitle = new JLabel("Game Title: ");
                labelTitle.setHorizontalAlignment(SwingConstants.RIGHT);
                myPanel.add(labelTitle,0);
                myPanel.add(textFieldTitle,1);

                JLabel labelUsername = new JLabel("Username: ");
                labelUsername.setHorizontalAlignment(SwingConstants.RIGHT);
                myPanel.add(labelUsername,2);
                myPanel.add(textFieldUsername,3);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    System.out.println("Game Title: " + textFieldTitle.getText());
                    System.out.println("Username: " + textFieldUsername.getText());
                    // SAVE GAME
                    CloseSaveWindow();
                }
            }
        });
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

                JPanel myPanel = new JPanel(new GridLayout(2,2));

                JLabel labelTitle = new JLabel("Game Title: ");
                labelTitle.setHorizontalAlignment(SwingConstants.RIGHT);
                myPanel.add(labelTitle,0);
                myPanel.add(textFieldTitle,1);

                JLabel labelUsername = new JLabel("Username: ");
                labelUsername.setHorizontalAlignment(SwingConstants.RIGHT);
                myPanel.add(labelUsername,2);
                myPanel.add(textFieldUsername,3);

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
        try {
            File myObj = new File("./save_files/"+saveTitle + "_" + username + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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
