package leetcode;

/**
 *      <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">...</a>
 */
public class ConvertSortedArrayToBinarySearchTree {

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int lo, int hi) {
        if (lo > hi) return null;

        int mid = lo + (hi - lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(lo, mid - 1);
        root.right = helper(mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {

    }

}
