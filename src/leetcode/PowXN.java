package leetcode;


/**
 * https://leetcode.com/problems/powx-n/
 */
public class PowXN {

    // TLE ... ^^
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static double myPow(double x, int n) {
        if (x == 1) return x;
        // In case Integer n will cause underflow/overflow on MIN_VALUE
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1;
        for (int i = 0; i < N; i++) {
            res *= x;
        }
        return res;
    }

    // DPS Approach
    public static double myPow_dfs(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        // N should be positive now
        return dfs(x, N);
    }


    // Time Complexity: O(logN)
    // Space Complexity: O(logN)
    private static double dfs(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double half = dfs(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


    public static void main(String[] args) {
//        System.out.println(myPow(2.000, -2147483648));
        System.out.println(myPow_dfs(2.000, -2147483648));
//        System.out.println(myPow(2.1, 3));
        System.out.println(myPow_dfs(2.1, 3));
    }

}
