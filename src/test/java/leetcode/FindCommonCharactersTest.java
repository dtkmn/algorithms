package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindCommonCharactersTest {

    @Test
    void commonChars() {
        FindCommonCharacters commonCharacters = new FindCommonCharacters();
        List<String> ans1 = commonCharacters.commonChars(
            new String[]{
                "bella", "label", "roller"
            }
        );
        assertEquals(List.of("e", "l", "l"), ans1);

        List<String> ans2 = commonCharacters.commonChars(new String[]{"single"});
        assertEquals(List.of("e", "g", "i", "l", "n", "s"), ans2);

        List<String> ans3 = commonCharacters.commonChars(new String[]{});
        assertEquals(List.of(), ans3);

        List<String> ans4 = commonCharacters.commonChars(new String[]{"abc", "def", "ghi"});
        assertEquals(List.of(), ans4);
    }
}