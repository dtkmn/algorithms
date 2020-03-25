package leetcode;


/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 */
public class ReverseNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 0ms
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head, tail = null;
        ListNode newHead = null;

        while (current != null) {
            ListNode[] nodes = reverseListInNumberButNotLess(current, k);
            if (newHead == null) newHead = nodes[0];
            if (tail != null) tail.next = nodes[0];
            tail = nodes[1];

            if (nodes[1] != null) current = nodes[1].next;
            else break;
        }

        return newHead;
    }

    // Reverse the list in next k nodes, if nodes less than k , don't reverse
    public static ListNode[] reverseListInNumberButNotLess(ListNode head, int k) {
        if (head == null) return null;
        int count = 0;
        ListNode current = head, pre = null, next;
        // First loop through k items to check if it is end of the list
        while (current != null && ++count <= k) {
            current = current.next;
        }
        // if less than k, just return original head and null tail
        if (count < k) return new ListNode[] {head, null};

        // if not, normal process to reverse the list
        // Reset to proper head and count value
        current = head; count = 0;
        while (current != null && ++count <= k) {
            // store next pointer
            next = current.next;
            // point current.next to previous node
            current.next = pre;
            // keep looping through current node list
            pre = current;
            current = next;
        }
        head.next = current;
        // return the head and tail from this reverse list
        return new ListNode[] {pre, head};
    }

    // Reverse the list in next k nodes, if nodes less than k, still reverse
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
        head.next = current;
        // return the head and tail from this reverse list
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

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        print(reverseList2(head));

//        ListNode head = new ListNode(2);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(6);
//        head.next.next.next = new ListNode(8);
//        head.next.next.next.next = new ListNode(10);
//        print(reverseBetween(head, 2, 4));

        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        print(reverseKGroup(head, 3));



    }

}
