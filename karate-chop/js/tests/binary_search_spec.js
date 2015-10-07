'use strict';

let expect = require('chai').expect;
let DummyBinarySearch = require('../components/DummyBinarySearch');
let IterativeBinarySearch = require('../components/IterativeBinarySearch');
let RecursiveBinarySearch = require('../components/RecursiveBinarySearch');

var tests = [
    {numberToFind: 3, inputNumbers: [],  expected: -1},

    {numberToFind: 3, inputNumbers: [1],  expected: -1},
    {numberToFind: 1, inputNumbers: [1],  expected: 0},

    {numberToFind: 1, inputNumbers: [1, 3], expected: 0},
    {numberToFind: 3, inputNumbers: [1, 3], expected: 1},
    {numberToFind: 0, inputNumbers: [1, 3], expected: -1},

    {numberToFind: 1, inputNumbers: [1,3,5],  expected: 0},
    {numberToFind: 3, inputNumbers: [1,3,5],  expected: 1},
    {numberToFind: 5, inputNumbers: [1,3,5],  expected: 2},
    {numberToFind: 0, inputNumbers: [1,3,5],  expected: -1},
    {numberToFind: 2, inputNumbers: [1,3,5],  expected: -1},
    {numberToFind: 4, inputNumbers: [1,3,5],  expected: -1},
    {numberToFind: 6, inputNumbers: [1,3,5],  expected: -1},

    {numberToFind: 1, inputNumbers: [1,3,5,7], expected: 0},
    {numberToFind: 3, inputNumbers: [1,3,5,7], expected: 1},
    {numberToFind: 5, inputNumbers: [1,3,5,7], expected: 2},
    {numberToFind: 7, inputNumbers: [1,3,5,7], expected: 3},
    {numberToFind: 0, inputNumbers: [1,3,5,7], expected: -1},
    {numberToFind: 2, inputNumbers: [1,3,5,7], expected: -1},
    {numberToFind: 4, inputNumbers: [1,3,5,7], expected: -1},
    {numberToFind: 6, inputNumbers: [1,3,5,7], expected: -1},
    {numberToFind: 8, inputNumbers: [1,3,5,7], expected: -1}
];

describe('dummy binary search', () => {

    before(() => {
        this.binary_search = new DummyBinarySearch();
    });

    describe('chop()', () => {
        tests.forEach((test) => {
            it(`returns ${test.expected} when we look for ${test.numberToFind} in [${test.inputNumbers.toString()}]`, () =>
                expect(this.binary_search.chop(test.numberToFind, test.inputNumbers)).to.equal(
                    test.expected
                )
            );
        });
    });
});

describe('iterative binary search', () => {

    before(() => {
        this.binary_search = new IterativeBinarySearch();
    });

    describe('chop()', () => {
        tests.forEach((test) => {
            it(`returns ${test.expected} when we look for ${test.numberToFind} in [${test.inputNumbers.toString()}]`, () =>
                    expect(this.binary_search.chop(test.numberToFind, test.inputNumbers)).to.equal(
                        test.expected
                    )
            );
        });
    });
});

describe('recursive binary search', () => {

    before(() => {
        this.binary_search = new RecursiveBinarySearch();
    });

    describe('chop()', () => {
        tests.forEach((test) => {
            it(`returns ${test.expected} when we look for ${test.numberToFind} in [${test.inputNumbers.toString()}]`, () =>
                    expect(this.binary_search.chop(test.numberToFind, test.inputNumbers)).to.equal(
                        test.expected
                    )
            );
        });
    });
});