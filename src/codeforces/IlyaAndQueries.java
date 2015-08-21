package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by datse on 21/08/2015.
 */
public class IlyaAndQueries {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int[] dp = new int[str.length()];
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == str.charAt(i-1)) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }
//        System.out.println(Arrays.toString(dp));
        int m = Integer.parseInt(in.readLine());
        for(int i=0; i<m; i++) {
            String[] token = in.readLine().split(" ");
            int start = Integer.parseInt(token[0])-1;
            int end = Integer.parseInt(token[1])-1;
            System.out.println(dp[end] - dp[start]);
        }
    }

}
