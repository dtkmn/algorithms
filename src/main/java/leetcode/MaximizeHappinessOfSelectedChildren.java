package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximize-happiness-of-selected-children/">...</a>
 *
 s */

public class MaximizeHappinessOfSelectedChildren {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int step = 0;
        long ans = 0L;
        for (int i = happiness.length - 1; i >= 0; i--) {
            if (step == k) break;
            if (happiness[i] - step > 0) {
                ans += (happiness[i] - step);
            }
            step++;
        }
        return ans;
    }

}
