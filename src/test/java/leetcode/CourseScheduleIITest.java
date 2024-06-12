package leetcode;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleIITest {

    @Test
    public void testSimpleCase() {
        // Test case where prerequisites are simple and the course order is straightforward
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[] expectedOutput = {0, 1};
        assertArrayEquals(expectedOutput, new CourseScheduleII().findOrder(numCourses, prerequisites),
                "The course order should be [0, 1]");
    }

    @Test
    public void testMultipleDependencies() {
        // Test case with multiple dependencies
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 1}};
        int[] result = new CourseScheduleII().findOrder(numCourses, prerequisites);
        int[] correctPossibleOrder1 = {0, 1, 2, 3};
        int[] correctPossibleOrder2 = {0, 1, 3, 2};
        // Ensure the result is one of the possible correct orders
        assertTrue(Arrays.equals(result, correctPossibleOrder1) || Arrays.equals(result, correctPossibleOrder2),
                "The course order should satisfy one of the correct orders");
    }

    @Test
    public void testNoPrerequisites() {
        // Test case with no prerequisites
        int numCourses = 3;
        int[][] prerequisites = {};
        int[] expectedOutput = {0, 1, 2};  // Any order is valid if there are no prerequisites
        assertArrayEquals(expectedOutput, new CourseScheduleII().findOrder(numCourses, prerequisites),
                "Any order of courses is valid when there are no prerequisites");
    }

    @Test
    public void testImpossibleSchedule() {
        // Test case where no valid order can be completed because of a cycle
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}, {1, 0}};
        int[] expectedOutput = {};  // No valid order exists
        assertArrayEquals(expectedOutput, new CourseScheduleII().findOrder(numCourses, prerequisites),
                "There should be no valid order when a cycle exists");
    }

}