package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximalScoreAfterApplyingKOperationsTest {

    @Test
    void maxKelements() {
        MaximalScoreAfterApplyingKOperations sys = new MaximalScoreAfterApplyingKOperations();
        long ans = sys.maxKelements(new int[]{ 10, 10, 10, 10, 10 }, 5);
        assertEquals(50, ans);
        long ans2 = sys.maxKelements(new int[]{ 1, 10, 3, 3, 3 }, 3);
        assertEquals(17, ans2);
    }
}