package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfMovesToSeatEveryoneTest {

    @Test
    void minMovesToSeat() {
        int ans1 = new MinimumNumberOfMovesToSeatEveryone().minMovesToSeat(
                new int[]{3, 1, 5},
                new int[]{2, 7, 4}
        );
        assertEquals(4, ans1);
        int ans2 = new MinimumNumberOfMovesToSeatEveryone().minMovesToSeat(
                new int[]{4, 1, 5, 9},
                new int[]{1, 3, 2, 6}
        );
        assertEquals(7, ans2);
    }
}