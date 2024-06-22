package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsKTest {

    @Test
    void subarraySum() {
        int ans1 = new SubarraySumEqualsK().subarraySum(
            new int[]{ 1, 1, 1 },
            2
        );
        assertEquals(2, ans1);
        int ans2 = new SubarraySumEqualsK().subarraySum(
                new int[]{ -1, -1, 1 },
                0
        );
        assertEquals(1, ans2);
    }

}