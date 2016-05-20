package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/572/A
public class Arrays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1size = Integer.parseInt(st.nextToken());
        int a2size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int maxFromA1 = -1;
        for(int i=0; i<a1size; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(i == k - 1) { maxFromA1 = num; break; }
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int j=0; j<a2size; j++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > maxFromA1 && ++count == m) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }

}
