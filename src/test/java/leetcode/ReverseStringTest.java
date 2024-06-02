package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void reverseString() {
        char[] input = { 'H', 'a', 'n', 'n', 'a', 'h' };
        new ReverseString().reverseString(input);
        assertArrayEquals(new char[] { 'h', 'a', 'n', 'n', 'a', 'H' }, input);
    }
}