package leetcode;


/*
    https://leetcode.com/problems/sum-of-digits-in-the-minimum-number/
 */
public class SumOfDigitsInTheMinimumNumber {

    // Given an array A of positive integers, let S be the sum of the digits of the minimal element of A.
    // Return 0 if S is odd, otherwise return 1.
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int num: A) min = Math.min(min, num);
        // Slower ...
//        int min = Arrays.stream(A).min().getAsInt();
        int next = 0;
        while (min > 0) {
            next += min % 10;
            min /= 10;
        }
        // return next % 2 == 0 ? 1 : 0;
        // Nice!! :3
        return 1 - next % 2;

    }

    public static void main(String[] args) {

    }


}
