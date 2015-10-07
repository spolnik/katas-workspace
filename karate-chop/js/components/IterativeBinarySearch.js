"use strict";

class IterativeBinarySearch {
    chop(numberToFind, inputNumbers) {
        return this._binarySearch(inputNumbers, numberToFind, 0, inputNumbers.length - 1);
    }

    _binarySearch(inputNumbers, numberToFind, imin, imax) {

        function midpoint(imin, imax) {
            return Number.parseInt((imin + imax) / 2);
        }

        while (imin <= imax) {
            let imid = midpoint(imin, imax);

            if (inputNumbers[imid] === numberToFind) {
                return imid;
            } else if (inputNumbers[imid] < numberToFind) {
                imin = imid + 1;
            } else {
                imax = imid - 1;
            }
        }

        return -1;
    }
}

module.exports = IterativeBinarySearch;
