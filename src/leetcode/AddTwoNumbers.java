package leetcode;

/**
 * Created by datse on 18/08/2015.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

    }

//    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode firstNode = new ListNode(0);
        ListNode currentNode = firstNode;
        while(l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            int modVal = sum % 10;
            currentNode.next = new ListNode(modVal);
            currentNode = currentNode.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if (carry == 1) currentNode.next = new ListNode(carry);
        return firstNode.next;
    }

}
