package UI;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.HashMap;

public class ConfigureScreen2 {

    public JPanel panelMain;

    private JFormattedTextField textFieldNumberOfAtoms;
    private JFormattedTextField textFieldNumberOfBlockers;
    private JFormattedTextField textFieldNumberOfMolecules;
    private JFormattedTextField textFieldNumberOfPowerups;

    private JPanel panelMoleculeStructure;
    private JRadioButton radioButtonLinear;
    private JRadioButton radioButtonTriangle;

    private JPanel panelMoleculeFallingType;
    private JRadioButton radioButtonStationary;
    private JRadioButton radioButtonSpinning;

    private JPanel panelGameDifficulty;
    private JRadioButton radioButtonEasy;
    private JRadioButton radioButtonMedium;
    private JRadioButton radioButtonHard;

    private JButton buttonStart;

    private JTextArea textAreaAtoms;
    private JTextArea textAreaBlockers;
    private JTextArea textAreaPowerups;
    private JTextArea textAreaMolecules;
    private JTextArea textAreaMoleculeStructure;
    private JTextArea textAreaMoleculeFallingType;
    private JTextArea textAreaDifficulty;
    private JPanel panelSelectionFields;

    private ButtonGroup structureGroup;
    private ButtonGroup fallingTypeGroup;
    private ButtonGroup gameDifficultyGroup;

    private HashMap<String, String> configurationInfo;

    public ConfigureScreen2() {
        configurationInfo = new HashMap<>();

        JFrame frame = new JFrame("Initial Settings");
        frame.setContentPane(panelMain);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(510, 400);
        frame.setResizable(false);
        CenterFrame(frame);

        InitializeRBGroups();
        ActionListener();
    }

    private void InitializeRBGroups() {
        structureGroup = new ButtonGroup();
        structureGroup.add(radioButtonLinear);
        structureGroup.add(radioButtonTriangle);
        radioButtonLinear.setSelected(true);

        fallingTypeGroup = new ButtonGroup();
        fallingTypeGroup.add(radioButtonStationary);
        fallingTypeGroup.add(radioButtonSpinning);
        radioButtonStationary.setSelected(true);

        gameDifficultyGroup = new ButtonGroup();
        gameDifficultyGroup.add(radioButtonEasy);
        gameDifficultyGroup.add(radioButtonMedium);
        gameDifficultyGroup.add(radioButtonHard);
        radioButtonMedium.setSelected(true);
    }

    private void ActionListener() {
        radioButtonLinear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButtonStationary.setEnabled(true);
                radioButtonSpinning.setEnabled(true);
            }
        });

        radioButtonTriangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButtonStationary.setEnabled(false);
                radioButtonSpinning.setEnabled(false);
            }
        });

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numberOfAtoms = Integer.parseUnsignedInt(textFieldNumberOfAtoms.getText());
                    configurationInfo.put("atom", textFieldNumberOfAtoms.getText());

                    int numberOfBlockers = Integer.parseUnsignedInt(textFieldNumberOfBlockers.getText());
                    configurationInfo.put("blocker", textFieldNumberOfBlockers.getText());

                    int numberOfPowerups = Integer.parseUnsignedInt(textFieldNumberOfPowerups.getText());
                    configurationInfo.put("powerup", textFieldNumberOfPowerups.getText());

                    int numberOfMolecules = Integer.parseUnsignedInt(textFieldNumberOfMolecules.getText());
                    configurationInfo.put("molecule", textFieldNumberOfMolecules.getText());

                    String moleculeStructure = new String();
                    String fallingType = new String();
                    String gameDifficulty = new String();

                    for (Enumeration<AbstractButton> rb = structureGroup.getElements(); rb.hasMoreElements(); ) {
                        AbstractButton radioButton = rb.nextElement();
                        if (radioButton.isSelected()) {
                            moleculeStructure = radioButton.getText();
                            configurationInfo.put("structure", moleculeStructure);
                        }
                    }

                    if(moleculeStructure.equals("Linear")){
                        for (Enumeration<AbstractButton> rb = fallingTypeGroup.getElements(); rb.hasMoreElements(); ) {
                            AbstractButton radioButton = rb.nextElement();
                            if (radioButton.isSelected()) {
                                fallingType = radioButton.getText();
                                configurationInfo.put("type", fallingType);
                            }
                        }
                    } else {
                        configurationInfo.put("type", "null");
                    }

                    for (Enumeration<AbstractButton> rb = gameDifficultyGroup.getElements(); rb.hasMoreElements(); ) {
                        AbstractButton radioButton = rb.nextElement();
                        if (radioButton.isSelected()) {
                            gameDifficulty = radioButton.getText();
                            configurationInfo.put("difficulty", gameDifficulty);
                        }
                    }

                    System.out.println(configurationInfo);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panelMain, "Please enter a non-negative integer.");
                }
            }
        });
    }

    private void CenterFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (dim.width - frame.getSize().width) / 2;
        int y = (dim.height - frame.getSize().height) / 2;

        frame.setLocation(x, y);
    }
}