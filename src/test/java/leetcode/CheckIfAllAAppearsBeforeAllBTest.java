package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfAllAAppearsBeforeAllBTest {

    @Test
    void checkString() {
        CheckIfAllAAppearsBeforeAllB system = new CheckIfAllAAppearsBeforeAllB();
        boolean ans1 = system.checkString("aaabbb");
        assertTrue(ans1);
    }
}