package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheNumberOfTheSmallestUnoccupiedChairTest {

    @Test
    void smallestChair() {
        TheNumberOfTheSmallestUnoccupiedChair theNumberOfTheSmallestUnoccupiedChair = new TheNumberOfTheSmallestUnoccupiedChair();
        int[][] times = {{3,10},{1,5},{2,6}};
        int result = theNumberOfTheSmallestUnoccupiedChair.smallestChair(times, 0);
        assertEquals(2, result);
    }
}