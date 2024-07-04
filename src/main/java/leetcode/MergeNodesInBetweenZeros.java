package leetcode;

/**
 *      <a href="https://leetcode.com/problems/merge-nodes-in-between-zeros/">2181. Merge Nodes in Between Zeros</a>
 */
public class MergeNodesInBetweenZeros {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head;
        ListNode newHead = new ListNode(), prev = newHead;
        int sum = 0;
        while (curr != null) {
            if (curr.val == 0 && sum > 0) {
                prev.next = new ListNode(sum);
                prev = prev.next;
                sum = 0;
            } else {
                sum += curr.val;
            }
            curr = curr.next;
        }
        return newHead.next;
    }

}
