package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AverageWaitingTimeTest {

    @Test
    void averageWaitingTime() {
        double ans1 = new AverageWaitingTime().averageWaitingTime(
            new int[][]{
                {1, 2},
                {2, 5},
                {4, 3}
            }
        );
        assertEquals(5.0, ans1);
        double ans2 = new AverageWaitingTime().averageWaitingTime(
            new int[][]{
                {5, 2},
                {5, 4},
                {10, 3},
                {20, 1}
            }
        );
        assertEquals(3.25, ans2);
    }
}