package com.codekata.karatechop;

public class RecursiveBinarySearch implements BinarySearch {

    @Override
    public int chop(int numberToFind, int[] inputNumbers) {
        return binarySearch(inputNumbers, numberToFind, 0, inputNumbers.length - 1);
    }

    private int binarySearch(int[] inputNumbers, int numberToFind, int imin, int imax) {

        if (imax < imin) {
            return NOT_FOUND;
        } else {
            int imid = midpoint(imin, imax);

            if (inputNumbers[imid] > numberToFind) {
                return binarySearch(inputNumbers, numberToFind, imin, imid - 1);
            } else if (inputNumbers[imid] < numberToFind) {
                return binarySearch(inputNumbers, numberToFind, imid + 1, imax);
            } else {
                return imid;
            }
        }
    }

    private int midpoint(int imin, int imax) {
        return (imin + imax) / 2;
    }
}
