package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCostToConvertStringITest {

    @Test
    void minimumCost() {
        MinimumCostToConvertStringI system = new MinimumCostToConvertStringI();
        long ans1 = system.minimumCost(
            "abcd",
            "acbe",
            new char[] { 'a', 'b', 'c', 'c', 'e', 'd' },
            new char[] { 'b', 'c', 'b', 'e', 'b', 'e' },
            new int[] { 2, 5, 5, 1, 2, 20 });
        assertEquals(28, ans1);
    }
}