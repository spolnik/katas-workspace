var expect = require('chai').expect;
var DummyBinarySearch = require('../components/DummyBinarySearch');

describe('binary search', () => {

    before(() => {
        this.binary_search = new DummyBinarySearch();
    });

    describe('chop(x, [])', () => {
        it('should return -1 when we look for 3 in []', () =>
            expect(this.binary_search.chop(3, [])).to.equal(-1)
        );
    });

    describe('chop(x, [1])', () => {
        it('should return -1 when we look for 3 in [1]', () =>
            expect(this.binary_search.chop(3, [1])).to.equal(-1)
        );

        it('should return 0 when we look for 1 in [1]', () =>
            expect(this.binary_search.chop(1, [1])).to.equal(0)
        );
    });
});