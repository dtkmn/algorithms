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

    public static void test() {
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        n1.next = n2;
//        n2.next = n3;
        ListNode reverseList = reverseList(n1);

        System.out.println(reverseList);

    }

    public static void main(String[] args) {

        test();

    }

}
