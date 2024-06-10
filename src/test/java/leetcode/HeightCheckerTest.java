package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeightCheckerTest {

    @Test
    void heightChecker() {
        int ans1 = new HeightChecker().heightChecker(
            new int[]{ 1, 1, 4, 2, 1, 3 }
        );
        assertEquals(3, ans1);
        int ans2 = new HeightChecker().heightChecker(
            new int[]{ 5, 1, 2, 3, 4 }
        );
        assertEquals(5, ans2);
    }

}