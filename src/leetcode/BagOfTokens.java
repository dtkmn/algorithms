package leetcode;


import java.util.Arrays;

/**
 *  <a href="https://leetcode.com/problems/bag-of-tokens/">...</a>
 */

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int getScore = 0;
        int getPower = tokens.length - 1;

        while (getScore <= getPower) {
            if (power >= tokens[getScore]) {
                power -= tokens[getScore];
                score++;
                getScore++;
            } else if (score >= 1 && getPower - getScore > 1) {
                power += tokens[getPower];
                score--;
                getPower--;
            } else break;
        }

        return score;
    }

    public static void main(String[] args) {
    }

}
