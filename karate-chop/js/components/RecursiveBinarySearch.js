"use strict";

class RecursiveBinarySearch {

    chop(numberToFind, inputNumbers) {

        function binarySearch(inputNumbers, numberToFind, imin, imax) {

            function midpoint(imin, imax) {
                return Number.parseInt((imin + imax) / 2);
            }

            if (imax < imin) {
                return -1;
            } else {

                let imid = midpoint(imin, imax);

                if (inputNumbers[imid] > numberToFind) {
                    return binarySearch(inputNumbers, numberToFind, imin, imid - 1);
                } else if (inputNumbers[imid] < numberToFind) {
                    return binarySearch(inputNumbers, numberToFind, imid + 1, imax);
                } else {
                    return imid;
                }
            }
        }

        return binarySearch(inputNumbers, numberToFind, 0, inputNumbers.length - 1);
    }
}

module.exports = RecursiveBinarySearch;
