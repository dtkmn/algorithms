package leetcode;


/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 */
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        result.next = l1 != null ? l1 : l2;

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        mergeTwoLists(l1, null);
    }

}
