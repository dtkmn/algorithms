package leetcode;

/**
 *  <a href="https://leetcode.com/problems/solving-questions-with-brainpower/">2140. Solving Questions With Brainpower</a>
 *
 */
public class SolvingQuestionsWithBrainpower {

    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        // Arrays.fill(memo, -1L);
        // return best(questions, 0, memo);
        return best2(questions, memo);
    }

    /**
     * Recursive solution with memoization.
     * @param questions The array of questions, where each question is represented as an array of two integers: [points, brainpower].
     * @param start The current index in the questions array.
     * @param memo An array to store the maximum points that can be obtained from each question index.
     * @return The maximum points that can be obtained starting from the given index.
     */
    public long best(int[][] questions, int start, long[] memo) {
        if (start >= questions.length) return 0;
        if (memo[start] != -1L) return memo[start];

        long take = questions[start][0] + best(questions, start + questions[start][1] + 1, memo);
        long skip = best(questions, start + 1, memo);

        memo[start] = Math.max(take, skip);

        return memo[start];
    }

    /**
     * Iterative solution with memoization.
     * @param questions The array of questions, where each question is represented as an array of two integers: [points, brainpower].
     * @param memo An array to store the maximum points that can be obtained from each question index.
     * @return The maximum points that can be obtained starting from the first question.
     */
    public long best2(int[][] questions, long[] memo) {
        int n = questions.length;
        for (int i = n - 1; i >= 0; i--) {
            int next = i + questions[i][1] + 1;
            long take = questions[i][0];
            if (next < n) {
                take += memo[next];
            }
            long skip = 0;
            if (i + 1 < n) {
                skip = memo[i + 1];
            }
            memo[i] = Math.max(take, skip);
        }
        return memo[0];
    }

}
