package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseVowelsOfStringTest {

    @Test
    void reverseVowels() {
        ReverseVowelsOfString system = new ReverseVowelsOfString();
        String ans1 = system.reverseVowels("leetcode");
        assertEquals("leotcede", ans1);
    }
}