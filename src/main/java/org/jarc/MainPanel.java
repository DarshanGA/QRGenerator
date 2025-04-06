package org.jarc;

import org.jarc.interfaces.IComponentListner;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements IComponentListner {

    private final RightPanel rightPanel;
    private final LeftFormPanel leftForm;
    public MainPanel(){

        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(960, 540));
        this.setLayout(new GridLayout(1, 2));
        this.leftForm = new LeftFormPanel(this);
        this.rightPanel = new RightPanel();
        this.add(leftForm);
        this.add(rightPanel);
    }

    @Override
    public void generateButtonListener(String inputData, int[][] qrData, int qrDimensions) {

        rightPanel.changePlaceholderText(inputData);
        rightPanel.updateQrData(qrDimensions, qrData);
        //rightPanel.showQr(qrData, qrDimensions);
    }
}
