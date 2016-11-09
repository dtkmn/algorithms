package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class FibonacciModified {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        BigDecimal [] dp = new BigDecimal[n+1];
        for(int i=0; i<=n; i++) dp[i] = new BigDecimal(-1);
        dp[1] = new BigDecimal(t1); dp[2] = new BigDecimal(t2);
        System.out.println(fibonacciModifiedVersion(n, dp));
    }

    static BigDecimal fibonacciModifiedVersion(int n, BigDecimal[] dp) {
        if(!dp[n].equals(new BigDecimal(-1))) return dp[n];
        dp[n] = fibonacciModifiedVersion(n-2, dp).add(fibonacciModifiedVersion(n-1, dp).pow(2));
        return dp[n];
    }


}
