package leetcode;


/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 */

public class UniqueBinarySearchTrees {

    // Using DP Approach
    // Time Complexity: O(N2)
    // Space Complexity: O(N)
    public static int numTrees(int n) {

        int[] count = new int[n + 1];

        count[0] = 1;
        count[1] = 1;
        count[2] = 2;

        if (count[n] != 0) return count[n];

        // Get from count[1] to count[n]
        // G(n) = ∑ i=1ton,  G(i−1)⋅G(n−i)
        for (int j = 3; j <= n; j++) {
            int total = 0;
            for (int i = 1; i <= j; i++) {
                int llen = i - 1;
                int rlen = j - i;
                total += (count[llen] * count[rlen]);
            }
            count[j] = total;
        }

        return count[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
        System.out.println(numTrees(6));
    }

}
