package org.jarc.utils;

public class QRGenerator {

    private final int byteLength = 8,
            finderPatternDim = 7, // this is always 7 x 7 modules / unit squares for any version of QR.
            commonIndexFromEnd,
            alignmentPatternDim = 5,
            alignmentPatternStartCordinate,
            timingPatternStartIndex = 6,
            timingPatternLength, mandateBlackSquareRow;
    private final String inputString;
    private String byteCodeArrayString = "";
    private final QRCodeVersions version;
    private final int qrDimensionsPerVersion;
    private final int [][] qrData;

    public QRGenerator(String givenString){

        this.inputString = givenString;
        this.version = QRCodeVersions.V2;
        this.qrDimensionsPerVersion = setQrDimensionsForVersion();
        this.qrData = new int[qrDimensionsPerVersion][qrDimensionsPerVersion];
        this.commonIndexFromEnd = qrDimensionsPerVersion - finderPatternDim;
        this.alignmentPatternStartCordinate = qrDimensionsPerVersion - (4 + alignmentPatternDim);
        this.timingPatternLength = qrDimensionsPerVersion - (2 * finderPatternDim) + 2; // one unit square white space along the inner side of finder pattern.
        this.mandateBlackSquareRow = qrDimensionsPerVersion - (finderPatternDim + 1); // 1 is spacer that surrounds the finder pattern.
        generate();
    }

    private void generate(){

        convertToByteArray();
        for(int i = 0; i < qrDimensionsPerVersion; i++){

            for(int j = 0; j < qrDimensionsPerVersion; j++){

                /*if((i + j + 2) % 2 == 0)
                    qrData[i][j] = 1;
                else
                    qrData[i][j] = 0;*/
                qrData[i][j] = 1;
            }
        }
        addFinderPattern();
        addAlignmentPattern();
        addTimingPatterns();
        addBlackUnitSquareByDesign();
    }

    private void convertToByteArray(){

        for(char c : this.inputString.toCharArray()){

            this.byteCodeArrayString += String.format("%8s", Integer.toBinaryString(c)).replace(" ","0");
        }
    }

    // to add the big three position squares at bottom left, top left and top right corner of the QR.
    private void addFinderPattern(){

        int temp;
        for(int i = 0; i < finderPatternDim; i++){

            for(int j = 0; j < finderPatternDim; j++){

                if((i >= 1 && i <= 5) && ((j == 1 || j == 5))) // this is to get that one unit square of white strip inside position squares.
                    temp = 1;
                else if((j >= 1 && j <= 5) && ((i == 1 || i == 5))) // this is to get that one unit square of white strip inside position squares.
                    temp = 1;
                else
                    temp = 0;
                // top left corner position square patch.
                qrData[i][j] = temp;

                // top right corner position square patch.
                qrData[i][commonIndexFromEnd + j] = temp;

                // bottom left corner position square patch.
                qrData[i + commonIndexFromEnd][j] = temp;
            }
        }
    }

    // to add the alignment pattern / the smaller square pattern near to the bottom right corner of hte QR. this will be almost at the same place for the codes till VERSION 10.
    private void addAlignmentPattern(){

        int temp;
        for(int i = 0; i < alignmentPatternDim; i++){

            for(int j = 0; j < alignmentPatternDim; j++){

                if((i >= 1 && i <= 3) && ((j == 1 || j == 3))) // this is to get that one unit square of white strip inside position squares.
                    temp = 1;
                else if((j >= 1 && j <= 3) && ((i == 1 || i == 3))) // this is to get that one unit square of white strip inside position squares.
                    temp = 1;
                else
                    temp = 0;
                qrData[i + alignmentPatternStartCordinate][j + alignmentPatternStartCordinate] = temp;
            }
        }
    }

    // to add the timing pattern, the alternating black and white unit squares that extends between the position squares.
    // They define the size of data or max size of QR data to readers.
    private void addTimingPatterns(){

        int temp;
        for(int i = 0; i < timingPatternLength; i++){

            if((i + 2) % 2 == 0)
                temp = 0;
            else
                temp = 1;
            qrData[6][i + timingPatternStartIndex] = temp;
            qrData[i + timingPatternStartIndex][6] = temp;
        }
    }

    // there is a single unit square near to bottom left finder square pattern which is always black by design.
    private void addBlackUnitSquareByDesign(){

        qrData[mandateBlackSquareRow][8] = 0;
    }

    public String getByteCodeArrayString(){

        return this.byteCodeArrayString;
    }

    public int[][] getQrData(){

        return this.qrData;
    }

    private int setQrDimensionsForVersion(){

        // this can also be done dynamically using this formula
        // Size = (Version Number × 4) + 17
        switch(this.version){

            case V2: return 25;
            default: return 21;
        }
    }

    public int getQrDimensionsPerVersion(){

        return this.qrDimensionsPerVersion;
    }

    public enum QRCodeVersions{

        V1,
        V2
    }
}
