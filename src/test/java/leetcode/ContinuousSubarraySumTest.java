package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContinuousSubarraySumTest {

    @Test
    void checkSubarraySum() {
        boolean ans1 = new ContinuousSubarraySum().checkSubarraySum(
            new int[]{ 23, 2, 4, 6, 7 },
            6
        );
        assertTrue(ans1);
        boolean ans2 = new ContinuousSubarraySum().checkSubarraySum(
            new int[]{ 23, 2, 6, 4, 7 },
            13
        );
        assertFalse(ans2);
    }
}