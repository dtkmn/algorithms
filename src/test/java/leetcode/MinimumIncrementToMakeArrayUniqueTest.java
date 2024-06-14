package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumIncrementToMakeArrayUniqueTest {

    @Test
    void minIncrementForUnique2() {
        int ans1 = new MinimumIncrementToMakeArrayUnique().minIncrementForUnique2(
            new int[] {1,2,2}
        );
        assertEquals(1, ans1);
        int ans2 = new MinimumIncrementToMakeArrayUnique().minIncrementForUnique2(
                new int[] {3,2,1,2,1,7}
        );
        assertEquals(6, ans2);
    }

}