package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 *      <a href="https://leetcode.com/problems/largest-submatrix-with-rearrangements/">...</a>
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Long s = set.ceiling((long) nums[i]);
            if (s != null && (long) s <= nums[i] + valueDiff) return true;

            // Find the predecessor of current element
            Long g = set.floor((long) nums[i]);
            if (g != null && nums[i] <= (long) g + valueDiff) return true;

            set.add((long) nums[i]);
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int head = 0;
        int tail = head + 1;
        while (head < nums.length - 1 && tail < nums.length) {
            int vDiff = Math.abs(nums[tail] - nums[head]);
            int iDiff = Math.abs(tail - head);
            if (vDiff <= valueDiff && iDiff <= indexDiff) return true;
            if (iDiff >= indexDiff) {
                head++;
                tail = head + 1;
            }
            else {
                tail++;
                if (tail >= nums.length) {
                    head++;
                    tail = head + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                new ContainsDuplicateIII().containsNearbyAlmostDuplicate(
                        new int[] {4,1,-1,6,5},
                        3,
                        1
                )
        );
//        System.out.println(
//            new ContainsDuplicateIII().containsNearbyAlmostDuplicate(
//              new int[] {1,2,3,1},
//              3,
//              0
//            )
//        );
//        System.out.println(
//                new ContainsDuplicateIII().containsNearbyAlmostDuplicate(
//                        new int[] {1,2,2,3,4,5},
//                        3,
//                        0
//                )
//        );
    }

}
