package leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPointsTest {

    @Test
    void nodesBetweenCriticalPoints() {
        FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.ListNode input1 = createList(new int[]{3, 1});
        int[] ans1 = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints().nodesBetweenCriticalPoints(input1);
        assertArrayEquals(new int[] {-1, -1}, ans1);

        FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.ListNode input2 = createList(new int[]{5,3,1,2,5,1,2});
        int[] ans2 = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints().nodesBetweenCriticalPoints(input2);
        assertArrayEquals(new int[] {1, 3}, ans2);
    }

    private FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.ListNode createList(int[] values) {
        FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.ListNode dummy = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.ListNode();
        FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.ListNode curr = dummy;
        for (int value : values) {
            curr.next = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints.ListNode(value);
            curr = curr.next;
        }
        return dummy.next;
    }

}