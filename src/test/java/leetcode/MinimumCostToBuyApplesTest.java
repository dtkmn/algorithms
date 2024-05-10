package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCostToBuyApplesTest {

    @Test
    void testSimpleCase() {
        int n = 4;
        int[][] roads = new int[][] {
            new int[]{1, 2, 4},
            new int[]{2, 3, 2},
            new int[]{2, 4, 5},
            new int[]{3, 4, 1},
            new int[]{1, 3, 4}
        };
        int[] appleCost = new int[]{56, 42, 102, 301};
        int k = 2;
        assertArrayEquals(new long[]{54, 42, 48, 51}, new MinimumCostToBuyApples().minCost(
            n, roads, appleCost, k
        ), "The result should be { 54, 42, 48, 51 }");
    }

}