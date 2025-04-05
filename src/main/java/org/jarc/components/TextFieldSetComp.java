package org.jarc.components;

import javax.swing.*;
import java.awt.*;

public class TextFieldSetComp extends JPanel {

    private final JLabel fieldLabel;
    private final JTextField textField;

    public TextFieldSetComp(String labelText, int fieldWidth, int fieldHeight){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to left

        fieldLabel = new JLabel(labelText);
        fieldLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textField = new JTextField();
        textField.setMaximumSize(new Dimension(fieldWidth, fieldHeight));
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(fieldLabel);
        this.add(Box.createRigidArea(new Dimension(0, 5))); // Small gap
        this.add(textField);

    }

    public String getInputFieldText(){

        return this.textField.getText();
    }
}
