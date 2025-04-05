package org.jarc;

public class QRGenerator {

    private final int byteLength = 8;
    private final String inputString;
    private String byteCodeArrayString = "";
    private final QRCodeVersions version;
    private final int qrDimensionsPerVersion;
    private int [][] qrData;

    public QRGenerator(String givenString){

        this.inputString = givenString;
        convertToByteArray();
        this.version = QRCodeVersions.V2;
        this.qrDimensionsPerVersion = setQrDimensionsForVersion();
        this.qrData = new int[qrDimensionsPerVersion][qrDimensionsPerVersion];
    }

    private void convertToByteArray(){

        for(char c : this.inputString.toCharArray()){

            this.byteCodeArrayString += String.format("%8s", Integer.toBinaryString(c)).replace(" ","0");
        }
    }

    public String getByteCodeArrayString(){

        return this.byteCodeArrayString;
    }

    private int setQrDimensionsForVersion(){

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
