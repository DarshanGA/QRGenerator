package org.jarc;

import org.jarc.utils.QRDrawer;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    private final String borderSectionTitle = "Generated QR Code",
            infoPlaceHolderText = "Provide some text in the form to generate a QR Code!", generatedText = "Below is your Generated QR for input: ";
    private JLabel placeholderLabel;
    private final QRDrawer qrDrawer;

    public RightPanel(){

        this.setBorder(BorderFactory.createTitledBorder(borderSectionTitle));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        placeholderLabel = new JLabel(infoPlaceHolderText, SwingConstants.CENTER);
        this.add(placeholderLabel, BorderLayout.CENTER);

        this.qrDrawer = new QRDrawer();
        this.add(Box.createVerticalStrut(10)); // spacing
        this.add(qrDrawer);
    }

    public void changePlaceholderText(String givenText){

        this.placeholderLabel.setText(generatedText + givenText);
    }

    public void updateQrData(int givenSize, int[][] givenData){

        this.qrDrawer.updateQrData(givenSize, givenData);
    }

}
