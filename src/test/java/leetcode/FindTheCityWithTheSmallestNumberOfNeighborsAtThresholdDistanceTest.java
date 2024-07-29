package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistanceTest {

    @Test
    void findTheCity() {
        FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance system = new FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance();
        int ans1 = system.findTheCity_floydWarshall(
            5,
            new int[][]{
                new int[]{ 0, 1, 2 },
                new int[]{ 0, 4, 8 },
                new int[]{ 1, 2, 3 },
                new int[]{ 1, 4, 2 },
                new int[]{ 2, 3, 1 },
                new int[]{ 3, 4, 1 }
            },
            2
        );
        assertEquals(0, ans1);
    }

}