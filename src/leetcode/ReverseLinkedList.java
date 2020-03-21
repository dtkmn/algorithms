package leetcode;


/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // Iteratively
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode currentHead = new ListNode(head.val);
        while (head.next != null) {
            ListNode n = head.next;
            ListNode tmp = currentHead;
            currentHead = new ListNode(n.val);
            currentHead.next = tmp;
            head = head.next;
        }
        return currentHead;
    }

    // I think this is more concise version
    public static ListNode reverseList2(ListNode head) {
        if (head == null) return null;

        ListNode current = head, pre = null, next;
        while (current != null) {
            // store next pointer
            next = current.next;
            // point current.next to previous node
            current.next = pre;
            // keep looping through current node list
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        print(reverseList2(head));

    }

}
