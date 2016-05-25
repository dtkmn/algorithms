package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/570/B
public class SimpleGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n==1 && m==1) {
            System.out.println(1);
            return;
        }
        int leftofm = m-1;
        int rightofm = n-m;
        System.out.println(leftofm>=rightofm?m-1:m+1);
    }

}
