package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    @Test
    void longestPalindrome() {
        int longest = new LongestPalindrome().longestPalindrome("ccc");
        assertEquals(3, longest);
    }
}