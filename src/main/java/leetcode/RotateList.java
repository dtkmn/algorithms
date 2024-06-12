package leetcode;


/**
 * https://leetcode.com/problems/rotate-list/
 *
 */
public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 0ms
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0 || head.next == null) return head;

        int count = 0;
        ListNode current = head, pre = null, tail;
        // First loop through the list and count the total
        while (current != null) {
            ++count;
            pre = current;
            current = current.next;
        }
        tail = pre;

        // when the length is equals to k or able to be factorized
        // nothing change
        if (count == k || k % count == 0) return head;

        // Calculate the step required to get the front of new list
        int step = count - k % count;
        System.out.println("Step: " + step);

        current = head; count = 0;
        ListNode newHead = null;
        while (current != null && ++count <= step) {
            // when find the new front node
            if (count == step) {
                newHead = current.next;
                tail.next = head;
                current.next = null;
                break;
            }
            current = current.next;
        }

        return newHead;

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

//        ListNode head = new ListNode(3);
//        head.next = new ListNode(5);
//        head.next.next = new ListNode(6);
//        head.next.next.next = new ListNode(8);
//        head.next.next.next.next = new ListNode(10);
//
//        print(rotateRight(head, 3));


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        print(rotateRight(head, 8));



    }

}
