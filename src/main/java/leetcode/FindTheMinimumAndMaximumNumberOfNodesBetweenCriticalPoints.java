package leetcode;

/**
 * <a href="https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/">2058. Find the Minimum and Maximum Number of Nodes Between Critical Points</a>
 */
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head, curr = prev.next;
        int cnum = 2;
        int first = -1, last = -1;
        int min = Integer.MAX_VALUE;
        while (curr != null && curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val)
                    || (curr.val < prev.val && curr.val < curr.next.val)) {
                if (last != -1) {
                    min = Math.min(min, cnum - last);
                }
                if (first == -1) {
                    first = cnum;
                }
                last = cnum;
            }
            prev = curr;
            curr = curr.next;
            cnum++;
        }
        if (last == first) return new int[] { -1, -1 };
        int max = last - first;
        return new int[] {min, max};
    }
}
