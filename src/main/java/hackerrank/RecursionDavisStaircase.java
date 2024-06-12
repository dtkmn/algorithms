package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionDavisStaircase {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        for(int i=0; i<s; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(ways(n, new int[n+1]));
        }
    }

    static int ways(int n, int[] dp) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        if(dp[n] == 0) {
            dp[n] = ways(n-3, dp) + ways(n-2, dp) + ways(n-1, dp);
        }
        return dp[n];
    }

}
