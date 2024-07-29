package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-convert-string-i/">2976. Minimum Cost to Convert String I</a>
 *
 */
public class MinimumCostToConvertStringI {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] matrix = new long[26][26];
        for (int row = 0; row < matrix.length; row++) {
            Arrays.fill(matrix[row], Integer.MAX_VALUE);
            matrix[row][row] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            matrix[original[i] - 'a'][changed[i] - 'a'] = Math.min(matrix[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        floydWarshall(matrix);

        long ans = 0L;
        for (int j = 0; j < source.length(); j++) {
            if (matrix[source.charAt(j) - 'a'][target.charAt(j) - 'a'] == Integer.MAX_VALUE) {
                return -1;
            }
            ans += matrix[source.charAt(j) - 'a'][target.charAt(j) - 'a'];
        }

        return ans;
    }

    private void floydWarshall(long[][] matrix) {
        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][m] + matrix[m][j]);
                }
            }
        }
    }

}
