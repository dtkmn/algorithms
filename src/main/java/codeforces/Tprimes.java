package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/230/B
// Sieve of Eratosthenes technique
public class Tprimes {

    public static void main(String[] args) throws IOException {

        boolean[] notPrime = new boolean[1000001];
        // except one is special
        notPrime[1] = true;
        for(int i=2; i<=1000000; i++) {
            if(!notPrime[i]) {
                for(int j=i*2; j<=1000000; j+=i) {
                    notPrime[j] = true;
                }
            }
        }
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            long x = Long.parseLong(st.nextToken());
            double sq = Math.sqrt(x);
            if(sq - (int)sq > 0) {
                System.out.println("NO");
            } else {
                if(!notPrime[(int)sq]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }


    }

}
