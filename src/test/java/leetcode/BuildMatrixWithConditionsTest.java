package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildMatrixWithConditionsTest {

    @Test
    void buildMatrix() {
        BuildMatrixWithConditions system = new BuildMatrixWithConditions();
        int[][] ans1 = system.buildMatrix(
            3,
            new int[][]{
                {1, 2},
                {3, 2}
            },
            new int[][]{
                {2, 1},
                {3, 2}
            }
        );
        // There could be multiple answers on same input
        int[][] expect1 = new int[][] {
            new int[] { 0, 0, 1 },
            new int[] { 3, 0, 0 },
            new int[] { 0, 2, 0 },
        };
        assertArrayEquals(expect1, ans1);

        int[][] ans2 = system.buildMatrix(
            3,
            new int[][]{
                {1, 2},
                {2, 3},
                {3, 1},
                {2, 3},
            },
            new int[][]{
                {2, 1}
            }
        );
        assertArrayEquals(new int[0][0], ans2);
    }
}