package leetcode;


/**
 *  <a href="https://leetcode.com/problems/winner-of-the-linked-list-game/">...</a>
 */

public class WinnerOfTheLinkedListGame {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public String gameResult(ListNode head) {
        ListNode current = head;
        int countOdd = 0, countEven = 0;
        while (current != null) {
            int even = current.val;
            current = current.next;
            int odd = current.val;
            if (even > odd) countEven++;
            else countOdd++;
            current = current.next;
        }
        if (countOdd == countEven) return "Tie";
        else if(countOdd > countEven) return "Odd";
        else return "Even";
    }

    public static void main(String[] args) {
    }

}
