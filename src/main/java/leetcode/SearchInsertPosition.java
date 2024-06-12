package leetcode;


/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (start >= end) {
            if (nums[start] == target) return start;
            else return nums[start] > target ? start : start + 1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else return binarySearch(nums, mid + 1, end, target);
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    }

}
