package leetcode;

/*
   https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(
            isPalindrome("A man, a plan, a canal: Panama")
        );

        System.out.println(
            isPalindrome("0P")
        );
    }

    // Time Complexity: O(N) i.e. Length of String s
    // Space Complexity: O(1) using input String or O(N) i.e. char array
    public static boolean isPalindrome(String s) {
        char[] sa = s.toCharArray();
        int front = 0, end = sa.length - 1;
        while (front < end) {
            if (!Character.isLetterOrDigit(sa[front])) {
                front++;
            }
            else if (!Character.isLetterOrDigit(sa[end])) {
                end--;
            }
            else if (Character.toLowerCase(sa[front]) != Character.toLowerCase(sa[end])) {
                return false;
            }
            else {
                front++; end--;
            }
        }
        return true;
    }

}
