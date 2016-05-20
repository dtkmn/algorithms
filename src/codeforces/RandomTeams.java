package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/478/B
public class RandomTeams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        // MAX: (n-m+1) C 2
        long maxPair = (n-m+1)*(n-m)/2;
        // MIN... evenly distributed
        long p = n/m, r = n%m, minPair;
        if(r != 0) {
            minPair = p * (p + 1) / 2 * r +  p * (p - 1) / 2 * (m - r);
        } else {
            minPair = p * (p - 1) / 2 * m;
        }
        System.out.println(minPair + " " + maxPair);
    }

}
