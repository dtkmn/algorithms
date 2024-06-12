package leetcode;


/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 */
public class FindTheDuplicateNumber {

    // Cycle Detecting Approach
    // For this problem, we suppose the cycle must exist within input
    public static int findDuplicate(int[] nums) {

        int start = nums[0];
        int tortoise = nums[start];
        int hare = nums[nums[start]];

        // Find intersection point
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        // find the cycle entry point
        int pt1 = tortoise;
        int pt2 = nums[0];

        while (pt1 != pt2) {
            pt1 = nums[pt1];
            pt2 = nums[pt2];
        }

        return pt1;

    }


    // 1ms
    // Cyclic Sort Approach
    public static int findDuplicate_cyclicsort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) i++;
            else {
                if (nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                } else {
                    // swap
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 4, 4, 3, 2};
        System.out.println(
            findDuplicate(input)
        );
    }

}
