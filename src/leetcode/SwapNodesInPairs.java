package leetcode;


/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">...</a>
 *
 */
public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) { val = x; }
    }

    /**
     * Time Complexity O(N), N is the size of LinkedList
     * Space Complexity O(N) stack space utilized for recursion
     * @param head
     * @return
     */
    public ListNode swapPairs_recur(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs_recur(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    /**
     * Time Complexity O(N), N is the size of LinkedList
     * Space Complexity O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs_it(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode firstNode = head;
        ListNode prev = newHead;
        ListNode secondNode = head.next;
        // #1: prev -> firstNode -> secondNode
        // #2: firstNode -> firstNode.next -> firstNode.next.next
        while (firstNode != null && secondNode != null) {

            firstNode.next = secondNode.next;

            prev.next = secondNode;
            secondNode.next = firstNode;

            prev = firstNode;
            firstNode = firstNode.next;
            secondNode = firstNode != null? firstNode.next: null;
        }
        return newHead.next;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        print(new SwapNodesInPairs().swapPairs_recur(head));
    }

}
