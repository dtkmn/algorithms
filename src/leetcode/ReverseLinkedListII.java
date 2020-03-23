package leetcode;


/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 */
public class ReverseLinkedListII {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (head.next == null || m == n) return head;

        int pos = 0;
        ListNode current = head, next, pre = null;
        ListNode nodeBeforeSubarray = null, nodeStartSubarray = null, nodeEndSubarray = null;

        while (current != null) {
            pos++;
            next = current.next;

            // When on start of subarray
            if (pos == m) {
                // Reverse may happen from start and could be null value
                nodeBeforeSubarray = pre;
                if (nodeBeforeSubarray != null) nodeBeforeSubarray.next = null;
                // First node will become last
                nodeEndSubarray = current;
                nodeEndSubarray.next = null;
            } else if (pos == n) {
                // Reverse may happen from start and could be null value
                if (nodeBeforeSubarray != null) nodeBeforeSubarray.next = current;
                nodeStartSubarray = current;
                if (nodeEndSubarray != null) nodeEndSubarray.next = next;
            }

            if (pos > m && pos <= n) {
                current.next = pre;
            }

            pre = current;
            current = next;
        }

        if (nodeBeforeSubarray != null) {
            return head;
        }
        else {
            return nodeStartSubarray;
        }

    }

    public static void print(ListNode node) {
        System.out.print("[ ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        print(reverseList2(head));

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        print(reverseBetween(head, 2, 4));

        // [5], 1
        ListNode head2 = new ListNode(5);
        print(reverseBetween(head2, 1, 1));

    }

}
