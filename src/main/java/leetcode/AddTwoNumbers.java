package leetcode;

/*
    https://leetcode.com/problems/add-two-numbers
 */

public class AddTwoNumbers {

    public static void main(String[] args) {

//        ListNode i1 = new ListNode(2);
//        i1.next = new ListNode(4);
//        i1.next.next = new ListNode(3);
//        ListNode i2 = new ListNode(5);
//        i2.next = new ListNode(6);
//        i2.next.next = new ListNode(4);

//        ListNode i1 = new ListNode(1);
//        i1.next = new ListNode(8);
//        ListNode i2 = new ListNode(0);

        //        [9]
        //        [1,9,9,9,9,9,9,9,9,9]
        ListNode i1 = new ListNode(9);
        ListNode i2 = new ListNode(1);
        i2.next = new ListNode(9);
        i2.next.next = new ListNode(9);
        i2.next.next.next = new ListNode(9);
        i2.next.next.next.next = new ListNode(9);
        i2.next.next.next.next.next = new ListNode(9);
        i2.next.next.next.next.next.next = new ListNode(9);
        i2.next.next.next.next.next.next.next = new ListNode(9);
        i2.next.next.next.next.next.next.next.next = new ListNode(9);
        i2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbers2(i1, i2);

        System.out.println(listNode);

    }

//    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Look more elegant with single while loop
    // Time Complexity: O(MAX(l1.length + l2.length))
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(-1);
        ListNode node = res;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int total = x + y + carry;
            carry = total >= 10 ? 1: 0;

            node.next = new ListNode(total % 10);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            node = node.next;

        }

        if (carry == 1) node.next = new ListNode(carry);

        return res.next;

    }

    //      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    //      Output: 7 -> 0 -> 8
    //      Explanation: 342 + 465 = 807.
    // Time Complexity: O(MAX(l1,l2))
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(-1);
        ListNode node = res;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int t = l1.val + l2.val + carry;
            if (t >= 10) carry = 1;
            else carry = 0;

            node.next = new ListNode(t%10);

            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode cont = l1 != null ? l1 : l2;
        while (cont != null) {
            int t = cont.val + carry;
            if (t >= 10) carry = 1;
            else carry = 0;

            node.next = new ListNode(t%10);

            node = node.next;
            cont = cont.next;
        }

        if (carry == 1) node.next = new ListNode(carry);

        return res.next;

    }

}
