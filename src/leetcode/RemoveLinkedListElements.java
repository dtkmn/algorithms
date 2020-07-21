package leetcode;


/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        // Get the correct head first
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode pre = head, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode res = removeElements(head, 6);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

}
