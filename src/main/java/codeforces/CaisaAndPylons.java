package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//http://codeforces.com/problemset/problem/463/B
public class CaisaAndPylons {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int energy = 0, spent = 0, current = 0;
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(current < x) {
                int required = x - current;
                if(energy < required) {
                    spent += (required - energy);
                    energy = 0;
                }
                else energy -= required;
            } else if(current > x) {
                energy += current - x;
            }
            current = x;
        }
        System.out.println(spent);
    }

}
