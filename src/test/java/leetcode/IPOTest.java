package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPOTest {

    @Test
    void findMaximizedCapital() {
        int capital1 = new IPO().findMaximizedCapital(
            2,
            0,
            new int[]{1, 2, 3},
            new int[]{0, 1, 1}
        );
        assertEquals(4, capital1);
        int capital2 = new IPO().findMaximizedCapital(
            3,
            0,
            new int[]{1, 2, 3},
            new int[]{0, 1, 2}
        );
        assertEquals(6, capital2);
    }
}