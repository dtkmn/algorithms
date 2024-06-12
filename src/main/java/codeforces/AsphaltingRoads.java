package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/583/A
public class AsphaltingRoads {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] hs = new int[n+1];
        int[] vs = new int[n+1];
        for(int i=1;i<=n*n;i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(hs[h]==0 && vs[v] == 0) {
                hs[h] = -1; vs[v] = -1;
                System.out.print(i + " ");
            }
        }
    }

}
