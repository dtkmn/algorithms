package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/insertion-sort-list/">...</a>
 */
public class InsertionSortList {

     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;
        // Start from the head...
        while (curr != null) {
            ListNode prev = dummy;
            // Go through to the proper node to insert
            while (prev.next != null && prev.next.val < curr.val ) {
                prev = prev.next;
            }

            ListNode next = curr.next;
            // *When it is in the tail, prev.next would be null
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
