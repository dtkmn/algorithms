package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfDaysToMakeMBouquetsTest {

    @Test
    void minDays() {
        int ans1 = new MinimumNumberOfDaysToMakeMBouquets().minDays(
                new int[]{ 1, 10, 3, 10, 2 },
                3,
                1
        );
        assertEquals(3, ans1);
        int ans2 = new MinimumNumberOfDaysToMakeMBouquets().minDays(
                new int[]{ 7, 7, 7, 7, 12, 7, 7 },
                2,
                3
        );
        assertEquals(12, ans2);
    }

}