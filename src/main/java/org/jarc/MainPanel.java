package org.jarc;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(){

        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(960, 540));
        this.setLayout(new GridLayout(1, 2));
        LeftFormPanel leftForm = new LeftFormPanel();
        RightPanel rightPanel = new RightPanel();
        this.add(leftForm);
        this.add(rightPanel);
    }
}
