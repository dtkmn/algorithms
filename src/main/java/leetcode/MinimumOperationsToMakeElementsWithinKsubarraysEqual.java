package leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/">3505. Minimum Operations to Make Elements Within K Subarrays Equal</a>
 * <p>n = input length, x = window length, k = number of groups, w = n - x + 1 possible windows.
 * Space below means extra memory live at one time, excluding the input.
 * Array lookups, integer arithmetic, comparisons, assignments and returns each cost O(1)
 * time and no growing space. Loop comments give the cost of the whole loop.
 *
 * <p>Building all window costs takes O(n log x) time. The DP adds O(n*k) time
 * and uses O(n*k) peak extra space.
 */
public class MinimumOperationsToMakeElementsWithinKsubarraysEqual {

    private long[][] cost;
    private long[] windowCost;

    public long minOperations(int[] nums, int x, int k) {
        // Java zero-initializes new arrays. All (k + 1) rows of n longs: O(n*k) time and space.
        cost = new long[k+1][nums.length];
        windowCost = buildWindowCosts(nums, x);

        // Each fill writes n cells in an existing row: O(n*k) time total, O(1) additional space.
        for (long[] row : cost) {
            Arrays.fill(row, -1L);
        }
        // Starts the recursive search; skip can keep O(n) calls on the stack at once.
        return best(nums, x, k, 0);
    }

    class Half {
        TreeMap<Integer, Integer> map;
        int count;
        long sum;
        Half() {
            map = new TreeMap<>();
            count = 0;
            sum = 0;
        }
        void add(int val) {
            map.merge(val, 1, Integer::sum);
            count++;
            sum += val;
        }
        void remove(int val) {
            int c = map.get(val);
            if (c == 1) map.remove(val);
            else map.put(val, c - 1);
            count--;
            sum -= val;
        }
    }

    private long[] buildWindowCosts(int[] nums, int x) {
        // costs[start] is the number of moves for nums[start] through nums[start + x - 1].
        // The last valid start is nums.length - x, so we need one more slot than that index.
        long[] costs = new long[nums.length - x + 1];
        // Reuse these same two halves as the window slides. Half.add/remove already
        // update the frequency, the number of elements (including duplicates), and the sum.
        Half lower = new Half();
        Half upper = new Half();

        // For each right index from 0 through nums.length - 1:
        for (int right = 0; right < nums.length; right++) {
            // 1. Add nums[right]. If lower is empty or the value <= lower.map.lastKey(),
            //    add it to lower. Otherwise add it to upper. This keeps the halves in order.
            if (lower.count == 0 || nums[right] <= lower.map.lastKey()) {
                lower.add(nums[right]);
            } else {
                upper.add(nums[right]);
            }

            // 2. If right >= x, we just added an (x + 1)th element. Remove one copy of
            //    nums[right - x] from lower if lower contains that key, otherwise from upper.
            //    For [1, -2, 3, -100] and x = 3, adding -100 at right = 3 evicts nums[0] = 1.
            if (right >= x) {
                int toRemove = nums[right - x];
                if (lower.map.containsKey(toRemove)) {
                    lower.remove(toRemove);
                } else {
                    upper.remove(toRemove);
                }
            }

            // 3. Balance the element counts so lower has either as many elements as upper
            //    or one extra. If lower.count > upper.count + 1, move lower.map.lastKey() up.
            //    If upper.count > lower.count, move upper.map.firstKey() down.
            //    Move one copy with remove(value) on its old half and add(value) on its new half.
            if (lower.count > upper.count + 1) {
                int toMove = lower.map.lastKey();
                lower.remove(toMove);
                upper.add(toMove);
            } else if (upper.count > lower.count) {
                int toMove = upper.map.firstKey();
                upper.remove(toMove);
                lower.add(toMove);
            }

            // 4. Record a cost only when right >= x - 1. With x = 3, right = 2 is the
            //    first full window; right = 3 is the first time a number also has to leave.
            //    Use long median = lower.map.lastKey(). To bring each number to that median:
            //      lower needs increments = median * lower.count - lower.sum;
            //      upper needs decrements = upper.sum - median * upper.count.
            //    Save their sum at costs[right - x + 1], the current window's START index.
            if (right >= x - 1) {
                long median = lower.map.lastKey();
                long increments = median * lower.count - lower.sum;
                long decrements = upper.sum - median * upper.count;
                costs[right - x + 1] = increments + decrements;
            }
        }
        // After the loop, return costs. All windows together take O(n log x) time,
        // with O(x) working space for the maps plus O(n - x + 1) for the output.
        return costs;
    }

    private long best(int[] nums, int x, int k, int start) {
        // Each base case or memo hit returns in O(1) time. Each call uses O(1) local space.
        if (k == 0) return 0;
        if (k * x > nums.length - start) return Long.MAX_VALUE;
        if (cost[k][start] != -1L) return cost[k][start];
        // Take: read this window's saved cost, then solve the suffix starting x positions later.
        long take = windowCost[start] + best(nums, x, k - 1, start + x);
        // Skip: solve the suffix starting one position later, still needing k groups.
        // Each uncached (k, start) branches only once: O(n*k) calls total, including memo hits.
        long skip = best(nums, x, k, start + 1);
        // Comparing and storing the cheaper branch costs O(1) once both calls return.
        cost[k][start] = Math.min(take, skip);
        return cost[k][start];
    }

    private long best2(int n, int x, int k) {
        // Row 0 is already all zeros: choosing zero windows costs zero moves.
        for (int groups = 1; groups <= k; groups++) {
            // Starts too close to the end to fit this many windows stay impossible.
            Arrays.fill(cost[groups], Long.MAX_VALUE);
            int lastStart = n - groups * x;

            for (int start = lastStart; start >= 0; start--) {
                // Take this window. Jump past its x elements and choose one fewer group.
                long take = windowCost[start] + cost[groups - 1][start + x];

                // Skip this index. We still need the same number of groups.
                long skip = cost[groups][start + 1];

                cost[groups][start] = Math.min(take, skip);
            }
        }
        return cost[k][0];
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeElementsWithinKsubarraysEqual solution = new MinimumOperationsToMakeElementsWithinKsubarraysEqual();
        int[] nums = {1, 2, 3, 4, 5};
        int x = 2;
        int k = 2;
        long result = solution.minOperations(nums, x, k);
        System.out.println("Minimum operations: " + result);

    }

}
