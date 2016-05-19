package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/584/A
public class OlesyaAndRodion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        if(t > 1 && t < 10) {
            for(int i=0; i<n; i++)
                System.out.print(t);
        } else if(t == 10) {
            if(n == 1) System.out.print(-1);
            else {
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(1);
                }
                System.out.print(0);
            }
        }

    }

}
