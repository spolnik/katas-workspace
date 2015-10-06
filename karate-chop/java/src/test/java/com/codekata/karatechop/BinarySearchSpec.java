package com.codekata.karatechop;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.codekata.karatechop.BinarySearch.NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
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
    public void returns_not_found_if_element_is_absent_in_array_of_one_item() throws Exception {

        assertThat(binarySearch.chop(3, array(1))).isEqualTo(NOT_FOUND);
    }

    @Test
    public void returns_0_when_we_look_for_the_only_item_in_the_array_of_one_item() throws Exception {

        assertThat(binarySearch.chop(1, array(1))).isEqualTo(0);
    }

    @Test
    public void returns_0_when_we_look_for_1_in_array_of_1_3_5() throws Exception {

        assertThat(binarySearch.chop(1, array(1,3,5))).isEqualTo(0);
    }

    @Test
    public void returns_1_when_we_look_for_3_in_array_of_1_3_5() throws Exception {

        assertThat(binarySearch.chop(3, array(1,3,5))).isEqualTo(1);
    }

    @Test
    public void returns_2_when_we_look_for_5_in_array_of_1_3_5() throws Exception {

        assertThat(binarySearch.chop(5, array(1,3,5))).isEqualTo(2);
    }

    @Test
    @Parameters({"0", "2", "4", "6"})
    public void returns_not_found_when_we_look_for_absent_element_in_array_of_1_3_5(int numberToFind) throws Exception {

        assertThat(binarySearch.chop(numberToFind, array(1,3,5))).isEqualTo(NOT_FOUND);
    }

    private int[] array(int... elements) {
        return elements;
    }
}
