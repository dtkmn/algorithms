package leetcode;


/**
 *  <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">974. Subarray Sums Divisible by K</a>
 */

public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        // Formula: prefix_sum[j] % k == prefix_sum[i] % k implies
        // (prefix_sum[j] - prefix_sum[i]) % k == 0
        // i.e., the subarray sum from index i+1 to j is a multiple of k
        int[] modCount = new int[k]; // we know mod always less than k
        modCount[0] = 1; // For prefixSum is divided by k first time
        int prefixSum = 0;
        int count = 0;
        for (int num: nums) {
            prefixSum += num;
            int mod = prefixSum % k;
            if (mod < 0) { // We keep the mod value in range [0, k}
                mod += k;
            }
            count += modCount[mod];
            modCount[mod]++;
        }
        return count;
    }

}
