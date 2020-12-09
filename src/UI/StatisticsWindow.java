package UI;

import Domain.Statistics.GameData;

import Domain.Statistics.StaticWindowListener;
import Domain.Useful.FinalValues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class StatisticsWindow extends JLabel implements StaticWindowListener {
    private JPanel panelMain;

    private JPanel panelGameInfo;
    private JTextArea textAreaStaticScore;
    private JTextArea textAreaStaticTime;
    private JTextArea textAreaStaticHealth;

    private JPanel panelPowerupInfo;
    private JButton powerupSigma;
    private JTextArea textAreaSigmaPowerupAmount;
    private JButton powerupBeta;
    private JTextArea textAreaBetaPowerupAmount;
    private JButton powerupAlpha;
    private JTextArea textAreaAlphaPowerupAmount;
    private JButton powerupGamma;
    private JTextArea textAreaGammaPowerupAmount;

    private JPanel panelAtomInfo;
    private JLabel blendIcon;
    private JLabel atomIconAlpha;
    private JTextArea textAreaAlphaAtomAmount;
    private JLabel atomIconGamma;
    private JTextArea textAreaGammaAtomAmount;
    private JLabel atomIconSigma;
    private JTextArea textAreaSigmaAtomAmount;
    private JLabel atomIconBeta;
    private JTextArea textAreaBetaAtomAmount;
    private JTextArea textAreaScore;
    private JTextArea textAreaTime;
    private JTextArea textAreaHealth;

    public StatisticsWindow(int width, int height){
        CreateUIElements(width, height);
        SetPowerupIcons();
        SetAtomIcons();
        ActionListener();
    }

    private void CreateUIElements(int width, int height) {
        JFrame frame = new JFrame();
        frame.setContentPane(panelMain);
        frame.setSize(width, height);

        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocation(width*4,50);
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

    private void SetAtomIcons(){
        ImageIcon alphaIcon = new ImageIcon("./assets/atoms/alpha.png");
        Image newAlphaIcon = alphaIcon.getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        atomIconAlpha.setIcon(new ImageIcon(newAlphaIcon));

        ImageIcon gammaIcon = new ImageIcon("./assets/atoms/gamma.png");
        Image newGammaIcon = gammaIcon.getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        atomIconGamma.setIcon(new ImageIcon(newGammaIcon));

        ImageIcon sigmaIcon = new ImageIcon("./assets/atoms/sigma.png");
        Image newSigmaIcon = sigmaIcon.getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        atomIconSigma.setIcon(new ImageIcon(newSigmaIcon));

        ImageIcon betaIcon = new ImageIcon("./assets/atoms/beta.png");
        Image newBetaIcon = betaIcon.getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        atomIconBeta.setIcon(new ImageIcon(newBetaIcon));

        ImageIcon blendIconLocal = new ImageIcon("./assets/mixer.png");
        Image newBlendIcon = blendIconLocal.getImage().getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH);
        blendIcon.setIcon(new ImageIcon(newBlendIcon));
    }

    public void SetData(GameData gameData){
        textAreaScore.setText(String.valueOf(gameData.getScore()));
        textAreaTime.setText(String.valueOf(gameData.getRemainingTime()));
        textAreaHealth.setText(String.valueOf(gameData.getHealth()));

        textAreaAlphaPowerupAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.POWERUP).get(FinalValues.ALPHA)));
        textAreaBetaPowerupAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.POWERUP).get(FinalValues.BETA)));
        textAreaGammaPowerupAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.POWERUP).get(FinalValues.GAMMA)));
        textAreaSigmaPowerupAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.POWERUP).get(FinalValues.SIGMA)));

        textAreaAlphaAtomAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.ATOM).get(FinalValues.ALPHA)));
        textAreaBetaAtomAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.ATOM).get(FinalValues.BETA)));
        textAreaGammaAtomAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.ATOM).get(FinalValues.GAMMA)));
        textAreaSigmaAtomAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.ATOM).get(FinalValues.SIGMA)));
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

    @Override
    public void onTimeChange(double time) {
        textAreaStaticTime.setText(String.valueOf(time));
    }

    @Override
    public void onHealthChange(double health) {
        textAreaStaticHealth.setText(String.valueOf(health));
    }

    @Override
    public void onScoreChange(double score) {
        textAreaStaticHealth.setText(String.valueOf(score));
    }

    @Override
    public void onAmmunitionChange(HashMap<String, HashMap<String, Integer>> map) {
        textAreaAlphaPowerupAmount.setText(String.valueOf(map.get("powerup").get("alpha")));
        textAreaBetaPowerupAmount.setText(String.valueOf(map.get("powerup").get("beta")));
        textAreaGammaPowerupAmount.setText(String.valueOf(map.get("powerup").get("gamma")));
        textAreaSigmaPowerupAmount.setText(String.valueOf(map.get("powerup").get("sigma")));

        textAreaAlphaAtomAmount.setText(String.valueOf(map.get("atom").get("alpha")));
        textAreaBetaAtomAmount.setText(String.valueOf(map.get("atom").get("beta")));
        textAreaGammaAtomAmount.setText(String.valueOf(map.get("atom").get("gamma")));
        textAreaSigmaAtomAmount.setText(String.valueOf(map.get("atom").get("sigma")));
    }
}