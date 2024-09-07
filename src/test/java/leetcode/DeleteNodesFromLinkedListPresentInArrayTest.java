package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodesFromLinkedListPresentInArrayTest {

    @Test
    void modifiedList() {
        DeleteNodesFromLinkedListPresentInArray system = new DeleteNodesFromLinkedListPresentInArray();
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
        ListNode ans1 = system.modifiedList(new int[]{1, 2, 3}, head);
        assertEquals(4, ans1.val);
        assertEquals(5, ans1.next.val);
    }
}