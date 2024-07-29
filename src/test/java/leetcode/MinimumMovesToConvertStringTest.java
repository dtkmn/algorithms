package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumMovesToConvertStringTest {

    @Test
    void minimumMoves() {
        MinimumMovesToConvertString system = new MinimumMovesToConvertString();
        int ans1 = system.minimumMoves("XXX");
        assertEquals(1, ans1);
        int ans2 = system.minimumMoves("XX0X");
        assertEquals(2, ans2);
        int ans3 = system.minimumMoves("0000");
        assertEquals(0, ans3);
    }
}