var assert = require('assert');
var DummyBinarySearch = require('../components/DummyBinarySearch');

describe('binary search', () => {

    before(() => {
        this.binary_search = new DummyBinarySearch();
    });

    describe('chop()', () => {
        it('should return -1 when we look for 3 in []', () => {
            assert.equal(-1, this.binary_search.chop(3, []));
        });
    });
});