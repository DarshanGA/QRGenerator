package org.jarc;

import javax.swing.*;
import java.awt.*;

public class QRDrawer extends JPanel {

    private final int singleSquareUnit = 8, qrDimensions; // pixel width of a single square in generated QR.
    private final int[][] qrData;

    public QRDrawer(int[][] givenQrData, int givenQrDimensions){


        this.qrData = givenQrData;
        this.qrDimensions = givenQrDimensions;
    }

    public void paintComponent(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;
        drawBorder(graphics2D);
    }

    private void drawBorder(Graphics2D graphics2D){

        graphics2D.setColor(Color.BLUE);
        graphics2D.drawRect(0,0, qrDimensions + singleSquareUnit, qrDimensions + singleSquareUnit);
    }
}
