package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreOfAStringTest {

    @Test
    void scoreOfString() {
        int score = new ScoreOfAString().scoreOfString("hello");
        assertEquals(13, score);
    }

}