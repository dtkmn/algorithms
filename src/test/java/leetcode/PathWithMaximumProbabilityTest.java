package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathWithMaximumProbabilityTest {

    @Test
    void maxProbability() {
        PathWithMaximumProbability system = new PathWithMaximumProbability();
        double ans1 = system.maxProbabilityBellmanFord(
            3,
            new int[][]{
                {0, 1},
                {1, 2},
                {0, 2}
            },
            new double[]{ 0.5, 0.5, 0.2 },
            0,
            2
        );
        assertEquals(0.25, ans1);
    }
}