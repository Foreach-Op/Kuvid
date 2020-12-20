package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

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
        BoxLayout boxLayout = new BoxLayout(panelLoad, BoxLayout.PAGE_AXIS);
        panelLoad.setLayout(boxLayout);

        HashMap<String, String> hash = new HashMap<>();
        hash.put("title", "Game 123");
        hash.put("username", "alperklnc");
        hash.put("score", "100");
        hash.put("time", "25.2");
        hash.put("health", "30");

        HashMap<String, String> hash2 = new HashMap<>();
        hash2.put("title", "debug");
        hash2.put("username", "debug");
        hash2.put("score", "debug");
        hash2.put("time", "debug");
        hash2.put("health", "debug");

        AddNewSaveGameArea();

        //AddSavedGameArea(hash, Color.CYAN);
        //AddSavedGameArea(hash2, Color.GREEN);

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
                    Close();
                }
            }
        });
    }

    private void AddSavedGameArea(HashMap<String, String> hash, Color color){
        JPanel panel = SetInfoPanel(hash);
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.setBackground(color);
        panelLoad.add(panel);
        panelLoad.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to save the game on this game? " + "index: " + buttonIndex, "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    // LOAD GAME
                    Close();
                }
            }
        });
    }

    private JPanel SetInfoPanel(HashMap<String, String> hash) {
        JPanel myInfoPanel = new JPanel(new GridLayout(2, 3));

        textAreaGameTitle = new JTextPane();
        textAreaGameTitle.setText("Game: " + hash.get("title"));
        textAreaGameTitle.setEditable(false);
        textAreaGameTitle.setFont(font);

        textAreaUsername = new JTextPane();
        textAreaUsername.setText("Username: " + hash.get("username"));
        textAreaUsername.setEditable(false);
        textAreaUsername.setFont(font);

        textAreaScore = new JTextPane();
        textAreaScore.setText("Score: " + hash.get("score"));
        textAreaScore.setEditable(false);
        textAreaScore.setFont(font);

        textAreaTime = new JTextPane();
        textAreaTime.setText("Time: " + hash.get("time"));
        textAreaTime.setEditable(false);
        textAreaTime.setFont(font);

        textAreaHealth = new JTextPane();
        textAreaHealth.setText("Health: " + hash.get("health"));
        textAreaHealth.setEditable(false);
        textAreaHealth.setFont(font);

        myInfoPanel.add(textAreaGameTitle, 0);
        myInfoPanel.add(textAreaUsername, 1);
        myInfoPanel.add(new JPanel(), 2); // DUMMY PANEL
        myInfoPanel.add(textAreaScore, 3);
        myInfoPanel.add(textAreaTime, 4);
        myInfoPanel.add(textAreaHealth, 5);

        return myInfoPanel;
    }

    private void ActionListener() {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Close();
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
        frame.dispose();
    }
}
