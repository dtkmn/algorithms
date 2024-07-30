package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDeletionsToMakeStringBalancedTest {

    @Test
    void minimumDeletions() {
        MinimumDeletionsToMakeStringBalanced system = new MinimumDeletionsToMakeStringBalanced();
        int ans1 = system.minimumDeletions("bbaaaaabb");
        assertEquals(2, ans1);
    }
}