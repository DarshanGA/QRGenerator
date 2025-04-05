package org.jarc;

import javax.swing.*;

public class App {
    public static void main(String[] args) {

        JFrame mainFrame = new JFrame("QA Generator");
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        MainPanel form = new MainPanel();
        mainFrame.add(form);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
