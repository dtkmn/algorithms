package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesTest {

    @Test
    void minDifference() {
        int ans1 = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves().minDifference(
            new int[]{ 5, 3, 2, 4 }
        );
        assertEquals(0, ans1);
        int ans2 = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves().minDifference(
            new int[]{ 1, 5, 0, 10, 14 }
        );
        assertEquals(1, ans2);
    }

}