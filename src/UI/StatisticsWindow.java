package UI;

import Domain.Statistics.GameData;

import Domain.Statistics.StaticWindowListener;
import Domain.Useful.FinalValues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class StatisticsWindow extends JPanel implements StaticWindowListener {
    public JPanel panelMain;

    private JPanel panelGameInfo;
    private JTextArea textAreaStaticScore;
    private JTextArea textAreaScore;
    private JTextArea textAreaStaticTime;
    private JTextArea textAreaTime;
    private JTextArea textAreaStaticHealth;
    private JTextArea textAreaHealth;

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

    private int width;
    private int height;

    private Font defaultFont = new Font("Arial", Font.PLAIN, 36);

    public StatisticsWindow(int width, int height) {
        this.width = width;
        this.height = height;
        CreateUIElements();
        SetPowerupIcons();
        SetAtomIcons();
        SetFonts();
        ActionListener();
    }

    private void CreateUIElements() {
        panelMain = new JPanel();
        panelMain.setBackground(Color.LIGHT_GRAY);

        panelMain.add(panelGameInfo);
        panelGameInfo.setPreferredSize(new Dimension(width-20, height/6));

        panelMain.add(panelPowerupInfo);
        panelPowerupInfo.setPreferredSize(new Dimension(width-20, height/3));

        panelMain.add(panelAtomInfo);
        panelAtomInfo.setPreferredSize(new Dimension(width-20, height/2));

        panelMain.setVisible(true);
    }

    private void SetFonts(){
        textAreaScore.setFont(defaultFont);
        textAreaTime.setFont(defaultFont);
        textAreaHealth.setFont(defaultFont);

        textAreaAlphaPowerupAmount.setFont(defaultFont);
        textAreaBetaPowerupAmount.setFont(defaultFont);
        textAreaGammaPowerupAmount.setFont(defaultFont);
        textAreaSigmaPowerupAmount.setFont(defaultFont);

        textAreaAlphaAtomAmount.setFont(defaultFont);
        textAreaBetaAtomAmount.setFont(defaultFont);
        textAreaGammaAtomAmount.setFont(defaultFont);
        textAreaSigmaAtomAmount.setFont(defaultFont);
    }

    private void SetPowerupIcons(){
        int iconHeight = height/15;

        ImageIcon sigmaIcon = new ImageIcon("./assets/powerups/+sigma-b.png");
        Image newSigmaIcon = sigmaIcon.getImage().getScaledInstance((int) (iconHeight*0.76), iconHeight,  java.awt.Image.SCALE_SMOOTH);
        powerupSigma.setIcon(new ImageIcon(newSigmaIcon));
        powerupSigma.setPreferredSize(new Dimension(iconHeight, iconHeight));

        ImageIcon betaIcon = new ImageIcon("./assets/powerups/+beta-b.png");
        Image newBetaIcon = betaIcon.getImage().getScaledInstance(iconHeight, iconHeight,  java.awt.Image.SCALE_SMOOTH);
        powerupBeta.setIcon(new ImageIcon(newBetaIcon));
        powerupBeta.setPreferredSize(new Dimension(iconHeight, iconHeight));

        ImageIcon alphaIcon = new ImageIcon("./assets/powerups/+alpha-b.png");
        Image newAlphaIcon = alphaIcon.getImage().getScaledInstance(65, iconHeight,  java.awt.Image.SCALE_SMOOTH);
        powerupAlpha.setIcon(new ImageIcon(newAlphaIcon));
        powerupAlpha.setPreferredSize(new Dimension(iconHeight, iconHeight));

        ImageIcon gammaIcon = new ImageIcon("./assets/powerups/+gamma-b.png");
        Image newGammaIcon = gammaIcon.getImage().getScaledInstance(32, iconHeight,  java.awt.Image.SCALE_SMOOTH);
        powerupGamma.setIcon(new ImageIcon(newGammaIcon));
        powerupGamma.setPreferredSize(new Dimension(iconHeight, iconHeight));
    }

    private void SetAtomIcons(){
        int atomHeight = height/20;
        ImageIcon alphaIcon = new ImageIcon("./assets/atoms/alpha.png");
        Image newAlphaIcon = alphaIcon.getImage().getScaledInstance(atomHeight, atomHeight,  java.awt.Image.SCALE_SMOOTH);
        atomIconAlpha.setIcon(new ImageIcon(newAlphaIcon));
        atomIconAlpha.setPreferredSize(new Dimension(atomHeight, atomHeight));

        ImageIcon betaIcon = new ImageIcon("./assets/atoms/beta.png");
        Image newBetaIcon = betaIcon.getImage().getScaledInstance(atomHeight, atomHeight,  java.awt.Image.SCALE_SMOOTH);
        atomIconBeta.setIcon(new ImageIcon(newBetaIcon));
        atomIconBeta.setPreferredSize(new Dimension(atomHeight, atomHeight));

        ImageIcon gammaIcon = new ImageIcon("./assets/atoms/gamma.png");
        Image newGammaIcon = gammaIcon.getImage().getScaledInstance(atomHeight, atomHeight,  java.awt.Image.SCALE_SMOOTH);
        atomIconGamma.setIcon(new ImageIcon(newGammaIcon));
        atomIconGamma.setPreferredSize(new Dimension(atomHeight, atomHeight));

        ImageIcon sigmaIcon = new ImageIcon("./assets/atoms/sigma.png");
        Image newSigmaIcon = sigmaIcon.getImage().getScaledInstance(atomHeight, atomHeight,  java.awt.Image.SCALE_SMOOTH);
        atomIconSigma.setIcon(new ImageIcon(newSigmaIcon));
        atomIconSigma.setPreferredSize(new Dimension(atomHeight, atomHeight));

        ImageIcon blendIconLocal = new ImageIcon("./assets/mixer.png");
        Image newBlendIcon = blendIconLocal.getImage().getScaledInstance(atomHeight*2, atomHeight*2,  java.awt.Image.SCALE_SMOOTH);
        blendIcon.setIcon(new ImageIcon(newBlendIcon));
        blendIcon.setPreferredSize(new Dimension(atomHeight*2, atomHeight*2));
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
        textAreaTime.setText(String.valueOf(time));
    }

    @Override
    public void onHealthChange(double health) {
        textAreaHealth.setText(String.valueOf(health));
    }

    @Override
    public void onScoreChange(double score) {
        textAreaScore.setText(String.valueOf(score));
    }

    @Override
    public void onAmmunitionChange(HashMap<String, HashMap<String, Integer>> map) {
        textAreaAlphaPowerupAmount.setText(String.valueOf(map.get(FinalValues.POWERUP).get(FinalValues.ATOM)));
        textAreaBetaPowerupAmount.setText(String.valueOf(map.get(FinalValues.POWERUP).get(FinalValues.BETA)));
        textAreaGammaPowerupAmount.setText(String.valueOf(map.get(FinalValues.POWERUP).get(FinalValues.GAMMA)));
        textAreaSigmaPowerupAmount.setText(String.valueOf(map.get(FinalValues.POWERUP).get(FinalValues.SIGMA)));

        textAreaAlphaAtomAmount.setText(String.valueOf(map.get(FinalValues.ATOM).get(FinalValues.ALPHA)));
        textAreaBetaAtomAmount.setText(String.valueOf(map.get(FinalValues.ATOM).get(FinalValues.BETA)));
        textAreaGammaAtomAmount.setText(String.valueOf(map.get(FinalValues.ATOM).get(FinalValues.GAMMA)));
        textAreaSigmaAtomAmount.setText(String.valueOf(map.get(FinalValues.ATOM).get(FinalValues.SIGMA)));
    }
}