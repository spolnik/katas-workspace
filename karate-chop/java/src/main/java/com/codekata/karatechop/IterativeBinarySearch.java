package com.codekata.karatechop;

public final class IterativeBinarySearch implements BinarySearch {

    @Override
    public int chop(int numberToFind, int[] inputNumbers) {

        return binarySearch(inputNumbers, numberToFind, 0, inputNumbers.length - 1);
    }

    private int binarySearch(int[] inputNumbers, int numberToFind, int imin, int imax) {

        while (imin <= imax) {
            int imid = midpoint(imin, imax);

            if(inputNumbers[imid] == numberToFind) {
                return imid;
            } else if (inputNumbers[imid] < numberToFind) {
                imin = imid + 1;
            } else {
                imax = imid - 1;
            }
        }

        return NOT_FOUND;
    }

    private int midpoint(int imin, int imax) {
        return (imin + imax) / 2;
    }
}
