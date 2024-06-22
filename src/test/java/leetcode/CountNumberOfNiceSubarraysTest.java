package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountNumberOfNiceSubarraysTest {

    @Test
    void numberOfSubarrays() {
        int ans1 = new CountNumberOfNiceSubarrays().numberOfSubarrays(
            new int[]{ 1, 1, 2, 1, 1 },
            3
        );
        assertEquals(2, ans1);
        int ans2 = new CountNumberOfNiceSubarrays().numberOfSubarrays(
            new int[]{ 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 },
            2
        );
        assertEquals(16, ans2);
    }

}