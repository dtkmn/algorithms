package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfPushesToTypeWordIITest {

    @Test
    void minimumPushes() {
        MinimumNumberOfPushesToTypeWordII system = new MinimumNumberOfPushesToTypeWordII();
        int ans1 = system.minimumPushes("abcde");
        assertEquals(5, ans1);
        int ans2 = system.minimumPushes("aabbccddeeffgghhiiiiii");
        assertEquals(24, ans2);
    }
}