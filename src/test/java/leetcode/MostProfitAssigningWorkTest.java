package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostProfitAssigningWorkTest {

    @Test
    void maxProfitAssignment() {
        int ans1 = new MostProfitAssigningWork().maxProfitAssignment(
                new int[]{66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63},
                new int[]{66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77},
                new int[]{61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16}
        );
        assertEquals(1392, ans1);
    }
}