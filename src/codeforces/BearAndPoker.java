package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/573/A
public class BearAndPoker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] input = new long[n];
        for(int i=0; i<n; i++) {
            long x = Long.parseLong(st.nextToken());
            while(x%2 == 0) x/=2;
            while(x%3 == 0) x/=3;
            if(i>0 && x!=input[i-1]) {
                System.out.println("No");
                return;
            }
            input[i] = x;
        }
        System.out.println("Yes");
    }

}
