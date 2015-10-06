package com.codekata.karatechop;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchSpec {

    private static final int[] EMPTY_ARRAY = {};
    private BinarySearch binarySearch;

    @Before
    public void setUp() throws Exception {

        binarySearch = new BinarySearch();
    }

    @Test
    public void returns_minus_one_if_looking_in_empty_array() throws Exception {

        assertThat(binarySearch.chop(3, EMPTY_ARRAY)).isEqualTo(-1);
    }
}
