package leetcode;

import org.junit.jupiter.api.Test;
import static leetcode.MergeNodesInBetweenZeros.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeNodesInBetweenZerosTest {

    @Test
    void mergeNodes() {
        ListNode input = createList(new int[]{0, 3, 1, 0, 4, 5, 2, 0});
        ListNode expected = createList(new int[]{4, 11});
        ListNode ans1 = new MergeNodesInBetweenZeros().mergeNodes(input);
        assertEquals(listToString(expected), listToString(ans1));
    }

    private MergeNodesInBetweenZeros.ListNode createList(int[] values) {
        MergeNodesInBetweenZeros.ListNode dummy = new MergeNodesInBetweenZeros.ListNode();
        MergeNodesInBetweenZeros.ListNode curr = dummy;
        for (int value : values) {
            curr.next = new MergeNodesInBetweenZeros.ListNode(value);
            curr = curr.next;
        }
        return dummy.next;
    }

    private String listToString(MergeNodesInBetweenZeros.ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        sb.append("null");
        return sb.toString();
    }

}