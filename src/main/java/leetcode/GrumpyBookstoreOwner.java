package leetcode;

/**
 * <a href="https://leetcode.com/problems/grumpy-bookstore-owner/">1052. Grumpy Bookstore Owner</a>
 */
public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0, right = 0;
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int ans = total;
        while (right < customers.length) {
            if (right - left + 1 <= minutes) {
                if (grumpy[right] == 1) {
                    total += customers[right];
                    ans = Math.max(ans, total);
                }
                right++;
            } else {
                if (grumpy[left] == 1) {
                    total -= customers[left];
                }
                left++;
            }
        }
        return ans;
    }

}
