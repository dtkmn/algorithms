package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathSumIVTest {

    @Test
    void pathSum() {
        PathSumIV system = new PathSumIV();
        int ans1 = system.pathSum(
            new int[]{113, 215, 221}
        );
        assertEquals(12, ans1);
        int ans2 = system.pathSum(
            new int[]{113, 221}
        );
        assertEquals(4, ans2);
    }

}