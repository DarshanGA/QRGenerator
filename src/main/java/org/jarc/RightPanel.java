package org.jarc;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    private final String borderSectionTitle = "Generated QR Code", infoPlaceHolderText = "Provide some text in the form to generate a QR Code!";

    public RightPanel(){

        this.setBorder(BorderFactory.createTitledBorder(borderSectionTitle));

        JLabel placeholderLabel = new JLabel(infoPlaceHolderText, SwingConstants.CENTER);
        this.add(placeholderLabel, BorderLayout.CENTER);
    }
}
