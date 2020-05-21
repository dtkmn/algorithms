package leetcode;

/*
    https://leetcode.com/problems/add-two-numbers-ii/
 */

import java.util.Stack;

public class AddTwoNumbersII {

    public static void main(String[] args) {

        ListNode i1 = new ListNode(7);
        i1.next = new ListNode(2);
        i1.next.next = new ListNode(4);
        i1.next.next.next = new ListNode(3);

        ListNode i2 = new ListNode(5);
        i2.next = new ListNode(6);
        i2.next.next = new ListNode(4);


        ListNode listNode = addTwoNumbersII(i1, i2);

        System.out.println(listNode);

    }

//    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /*
        Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 8 -> 0 -> 7
        Time Complexity: O(MAX(l1.length, l2.length))
     */
    public static ListNode addTwoNumbersII(ListNode l1, ListNode l2) {

        // Space Complexity: O(l1.length + l2.length)
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        while (l1 != null) {
            l1Stack.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Stack.add(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode pre = null;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            int x = !l1Stack.isEmpty() ? l1Stack.pop(): 0;
            int y = !l2Stack.isEmpty() ? l2Stack.pop(): 0;
            int total = x + y + carry;
            carry = total >= 10 ? 1 : 0;
            ListNode node = new ListNode(total % 10);
            node.next = pre;
            pre = node;
        }

        if (carry == 1) {
            ListNode n = new ListNode(carry);
            n.next = pre;
            pre = n;
        }

        return pre;

    }

}
