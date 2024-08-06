package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthDistinctStringInAnArrayTest {

    @Test
    void kthDistinct() {
        KthDistinctStringInAnArray system = new KthDistinctStringInAnArray();
        String ans1 = system.kthDistinct(
                new String[]{"d", "b", "c", "b", "c", "a"},
                2
        );
        assertEquals("a", ans1);
        String ans2 = system.kthDistinct(
                new String[]{"aaa","aa","a"},
                1
        );
        assertEquals("aaa", ans2);
    }
}