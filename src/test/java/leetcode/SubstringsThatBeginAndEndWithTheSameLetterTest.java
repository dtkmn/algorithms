package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringsThatBeginAndEndWithTheSameLetterTest {

    @Test
    void numberOfSubstrings() {
        long ans1 = new SubstringsThatBeginAndEndWithTheSameLetter().numberOfSubstrings("abcba");
        assertEquals(7L, ans1);
        long ans2 = new SubstringsThatBeginAndEndWithTheSameLetter().numberOfSubstrings("a");
        assertEquals(1L, ans2);
    }
}