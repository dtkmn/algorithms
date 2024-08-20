package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourKeysKeyboardTest {

    @Test
    void maxA() {
        FourKeysKeyboard system = new FourKeysKeyboard();
        int ans1 = system.maxA(7);
        assertEquals(9, ans1);
    }
}