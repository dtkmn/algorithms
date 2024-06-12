package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortColorsTest {

    @Test
    void testSortColors() {
        SortColors system = new SortColors();
        int[] input1 = new int[] { 2, 0, 2, 1, 1, 0 };
        system.sortColors(input1);
        assertArrayEquals(new int[] { 0, 0, 1, 1, 2, 2 }, input1);
        int[] input2 = new int[] { 2, 0, 1 };
        system.sortColors(input2);
        assertArrayEquals(new int[] { 0, 1, 2 }, input2);
    }
}