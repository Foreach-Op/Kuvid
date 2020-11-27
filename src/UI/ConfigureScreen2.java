package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;

public class ConfigureScreen2 {

    public JPanel panelMain;
    private JPanel panelSelectionFields;

    private JFormattedTextField textFieldNumberOfAtoms;
    private JFormattedTextField textFieldNumberOfBlockers;
    private JFormattedTextField textFieldNumberOfPowerups;
    private JFormattedTextField textFieldNumberOfMolecules;
    private JFormattedTextField textFieldLength;

    private JPanel panelMoleculeStructure;
    private JRadioButton radioButtonLinear;
    private JRadioButton radioButtonTriangle;

    private JPanel panelMoleculeFallingType;
    private JRadioButton radioButtonStationary;
    private JRadioButton radioButtonSpinning;

    private JPanel panelGameDifficulty;
    private JRadioButton radioButtonEasy;
    private JRadioButton radioButtonNormal;
    private JRadioButton radioButtonHard;

    private JButton buttonStart;

    private JTextArea textAreaAtoms;
    private JTextArea textAreaBlockers;
    private JTextArea textAreaPowerups;
    private JTextArea textAreaMolecules;
    private JTextArea footnote;
    private JTextArea textAreaLength;
    private JTextArea textAreaMoleculeStructure;
    private JTextArea textAreaMoleculeFallingType;
    private JTextArea textAreaDifficulty;

    private ButtonGroup structureGroup;
    private ButtonGroup fallingTypeGroup;
    private ButtonGroup gameDifficultyGroup;

    private HashMap<String, String> configurationInfo;

    public ConfigureScreen2() {
        configurationInfo = new HashMap<>();

        CreateUIElements();
        InitializeRBGroups();
        ActionListener();
    }

    private void CreateUIElements() {
        JFrame frame = new JFrame("Game Configuration");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(510, 420);
        // frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        frame.setResizable(false);

        CenterFrame(frame);
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
        gameDifficultyGroup.add(radioButtonNormal);
        gameDifficultyGroup.add(radioButtonHard);
        radioButtonNormal.setSelected(true);
    }

    private void ActionListener() {
        radioButtonLinear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If Linear Structure is selected, then enable falling type options
                radioButtonStationary.setEnabled(true);
                radioButtonSpinning.setEnabled(true);
            }
        });

        radioButtonTriangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If Triangle Structure is selected, then unable falling type options and set Stationary type as default
                radioButtonStationary.setEnabled(false);
                radioButtonStationary.setSelected(true);
                radioButtonSpinning.setEnabled(false);
            }
        });

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Take numerical inputs as non-negative integers.
                    int numberOfAtoms = Integer.parseUnsignedInt(textFieldNumberOfAtoms.getText());
                    int numberOfBlockers = Integer.parseUnsignedInt(textFieldNumberOfBlockers.getText());
                    int numberOfPowerups = Integer.parseUnsignedInt(textFieldNumberOfPowerups.getText());
                    int numberOfMolecules = Integer.parseUnsignedInt(textFieldNumberOfMolecules.getText());
                    int length = Integer.parseUnsignedInt(textFieldLength.getText());

                    // Put object amounts and length into hashmap as String
                    configurationInfo.put("atom", textFieldNumberOfAtoms.getText());
                    configurationInfo.put("blocker", textFieldNumberOfBlockers.getText());
                    configurationInfo.put("powerup", textFieldNumberOfPowerups.getText());
                    configurationInfo.put("molecule", textFieldNumberOfMolecules.getText());
                    configurationInfo.put("length", textFieldLength.getText());

                    String moleculeStructure = new String();
                    String fallingType = new String();
                    String gameDifficulty = new String();

                    // Get the selected RadioButton from radioButtonGroups and assign it to strings
                    for (Enumeration<AbstractButton> rb = structureGroup.getElements(); rb.hasMoreElements(); ) {
                        AbstractButton radioButton = rb.nextElement();
                        if (radioButton.isSelected())
                            moleculeStructure = radioButton.getText();
                    }

                    for (Enumeration<AbstractButton> rb = fallingTypeGroup.getElements(); rb.hasMoreElements(); ) {
                        AbstractButton radioButton = rb.nextElement();
                        if (radioButton.isSelected())
                            fallingType = radioButton.getText();
                    }

                    for (Enumeration<AbstractButton> rb = gameDifficultyGroup.getElements(); rb.hasMoreElements(); ) {
                        AbstractButton radioButton = rb.nextElement();
                        if (radioButton.isSelected())
                            gameDifficulty = radioButton.getText();
                    }

                    // Put those strings into hashmap
                    configurationInfo.put("structure", moleculeStructure);
                    configurationInfo.put("type", fallingType);
                    configurationInfo.put("difficulty", gameDifficulty);

                    System.out.println(configurationInfo);

                    // SEND HASHMAP TO THE DOMAIN

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