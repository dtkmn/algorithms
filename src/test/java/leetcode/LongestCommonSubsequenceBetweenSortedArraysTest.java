package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceBetweenSortedArraysTest {

    @Test
    void longestCommonSubsequence() {
        List<Integer> list = new LongestCommonSubsequenceBetweenSortedArrays().longestCommonSubsequence(
            new int[][]{
                new int[]{1, 3, 4},
                new int[]{1, 4, 7, 9}
            }
        );
        assertEquals(List.of(1, 4), list);
    }
}