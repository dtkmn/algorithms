package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximizeHappinessOfSelectedChildrenTest {

    @Test
    public void testSimpleCase() {
        int k = 3;
        int[] happiness = {12, 1, 42};
        int expectedOutput = 53;
        assertEquals(expectedOutput, new MaximizeHappinessOfSelectedChildren().maximumHappinessSum(happiness, k),
                "The result should be 53");
    }

}