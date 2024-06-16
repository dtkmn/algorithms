package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatchingArrayTest {

    @Test
    void minPatches() {
        int ans1 = new PatchingArray().minPatches(
                new int[]{ 1, 3 },
                6
        );
        assertEquals(1, ans1);
        int ans2 = new PatchingArray().minPatches(
                new int[]{ 1, 5, 10 },
                20
        );
        assertEquals(2, ans2);
    }

}