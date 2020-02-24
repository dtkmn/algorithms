package leetcode;


/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 */
public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        // Initialize slow and fast pointers
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        // Finding intersection point when there's cycle
        ListNode intersect = null;
        while (slow != null && fast != null) {
            // when slow and fast pointer met, cycle exists!
            if (slow == fast) {
                intersect = slow;
                break;
            }
            slow = slow.next;
            if (fast.next == null) fast = null;
            else fast = fast.next.next;
        }

        // When cycle not exist
        if (intersect == null) return null;

        // Finding start of cycle
        ListNode front = intersect;
        ListNode back = head;
        while (front != back) {
            front = front.next;
            back = back.next;
        }

        return front;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(0);
//        ListNode l4 = new ListNode(-4);

        l1.next = l2;
        l2.next = l1;
//        l3.next = l4;
//        l4.next = l2;

        System.out.println(
            LinkedListCycleII.detectCycle(l1).val
        );
    }

}
