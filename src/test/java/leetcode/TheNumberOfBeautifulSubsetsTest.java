package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheNumberOfBeautifulSubsetsTest {

    @Test
    public void simpleTest() {
        int subsets = new TheNumberOfBeautifulSubsets().beautifulSubsets(
                new int[]{2, 4, 6},
                2
        );
        assertEquals(4, subsets);
    }

}