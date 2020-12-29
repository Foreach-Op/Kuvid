package UI;

import Domain.Statistics.GameData;

import Domain.Statistics.StaticWindowListener;
import Domain.Utils.FinalValues;

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
    private JButton powerupAlpha;
    private JTextArea textAreaAlphaPowerupAmount;
    private JButton powerupBeta;
    private JTextArea textAreaBetaPowerupAmount;
    private JButton powerupGamma;
    private JTextArea textAreaGammaPowerupAmount;
    private JButton powerupSigma;
    private JTextArea textAreaSigmaPowerupAmount;

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
    private JButton buttonEtaShield;
    private JTextArea textAreaEtaShieldAmount;
    private JButton buttonLotaShield;
    private JButton buttonThetaShield;
    private JButton buttonZetaShield;
    private JTextArea textAreaLotaShieldAmount;
    private JTextArea textAreaThetaShieldAmount;
    private JTextArea textAreaZetaShieldAmount;

    private int width;
    private int height;

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
        panelMain.setOpaque(true);

        panelMain.add(panelGameInfo);
        panelGameInfo.setPreferredSize(new Dimension(width-10, ScreenInfo.textFont.getSize()*5));

        panelMain.add(panelPowerupInfo);
        panelPowerupInfo.setPreferredSize(new Dimension(width-10, height*3/9));

        panelMain.add(panelAtomInfo);
        panelAtomInfo.setPreferredSize(new Dimension(width-10, height*4/9));

        panelMain.setVisible(true);
    }

    private void SetFonts(){
        textAreaStaticScore.setFont(ScreenInfo.textFont);
        textAreaScore.setFont(ScreenInfo.textFont);

        textAreaTime.setFont(ScreenInfo.textFont);
        textAreaStaticTime.setFont(ScreenInfo.textFont);

        textAreaHealth.setFont(ScreenInfo.textFont);
        textAreaStaticHealth.setFont(ScreenInfo.textFont);

        textAreaAlphaPowerupAmount.setFont(ScreenInfo.textFont);
        textAreaBetaPowerupAmount.setFont(ScreenInfo.textFont);
        textAreaGammaPowerupAmount.setFont(ScreenInfo.textFont);
        textAreaSigmaPowerupAmount.setFont(ScreenInfo.textFont);

        buttonEtaShield.setFont(ScreenInfo.textFont);
        buttonEtaShield.setBackground(ScreenInfo.buttonBackgroundColor);
        textAreaEtaShieldAmount.setFont(ScreenInfo.textFont);

        textAreaLotaShieldAmount.setFont(ScreenInfo.textFont);
        buttonLotaShield.setBackground(ScreenInfo.buttonBackgroundColor);
        buttonLotaShield.setFont(ScreenInfo.textFont);

        textAreaThetaShieldAmount.setFont(ScreenInfo.textFont);
        buttonThetaShield.setBackground(ScreenInfo.buttonBackgroundColor);
        buttonThetaShield.setFont(ScreenInfo.textFont);

        textAreaZetaShieldAmount.setFont(ScreenInfo.textFont);
        buttonZetaShield.setBackground(ScreenInfo.buttonBackgroundColor);
        buttonZetaShield.setFont(ScreenInfo.textFont);

        textAreaAlphaAtomAmount.setFont(ScreenInfo.textFont);
        textAreaBetaAtomAmount.setFont(ScreenInfo.textFont);
        textAreaGammaAtomAmount.setFont(ScreenInfo.textFont);
        textAreaSigmaAtomAmount.setFont(ScreenInfo.textFont);
    }

    private void SetPowerupIcons(){
        int iconHeight = height/15;

        ImageIcon alphaIcon = new ImageIcon("./assets/Powerups/Alpha.png");
        Image newAlphaIcon = alphaIcon.getImage().getScaledInstance(65, iconHeight,  java.awt.Image.SCALE_SMOOTH);
        powerupAlpha.setIcon(new ImageIcon(newAlphaIcon));
        powerupAlpha.setPreferredSize(new Dimension(iconHeight, iconHeight));

        ImageIcon betaIcon = new ImageIcon("./assets/Powerups/Beta.png");
        Image newBetaIcon = betaIcon.getImage().getScaledInstance(iconHeight, iconHeight,  java.awt.Image.SCALE_SMOOTH);
        powerupBeta.setIcon(new ImageIcon(newBetaIcon));
        powerupBeta.setPreferredSize(new Dimension(iconHeight, iconHeight));

        ImageIcon gammaIcon = new ImageIcon("./assets/Powerups/Gamma.png");
        Image newGammaIcon = gammaIcon.getImage().getScaledInstance(32, iconHeight,  java.awt.Image.SCALE_SMOOTH);
        powerupGamma.setIcon(new ImageIcon(newGammaIcon));
        powerupGamma.setPreferredSize(new Dimension(iconHeight, iconHeight));

        ImageIcon sigmaIcon = new ImageIcon("./assets/Powerups/Sigma.png");
        Image newSigmaIcon = sigmaIcon.getImage().getScaledInstance((int) (iconHeight*0.76), iconHeight,  java.awt.Image.SCALE_SMOOTH);
        powerupSigma.setIcon(new ImageIcon(newSigmaIcon));
        powerupSigma.setPreferredSize(new Dimension(iconHeight, iconHeight));
    }

    private void SetAtomIcons(){
        int atomHeight = height/20;
        ImageIcon alphaIcon = new ImageIcon("./assets/Atoms/Alpha.png");
        Image newAlphaIcon = alphaIcon.getImage().getScaledInstance(atomHeight, atomHeight,  java.awt.Image.SCALE_SMOOTH);
        atomIconAlpha.setIcon(new ImageIcon(newAlphaIcon));
        atomIconAlpha.setPreferredSize(new Dimension(atomHeight, atomHeight));

        ImageIcon betaIcon = new ImageIcon("./assets/Atoms/Beta.png");
        Image newBetaIcon = betaIcon.getImage().getScaledInstance(atomHeight, atomHeight,  java.awt.Image.SCALE_SMOOTH);
        atomIconBeta.setIcon(new ImageIcon(newBetaIcon));
        atomIconBeta.setPreferredSize(new Dimension(atomHeight, atomHeight));

        ImageIcon gammaIcon = new ImageIcon("./assets/Atoms/Gamma.png");
        Image newGammaIcon = gammaIcon.getImage().getScaledInstance(atomHeight, atomHeight,  java.awt.Image.SCALE_SMOOTH);
        atomIconGamma.setIcon(new ImageIcon(newGammaIcon));
        atomIconGamma.setPreferredSize(new Dimension(atomHeight, atomHeight));

        ImageIcon sigmaIcon = new ImageIcon("./assets/Atoms/Sigma.png");
        Image newSigmaIcon = sigmaIcon.getImage().getScaledInstance(atomHeight, atomHeight,  java.awt.Image.SCALE_SMOOTH);
        atomIconSigma.setIcon(new ImageIcon(newSigmaIcon));
        atomIconSigma.setPreferredSize(new Dimension(atomHeight, atomHeight));

        ImageIcon blendIconLocal = new ImageIcon("./Assets/mixer.png");
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

        textAreaEtaShieldAmount.setText(String.valueOf(gameData.getRemainingShield().get(FinalValues.ETA)));
        textAreaLotaShieldAmount.setText(String.valueOf(gameData.getRemainingShield().get(FinalValues.LOTA)));
        textAreaThetaShieldAmount.setText(String.valueOf(gameData.getRemainingShield().get(FinalValues.THETA)));
        textAreaZetaShieldAmount.setText(String.valueOf(gameData.getRemainingShield().get(FinalValues.ZETA)));

        textAreaAlphaAtomAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.ATOM).get(FinalValues.ALPHA)));
        textAreaBetaAtomAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.ATOM).get(FinalValues.BETA)));
        textAreaGammaAtomAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.ATOM).get(FinalValues.GAMMA)));
        textAreaSigmaAtomAmount.setText(String.valueOf(gameData.getAmmunition().get(FinalValues.ATOM).get(FinalValues.SIGMA)));
    }

    private void ActionListener(){
        powerupSigma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Alpha selected");
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
                System.out.println("Gamma selected");
            }
        });
        powerupGamma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sigma selected");
            }
        });
        buttonEtaShield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonLotaShield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonThetaShield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZetaShield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        textAreaAlphaPowerupAmount.setText(String.valueOf(map.get(FinalValues.POWERUP).get(FinalValues.ALPHA)));
        textAreaBetaPowerupAmount.setText(String.valueOf(map.get(FinalValues.POWERUP).get(FinalValues.BETA)));
        textAreaGammaPowerupAmount.setText(String.valueOf(map.get(FinalValues.POWERUP).get(FinalValues.GAMMA)));
        textAreaSigmaPowerupAmount.setText(String.valueOf(map.get(FinalValues.POWERUP).get(FinalValues.SIGMA)));

        textAreaAlphaAtomAmount.setText(String.valueOf(map.get(FinalValues.ATOM).get(FinalValues.ALPHA)));
        textAreaBetaAtomAmount.setText(String.valueOf(map.get(FinalValues.ATOM).get(FinalValues.BETA)));
        textAreaGammaAtomAmount.setText(String.valueOf(map.get(FinalValues.ATOM).get(FinalValues.GAMMA)));
        textAreaSigmaAtomAmount.setText(String.valueOf(map.get(FinalValues.ATOM).get(FinalValues.SIGMA)));
    }

    @Override
    public void shieldChangeListener(HashMap<String, Integer> remainingShields) {
        textAreaEtaShieldAmount.setText(String.valueOf(remainingShields.get(FinalValues.ETA)));
        textAreaLotaShieldAmount.setText(String.valueOf(remainingShields.get(FinalValues.LOTA)));
        textAreaThetaShieldAmount.setText(String.valueOf(remainingShields.get(FinalValues.THETA)));
        textAreaZetaShieldAmount.setText(String.valueOf(remainingShields.get(FinalValues.ZETA)));
    }
}