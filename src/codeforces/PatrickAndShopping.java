package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/599/A
public class PatrickAndShopping {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int d3 = Integer.parseInt(st.nextToken());
        int t1 = d1 + d3 + d2;
        int t2 = d1*2 + d2*2;
        int t3 = d3*2 + Math.min(d1,d2)*2;
        System.out.println(Math.min(t1, Math.min(t2, t3)));
    }

}
