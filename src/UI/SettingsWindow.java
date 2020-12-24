package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow {
    private JPanel panelMain;
    private JPanel panelMenu;
    private JPanel panelCardLayout;
    private JPanel panelSounds;
    private JPanel panelControls;
    private JPanel panelHotKeys;

    private JTextArea textAreaTitle;
    private JButton buttonSoundSettings;
    private JButton buttonControlSettings;
    private JButton buttonBack;
    private JButton buttonHotKeys;

    private JTextArea textAreaMoveRight;
    private JButton buttonMoveRight;
    private JTextArea textAreaPlus1;
    private JTextArea textAreaMoveLeft;
    private JTextArea textAreaRotateRight;
    private JTextArea textAreaRotateLeft;
    private JTextArea textAreaChangeAtom;
    private JTextArea textAreaShoot;
    private JTextArea textAreaBlend;
    private JTextArea textAreaAlphaAtom;
    private JTextArea textAreaBetaAtom;
    private JTextArea textAreaGammaAtom;
    private JTextArea textAreaSigmaAtom;
    private JTextArea textAreaPause;
    private JTextArea textAreaAlphaPowerup;
    private JTextArea textAreaBetaPowerup;
    private JTextArea textAreaGammaPowerup;
    private JTextArea textAreaSigmaPowerup;
    private JButton buttonMoveLeft;
    private JButton buttonRotateRight;
    private JButton buttonRotateLeft;
    private JButton buttonChangeAtom;
    private JButton buttonShoot;
    private JButton buttonBlend;
    private JButton buttonAlphaAtom;
    private JButton buttonBetaAtom;
    private JButton buttonGammaAtom;
    private JButton buttonSigmaAtom;
    private JButton buttonPause;
    private JTextArea textAreaPlus2;
    private JTextArea textAreaPlus3;
    private JTextArea textAreaPlus4;
    private JButton buttonSecondAlphaPowerup;
    private JButton buttonSecondBetaPowerup;
    private JButton buttonSecondGammaPowerup;
    private JButton buttonSecondSigmaPowerup;
    private JButton buttonFirstAlphaPowerup;
    private JButton buttonFirstBetaPowerup;
    private JButton buttonFirstGammaPowerup;
    private JButton buttonFirstSigmaPowerup;
    private JScrollPane scrollPane;
    private JSlider sliderMenuMusic;
    private JTextArea textAreaMenuMusic;
    private JSlider sliderMusicEffects;
    private JSlider sliderGameMusic;
    private JTextArea textAreaGameMusic;
    private JTextArea textAreaMusicEffects;

    private JFrame settingsFrame;

    public SettingsWindow(){
        CreateUIElements();
        ActionListener();
    }
    private void CreateUIElements() {
        settingsFrame = new JFrame();
        settingsFrame.setContentPane(panelMain);
        settingsFrame.setSize(ScreenInfo.WINDOW_WIDTH, ScreenInfo.WINDOW_HEIGHT);
        settingsFrame.setResizable(false);
        settingsFrame.setUndecorated(true);
        settingsFrame.setVisible(true);

        textAreaTitle.setFont(ScreenInfo.titleFont);
        buttonSoundSettings.setFont(ScreenInfo.buttonFont);
        buttonControlSettings.setFont(ScreenInfo.buttonFont);
        buttonHotKeys.setFont(ScreenInfo.buttonFont);
        buttonBack.setFont(ScreenInfo.buttonFont);

        scrollPane.getVerticalScrollBar().setUnitIncrement(ScreenInfo.SCROLL_INCREMENT_AMOUNT);

        SetHotKeys();
    }

    private void SetHotKeys(){
        textAreaMoveRight.setFont(ScreenInfo.textFont);
        buttonMoveRight.setFont(ScreenInfo.textFont);

        textAreaMoveLeft.setFont(ScreenInfo.textFont);
        buttonMoveLeft.setFont(ScreenInfo.textFont);

        textAreaRotateRight.setFont(ScreenInfo.textFont);
        buttonRotateRight.setFont(ScreenInfo.textFont);

        textAreaRotateLeft.setFont(ScreenInfo.textFont);
        buttonRotateLeft.setFont(ScreenInfo.textFont);

        textAreaChangeAtom.setFont(ScreenInfo.textFont);
        buttonChangeAtom.setFont(ScreenInfo.textFont);

        textAreaShoot.setFont(ScreenInfo.textFont);
        buttonShoot.setFont(ScreenInfo.textFont);

        textAreaBlend.setFont(ScreenInfo.textFont);
        buttonBlend.setFont(ScreenInfo.textFont);

        textAreaAlphaAtom.setFont(ScreenInfo.textFont);
        buttonAlphaAtom.setFont(ScreenInfo.textFont);

        textAreaBetaAtom.setFont(ScreenInfo.textFont);
        buttonBetaAtom.setFont(ScreenInfo.textFont);

        textAreaGammaAtom.setFont(ScreenInfo.textFont);
        buttonGammaAtom.setFont(ScreenInfo.textFont);

        textAreaSigmaAtom.setFont(ScreenInfo.textFont);
        buttonSigmaAtom.setFont(ScreenInfo.textFont);

        textAreaPause.setFont(ScreenInfo.textFont);
        buttonPause.setFont(ScreenInfo.textFont);

        textAreaAlphaPowerup.setFont(ScreenInfo.textFont);
        buttonFirstAlphaPowerup.setFont(ScreenInfo.textFont);
        textAreaPlus1.setFont(ScreenInfo.textFont);
        buttonSecondAlphaPowerup.setFont(ScreenInfo.textFont);

        textAreaBetaPowerup.setFont(ScreenInfo.textFont);
        buttonFirstBetaPowerup.setFont(ScreenInfo.textFont);
        textAreaPlus2.setFont(ScreenInfo.textFont);
        buttonSecondBetaPowerup.setFont(ScreenInfo.textFont);

        textAreaGammaPowerup.setFont(ScreenInfo.textFont);
        buttonFirstGammaPowerup.setFont(ScreenInfo.textFont);
        textAreaPlus3.setFont(ScreenInfo.textFont);
        buttonSecondGammaPowerup.setFont(ScreenInfo.textFont);

        textAreaSigmaPowerup.setFont(ScreenInfo.textFont);
        buttonFirstSigmaPowerup.setFont(ScreenInfo.textFont);
        textAreaPlus4.setFont(ScreenInfo.textFont);
        buttonSecondSigmaPowerup.setFont(ScreenInfo.textFont);
    }

    private void ActionListener() {
        buttonSoundSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSounds.show();
                panelControls.show(false);
                panelHotKeys.show(false);
            }
        });

        buttonControlSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControls.show();
                panelSounds.show(false);
                panelHotKeys.show(false);
            }
        });

        buttonHotKeys.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelHotKeys.show();
                panelSounds.show(false);
                panelControls.show(false);
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CloseSettingsWindow();
            }
        });

        buttonMoveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(settingsFrame,
                        "This feature does not provided yet. Please wait for updates.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void CloseSettingsWindow() {
        settingsFrame.dispose();
    }
}
