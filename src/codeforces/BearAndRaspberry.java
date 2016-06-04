package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/385/A
public class BearAndRaspberry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int lent = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int max = 0;
        for(int i=2; i<=n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int o = -1 * lent + prev - x;
            max = Math.max(max, o);
            prev = x;
        }
        System.out.println(max);
    }

}
