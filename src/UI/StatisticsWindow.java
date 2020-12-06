package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsWindow {

    private JPanel panelMain;
    private JPanel panelAtomInfo;
    private JPanel panelPowerupInfo;
    private JPanel panelGameInfo;
    private JTextArea textAreaScore;
    private JTextArea textAreaTime;
    private JTextArea textAreaHealth;
    private JButton powerupSigma;
    private JTextArea textAreaSigmaPowerupAmount;
    private JButton powerupBeta;
    private JButton powerupAlpha;
    private JButton powerupGamma;
    private JTextArea textAreaBetaPowerupAmount;
    private JTextArea textAreaAlphaPowerupAmount;
    private JTextArea textAreaGammaPowerupAmount;
    private JLabel atomIconAlpha;
    private JLabel atomIconGamma;
    private JLabel atomIconSigma;
    private JLabel atomIconBeta;
    private JTextArea textAreaAlphaAtomAmount;
    private JTextArea textAreaGammaAtomAmount;
    private JTextArea textAreaSigmaAtomAmount;
    private JTextArea textAreaBetaAtomAmount;
    private JLabel blendIcon;

    public StatisticsWindow(){
        CreateUIElements();
        SetPowerupIcons();
        ActionListener();
    }

    private void CreateUIElements() {
        JFrame frame = new JFrame("Game Configuration");
        frame.setContentPane(panelMain);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //frame.setSize(180, 720);
        // frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        frame.setResizable(false);
    }

    private void SetPowerupIcons(){
        ImageIcon sigmaIcon = new ImageIcon("./assets/powerups/+sigma-b.png");
        Image newSigmaIcon = sigmaIcon.getImage().getScaledInstance(38, 50,  java.awt.Image.SCALE_SMOOTH);
        powerupSigma.setIcon(new ImageIcon(newSigmaIcon));

        ImageIcon betaIcon = new ImageIcon("./assets/powerups/+beta-b.png");
        Image newBetaIcon = betaIcon.getImage().getScaledInstance(57, 50,  java.awt.Image.SCALE_SMOOTH);
        powerupBeta.setIcon(new ImageIcon(newBetaIcon));

        ImageIcon alphaIcon = new ImageIcon("./assets/powerups/+alpha-b.png");
        Image newAlphaIcon = alphaIcon.getImage().getScaledInstance(65, 50,  java.awt.Image.SCALE_SMOOTH);
        powerupAlpha.setIcon(new ImageIcon(newAlphaIcon));

        ImageIcon gammaIcon = new ImageIcon("./assets/powerups/+gamma-b.png");
        Image newGammaIcon = gammaIcon.getImage().getScaledInstance(32, 50,  java.awt.Image.SCALE_SMOOTH);
        powerupGamma.setIcon(new ImageIcon(newGammaIcon));
    }

    private void ActionListener(){
        powerupSigma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sigma selected");
            }
        });
        powerupBeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Beta selected");
            }
        });
        powerupAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Alpha selected");
            }
        });
        powerupGamma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gamma selected");
            }
        });
    }
}