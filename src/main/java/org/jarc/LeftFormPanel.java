package org.jarc;

import org.jarc.utils.QRGenerator;

import javax.swing.*;
import java.awt.*;

public class LeftFormPanel extends JPanel{

    private final JLabel fieldLabel;
    private final JTextField inputStringField;
    private final JButton generateButton, saveButton;
    private final String submitButtonText = "Generate", borderTitle = "Form", fieldLabelText = "Enter a text to generate QR", saveQrButtonText = "Save this QR";
    private final JPanel buttonsPanel;
    private QRGenerator generator;

    public LeftFormPanel(MainPanel parentPanel){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder(borderTitle));
        fieldLabel = new JLabel(fieldLabelText);
        inputStringField = new JTextField(15);
        inputStringField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30)); // Set height
        inputStringField.setPreferredSize(new Dimension(150, 30));
        inputStringField.setText("https://google.com"); // placeholder for now, we'll have this removed.
        generateButton = new JButton(submitButtonText);
        generateButton.setFocusPainted(false);
        generateButton.setBackground(new Color(47, 69, 214));
        generateButton.addActionListener(e -> {

            if(inputStringField.getText().length() == 0){

                JOptionPane.showMessageDialog(null, "Empty field! provide some text.");
            }
            else if(inputStringField.getText().length() > 255)
                JOptionPane.showMessageDialog(null, "Max 255 Character are only allowed!");
            else{

                generator = new QRGenerator(inputStringField.getText());
                parentPanel.generateButtonListener(inputStringField.getText(), generator.getQrData(),generator.getQrDimensionsPerVersion());
            }
        });
        saveButton = new JButton(saveQrButtonText);
        saveButton.setFocusPainted(false);
        saveButton.setBackground(new Color(31, 214, 52));
        saveButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(null, "Feature not fully built yet!");
        });
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(generateButton);
        this.add(fieldLabel);
        this.add(inputStringField);
        this.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        this.add(buttonsPanel);
    }

}
