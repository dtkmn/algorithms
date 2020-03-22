package leetcode;


/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 */
public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode current = head, tail = null;
        ListNode newHead = null;

        while (current != null) {
            ListNode[] nodes = reverseListInNumber(current, 2);
            // Store head for 'first loop'
            if (newHead == null) newHead = nodes[0];
            // only for tail after first loop
            if (tail != null) tail.next = nodes[0];
            tail = nodes[1];

            current = nodes[1].next;
        }

        return newHead;
    }

    public static ListNode[] reverseListInNumber(ListNode head, int k) {
        if (head == null) return null;
        int count = 0;
        ListNode current = head, pre = null, next = null;
        while (current != null && ++count <= k) {
            // store next pointer
            next = current.next;
            // point current.next to previous node
            current.next = pre;
            // keep looping through current node list
            pre = current;
            current = next;
        }
        // head become last node and should point to proper next node
        head.next = current;
        return new ListNode[] {pre, head};
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);

        print(swapPairs(head));

    }

}
