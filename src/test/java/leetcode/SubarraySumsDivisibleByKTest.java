package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumsDivisibleByKTest {

    @Test
    void subarraysDivByK() {
        int count = new SubarraySumsDivisibleByK().subarraysDivByK(
            new int[]{4, 5, 0, -2, -3, 1},
            5
        );
        assertEquals(7, count);
    }
}