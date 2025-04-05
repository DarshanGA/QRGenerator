package org.jarc;

import javax.swing.*;
import java.awt.*;

public class LeftFormPanel extends JPanel{

    private final JLabel fieldLabel;
    private final JTextField inputStringField;
    private final JButton generateButton, saveButton;
    private final String submitButtonText = "Generate", borderTitle = "Form", fieldLabelText = "Enter a text to generate QR", saveQrButtonText = "Save this QR";
    private final JPanel buttonsPanel;
    private QRGenerator generator;

    public LeftFormPanel(){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder(borderTitle));
        fieldLabel = new JLabel(fieldLabelText);
        inputStringField = new JTextField(15);
        inputStringField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30)); // Set height
        inputStringField.setPreferredSize(new Dimension(150, 30));
        generateButton = new JButton(submitButtonText);
        generateButton.setFocusPainted(false);
        generateButton.setBackground(new Color(47, 69, 214));
        generateButton.addActionListener(e -> {

            generateQrCode();
        });
        saveButton = new JButton(saveQrButtonText);
        saveButton.setFocusPainted(false);
        saveButton.setBackground(new Color(31, 214, 52));
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(generateButton);
        this.add(fieldLabel);
        this.add(inputStringField);
        this.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        this.add(buttonsPanel);
    }

    public void generateQrCode(){

        generator = new QRGenerator(this.inputStringField.getText());
        JOptionPane.showMessageDialog(null, "Encoded Byte String:" + generator.getByteCodeArrayString());
    }
}
