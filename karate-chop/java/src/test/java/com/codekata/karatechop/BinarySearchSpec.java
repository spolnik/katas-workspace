package com.codekata.karatechop;

import org.junit.Before;
import org.junit.Test;

import static com.codekata.karatechop.BinarySearch.NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchSpec {

    private BinarySearch binarySearch;

    @Before
    public void setUp() throws Exception {

        binarySearch = new BinarySearch();
    }

    @Test
    public void returns_not_found_if_looking_in_empty_array() throws Exception {

        assertThat(binarySearch.chop(3, array())).isEqualTo(NOT_FOUND);
    }

    @Test
    public void returns_not_found_if_element_is_absent() throws Exception {

        assertThat(binarySearch.chop(3, array(1))).isEqualTo(NOT_FOUND);
    }

    private int[] array(int... elements) {
        return elements;
    }
}
