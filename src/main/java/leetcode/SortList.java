package leetcode;

/**
 * <a href="https://leetcode.com/problems/sort-list/">...</a>
 */
public class SortList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Using 2 pointers approach
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null; // Split the list in 2 parts
        return slow;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public static ListNode sortListWithoutRecursion(ListNode head) {
        if (head == null || head.next == null) return head;

        // Get the length of the list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        for (int size = 1; size < length; size *= 2) {
            ListNode prev = dummy;
            current = dummy.next;

            while (current != null) {
                ListNode left = current, right = null;
                ListNode leftTail = null, rightTail = null;

                // Go through the size to right
                for (int i = 0; i < size; i++) {
                    leftTail = current;
                    current = current.next;
                }
                if (leftTail != null) leftTail.next = null; // Split the list in 2 parts

                if (current != null) {
                    right = current;
                    // Then go through the size again to next 'slot'
                    for (int i = 0; i < size && current != null; i++) {
                        rightTail = current;
                        current = current.next;
                    }
                }
                if (rightTail != null) rightTail.next = null; // Split the list in 2 parts

                ListNode merged = merge(left, right);
                // Linking all merged lists tgt
                prev.next = merged;
                while (prev.next !=null) prev = prev.next;
            }
        }
        return dummy.next;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if (left != null) current.next = left;
        if (right != null) current.next = right;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);
        ListNode three = new ListNode(3);
        ListNode zero = new ListNode(0);
        head.next = two;
        two.next = one;
//        one.next = three;
//        three.next = zero;
        ListNode output = sortListWithoutRecursion(head);
        System.out.println(output.val);
    }

}
