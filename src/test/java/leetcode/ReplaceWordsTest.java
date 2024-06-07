package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceWordsTest {

    @Test
    void replaceWords_2024() {
        String s = new ReplaceWords().replaceWords(
                List.of("cat", "bat", "rat"),
                "the cattle was rattled by the battery"
        );
        assertEquals("the cat was rat by the bat", s);
    }
}