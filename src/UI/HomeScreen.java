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
        Initialize();
        ActionListener();
    }

    private void Initialize(){
        homeScreenFrame= new JFrame("KUVID GAME");
        homeScreenFrame.setContentPane(panelMain);
        homeScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeScreenFrame.pack();
        homeScreenFrame.setVisible(true);
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        homeScreenFrame.setSize(1920, 1080);
        homeScreenFrame.setResizable(false);
        CenterFrame(homeScreenFrame);
    }

    private void ActionListener(){
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CloseHomeScreen();
                new ConfigureScreen2();
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

    private void CenterFrame(JFrame frame){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (dim.width - frame.getSize().width) / 2;
        int y = (dim.height - frame.getSize().height) / 2;

        frame.setLocation(x, y);
    }

    private void CloseHomeScreen(){
        homeScreenFrame.dispose();
    }
}
