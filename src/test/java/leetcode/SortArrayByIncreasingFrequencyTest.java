package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayByIncreasingFrequencyTest {

    @Test
    void frequencySort() {
        SortArrayByIncreasingFrequency system = new SortArrayByIncreasingFrequency();
        int[] ans1 = system.frequencySort(
                new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}
        );
        assertArrayEquals(new int[]{5,-1,4,4,-6,-6,1,1,1}, ans1);
    }
}