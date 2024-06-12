package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// http://codeforces.com/problemset/problem/552/B
public class VanyaAndBooks {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        long d = Long.parseLong(br.readLine());
        int i = 0;
        while(Math.pow(10, i) <= d) {
            i++;
        }
        long num = 0;
        for(int j=0; j<i-1; j++) {
            num += 9 * Math.pow(10, j) * (j+1);
        }
        num += (Math.abs(Math.pow(10, i-1) - d) + 1) * (i);
        System.out.println(num);
    }

}
