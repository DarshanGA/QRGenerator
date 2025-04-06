# QRGenerator

##Bit color association
**1 :** Black

**0 :** White

##Algorithm for position squares
####Pre-requisite:
Calculate the common index from end for these 3 position squares -> 

    commonIndexFromEnd = qrDimensions - 7; //as 7 is fixed dimensions for these position squares.
when we consider the draw coordinates for these position squares (as per working of Graphics2D.drawRect() and fillRect() methods), we will get
1. Top left position square: (0, 0)
2. Top right position square: (0, 7 unit squares to right from end)
3. bottom left position square: (7 unit squares to the top from end, 0)

***Common index from end:*** we pick '7 unit square from end', as this is also common data which is calculated as "Original QR dimension - 7"

####Loop:
    Loop for 7 times for rows	
        loop for 7 times for columns
            Inside the loop: 
            
                // top left corner position square patch.
                paint black for qrData[i][j] ;

                // top right corner position square patch.
                paint black for qrData[i][commonIndexFromEnd + j] ;

                // bottom left corner position square patch.
                paint black for qrData[i + commonIndexFromEnd][j] ;
This will only produce solid black position square patch, which is not what we want. To have that white strip of 'one unit square' inside this solid black corner position squares, we need to have bit more condition like below.

Prior to above solid steps, instead of always painting in black unit square, we will have a condition to decide whether to paint in black or white unit square.
    
    like: 
    if (row is between second and sixth AND column is either '1' or '5') // this creates top and bottom white strips.
        paint white unit square;
    else if (row is either '1' or '5' AND column is between second and sixth) // this creates left and right white strips.
        paint white unit square;
    else
        paint black unit square;
