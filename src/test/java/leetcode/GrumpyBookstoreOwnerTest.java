package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrumpyBookstoreOwnerTest {

    @Test
    void maxSatisfied() {
        int ans1 = new GrumpyBookstoreOwner().maxSatisfied(
            new int[]{1, 0, 1, 2, 1, 1, 7, 5},
            new int[]{0, 1, 0, 1, 0, 1, 0, 1},
            3
        );
        assertEquals(16, ans1);
    }

}