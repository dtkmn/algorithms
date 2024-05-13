package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreAfterFlippingMatrixTest {

    @Test
    void simpleTestCase() {
        assertEquals(39, new ScoreAfterFlippingMatrix().matrixScore(
            new int[][]{
                new int[]{0, 0, 1, 1},
                new int[]{1, 0, 1, 0},
                new int[]{1, 1, 0, 0}
            }
        ));
    }

}