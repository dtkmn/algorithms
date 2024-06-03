package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppendCharactersToStringToMakeSubsequenceTest {

    @Test
    void appendCharacters() {
        int appended = new AppendCharactersToStringToMakeSubsequence().appendCharacters(
                "coaching",
                "coding"
        );
        assertEquals(4, appended);
    }

}