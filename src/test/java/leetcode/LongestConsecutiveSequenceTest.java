package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    @Test
    void longestConsecutive() {
        int ans1 = new LongestConsecutiveSequence().longestConsecutive(
            new int[] { 100, 4, 200, 1, 3, 2 }
        );
        assertEquals(4, ans1);
        int ans2 = new LongestConsecutiveSequence().longestConsecutive(
            new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }
        );
        assertEquals(9, ans2);
    }
}