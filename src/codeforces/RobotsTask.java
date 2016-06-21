package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/583/B
public class RobotsTask {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] line = new int[n];
        boolean[] fill = new boolean[n];
        int fillin = 0, turn = 0, piece = 0, direction = 0;
        // first time loop to read those value in first direction
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            line[i] = x;
            if(x <= piece) {
                fill[i] = true;
                piece++; fillin++;
            }
        }

        while(fillin < n) {
            turn++;
            if(++direction%2==1) {
                for(int j=n-1; j>=0; j--) {
                    if(line[j] <= piece && !fill[j]) {
                        fill[j] = true;
                        piece++; fillin++;
                    }
                }
            } else {
                for(int j=0; j<n; j++) {
                    if(line[j] <= piece && !fill[j]) {
                        fill[j] = true;
                        piece++; fillin++;
                    }
                }
            }
        }

        System.out.println(turn);
    }

}
