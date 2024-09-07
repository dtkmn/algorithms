package leetcode;

import leetcode.common.ListNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array">3217. Delete Nodes From Linked List Present in Array</a>
 *
 */

public class DeleteNodesFromLinkedListPresentInArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        ListNode beforeHead = new ListNode(-1, head);
        ListNode current = head, prev = beforeHead;
        while (current != null) {
            if (set.contains(current.val)) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return beforeHead.next;
    }

}
