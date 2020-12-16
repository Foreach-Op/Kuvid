package UI;

import javax.swing.*;
import java.awt.*;
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

    private JFrame settingsFrame;

    private Font titleFont = new Font("Text Me One", Font.PLAIN, 72);
    private Font buttonFont = new Font("Text Me One", Font.PLAIN, 48);
    private Font font = new Font("Text Me One", Font.PLAIN, 36);

    public SettingsWindow(){
        CreateUIElements();
        ActionListener();
    }
    private void CreateUIElements() {
        settingsFrame = new JFrame();

        settingsFrame.setContentPane(panelMain);
        settingsFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        settingsFrame.setResizable(false);
        settingsFrame.setUndecorated(true);
        settingsFrame.setVisible(true);

        CenterFrame(settingsFrame);

        textAreaTitle.setFont(titleFont);
        buttonSoundSettings.setFont(buttonFont);
        buttonControlSettings.setFont(buttonFont);
        buttonHotKeys.setFont(buttonFont);
        buttonBack.setFont(buttonFont);

        SetHotKeys();
    }

    private void SetHotKeys(){
        textAreaMoveRight.setFont(font);
        buttonMoveRight.setFont(font);

        textAreaMoveLeft.setFont(font);
        buttonMoveLeft.setFont(font);

        textAreaRotateRight.setFont(font);
        buttonRotateRight.setFont(font);

        textAreaRotateLeft.setFont(font);
        buttonRotateLeft.setFont(font);

        textAreaChangeAtom.setFont(font);
        buttonChangeAtom.setFont(font);

        textAreaShoot.setFont(font);
        buttonShoot.setFont(font);

        textAreaBlend.setFont(font);
        buttonBlend.setFont(font);

        textAreaAlphaAtom.setFont(font);
        buttonAlphaAtom.setFont(font);

        textAreaBetaAtom.setFont(font);
        buttonBetaAtom.setFont(font);

        textAreaGammaAtom.setFont(font);
        buttonGammaAtom.setFont(font);

        textAreaSigmaAtom.setFont(font);
        buttonSigmaAtom.setFont(font);

        textAreaPause.setFont(font);
        buttonPause.setFont(font);

        textAreaAlphaPowerup.setFont(font);
        buttonFirstAlphaPowerup.setFont(font);
        textAreaPlus1.setFont(font);
        buttonSecondAlphaPowerup.setFont(font);

        textAreaBetaPowerup.setFont(font);
        buttonFirstBetaPowerup.setFont(font);
        textAreaPlus2.setFont(font);
        buttonSecondBetaPowerup.setFont(font);

        textAreaGammaPowerup.setFont(font);
        buttonFirstGammaPowerup.setFont(font);
        textAreaPlus3.setFont(font);
        buttonSecondGammaPowerup.setFont(font);

        textAreaSigmaPowerup.setFont(font);
        buttonFirstSigmaPowerup.setFont(font);
        textAreaPlus4.setFont(font);
        buttonSecondSigmaPowerup.setFont(font);
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
                Close();
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

    private void CenterFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (dim.width - frame.getSize().width) / 2;
        int y = (dim.height - frame.getSize().height) / 2;

        frame.setLocation(x, y);
    }

    public void Close() {
        settingsFrame.dispose();
    }
}
