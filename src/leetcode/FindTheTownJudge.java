package leetcode;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 *
 */
public class FindTheTownJudge {

    // 25ms
    // Time Complexity: O(n2)
    // Space Complexity: O(n2)
    public static int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            if (N == 1) return 1;
            else return -1;
        }

        // Create the 2d array to save the status
        // Space Complexity: O(n2)
        int[][] map = new int[N][N];
        for (int[] item: trust) {
            map[item[0] - 1][item[1] - 1] = 1;
        }

        // Time Complexity: O(n2)
        for (int i = 0; i < N; i++) {
            int zeroCount = 0, oneCount = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) zeroCount++;
                if (map[j][i] == 1) oneCount++;
            }
            if (zeroCount == 0 && oneCount == N - 1) return i + 1;
        }

        return -1;
    }

    // 3ms
    // Time Complexity: O(Number of trust)
    // Space Complexity: O(N)
    public static int findJudge2(int N, int[][] trust) {
        if (trust.length == 0) {
            if (N == 1) return 1;
            else return -1;
        }

        int[] out = new int[N+1];
        int[] in = new int[N+1];
        // Time Complexity: O(Number of trust)
        for (int[] item: trust) {
            // Number of 'arrow' going outward ...
            out[item[0]]++;
            // the node receive....
            in[item[1]]++;
        }

        // Time Complexity: O(N)
        for (int i = 1; i <= N; i++) {
            // judge should receive all trust from others (N-1) and no arrow outwards
            if (out[i] == 0 && in[i] == N - 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge2(2, new int[][] { {1, 2} }));
    }

}
