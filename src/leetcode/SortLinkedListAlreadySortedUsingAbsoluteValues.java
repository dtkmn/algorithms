package leetcode;

/**
 * <a href="https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values/">...</a>
 */
public class SortLinkedListAlreadySortedUsingAbsoluteValues {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortLinkedList(ListNode head) {
        ListNode current = head.next, prev = head;
        while (current != null) {
            if (current.val < 0) {
                prev.next = current.next;
                current.next = head;
                head = current;
                current = prev.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
    }

}
