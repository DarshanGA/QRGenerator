package org.jarc.utils;

import javax.swing.*;
import java.awt.*;

public class QRDrawer extends JPanel {

    private final int singleSquareUnit = 6; // pixel width of a single square in generated QR.
    private int qrSize = 21 * singleSquareUnit;
    private int [][] qrData;

    public QRDrawer(){

        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(50, 50));
    }

    public void updateQrData(int givenQrSize, int[][] givenQrData){

        this.qrSize = givenQrSize * singleSquareUnit;
        this.qrData = givenQrData;
        repaint();
    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(singleSquareUnit));
        int drawX = (getWidth() / 2) - (qrSize / 2),
                drawY = (getHeight() / 2) - (qrSize / 2), currentX, currentY;
        currentX = drawX;
        currentY = drawY;
        if(qrData ==  null){

            graphics2D.drawRect(currentX, currentY, qrSize, qrSize);
        }
        else{

            for(int i = 0; i < qrSize / singleSquareUnit; i++){

                for(int j = 0; j < qrSize / singleSquareUnit; j++){

                    if( qrData[i][j] == 0)
                        graphics2D.setColor(Color.black);
                    else
                        graphics2D.setColor(Color.white);
                    graphics2D.fillRect(currentX, currentY, singleSquareUnit,singleSquareUnit);
                    currentX += singleSquareUnit;
                }
                currentX = drawX;
                currentY += singleSquareUnit;
            }
        }

    }
}
