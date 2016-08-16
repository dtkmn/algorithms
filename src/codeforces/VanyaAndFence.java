package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/677/A
public class VanyaAndFence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int w = 0;
        for(int i=0; i<n; i++) {
            int f = Integer.parseInt(st.nextToken());
            if(h>=f) w++;
            else w += 2;
        }
        System.out.println(w);
    }

}
