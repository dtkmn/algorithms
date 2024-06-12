package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://codeforces.com/contest/681/problem/A
public class AGoodContest {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer scores = new StringTokenizer(br.readLine());
            String name = scores.nextToken();
            int before = Integer.parseInt(scores.nextToken());
            int after = Integer.parseInt(scores.nextToken());
            if(before>=2400 && before < after) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }



}
