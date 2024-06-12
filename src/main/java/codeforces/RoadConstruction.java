package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// http://codeforces.com/problemset/problem/330/B
public class RoadConstruction {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] invalid = new int[n+1];
        for(int i=0; i<m; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            invalid[a] = 1;
            invalid[b] = 1;
        }

        System.out.println(n-1);

        int center = 0;
        for(int j=1; j<=n; j++) {
            if(invalid[j] == 0) {
                center = j; break;
            }
        }

        for(int j=1; j<=n; j++) {
            if(j != center) {
                System.out.println(center + " " + j);
            }
        }

    }

}
