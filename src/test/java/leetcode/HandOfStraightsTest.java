package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandOfStraightsTest {

    @Test
    void isNStraightHand() {
        boolean ans1 = new HandOfStraights().isNStraightHand(
            new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8},
            3
        );
        assertTrue(ans1);
        boolean ans2 = new HandOfStraights().isNStraightHand(
                new int[]{1, 2, 3, 4, 5},
                4
        );
        assertFalse(ans2);
    }

}