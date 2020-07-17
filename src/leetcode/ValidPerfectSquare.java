package leetcode;


/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    // Binary Search Approach
    // 0ms
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isPerfectSquare(int num) {

        if (num < 2) return true;

        int l = 2, r = num / 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long m = (long)mid * mid;
            if (m > num) r = mid - 1;
            else if(m < num) l = mid + 1;
            else return true;
        }

        return false;

    }


    public static void main(String[] args) {

    }

}
