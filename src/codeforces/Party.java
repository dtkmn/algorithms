package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// http://codeforces.com/problemset/problem/115/A
public class Party {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n+1];
        int[] level = new int[n+1];
        int max = 0;
        int unfilled = 0;
        for(int i=1; i<=n; i++) {
            int input = Integer.parseInt(br.readLine());
            list[i] = input;
            if(input == -1) level[i] = 0;
            else if(input > i || level[input] == -1) {
                level[i] = -1;
                unfilled++;
            }
            else level[i] = level[input] + 1;
            max = Math.max(max, level[i]);
        }
        while(unfilled > 0) {
            for(int i=1; i<=n; i++) {
                if(level[i] == -1 && level[list[i]] != -1) {
                    level[i] = level[list[i]] + 1;
                    unfilled--;
                }
                max = Math.max(max, level[i]);
            }
        }
        System.out.println(max+1);
    }

}
