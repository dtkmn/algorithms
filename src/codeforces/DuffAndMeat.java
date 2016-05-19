package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/584/A
public class DuffAndMeat {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int minPrice = Integer.MAX_VALUE, cost = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int kilo = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            if(price < minPrice) {
                minPrice = price;
            }
            cost += minPrice * kilo;
        }

        System.out.println(cost);

    }

}
