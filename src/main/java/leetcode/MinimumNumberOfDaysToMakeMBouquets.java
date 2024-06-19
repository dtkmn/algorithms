package leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/">1482. Minimum Number of Days to Make m Bouquets</a>
 */
public class MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int size = bloomDay.length;
        if (m * k > size) return -1;
        int min = 1;
        int max = Integer.MIN_VALUE;
        for (int bloom: bloomDay) {
             max = Math.max(max, bloom);
        }

        // Using Binary Search
        int ans = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (getBouquets(mid, bloomDay, k) >= m) {
                max = mid - 1;
                ans = mid;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }

    private int getBouquets(int day, int[] bloomDay, int k) {
        int count = 0;
        int match = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                match++;
            } else {
                match = 0;
            }
            if (match == k) {
                count++;
                match = 0;
            }
        }
        return count;
    }

}
