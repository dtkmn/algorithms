package codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by datse on 21/08/2015.
 */
public class SerejaAndSuffixes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arrays = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            arrays[i] = in.nextInt();
        }

        Set<Integer> sets = new HashSet<>();
        for(int j=n; j>=1; j--) {
            if(!sets.contains(arrays[j])) {
                sets.add(arrays[j]);
                if(j == n) dp[j] = 1;
                else dp[j] = dp[j+1] + 1;
            } else {
                dp[j] = dp[j+1];
            }
        }

//        System.out.println(Arrays.toString(dp));

        for(int j=1; j<=k; j++) {
            int pos = in.nextInt();
            System.out.println(dp[pos]);
        }
    }

}
