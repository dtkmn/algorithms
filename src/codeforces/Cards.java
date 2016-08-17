package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// http://codeforces.com/problemset/problem/701/A
public class Cards {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Card[] list = new Card[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(st.nextToken());
            list[i] = new Card(val, i);
            sum += val;
        }
        int avg = sum/(n/2);
        java.util.Arrays.sort(list);
        for(int i=0; i<n/2; i++) {
            System.out.println((list[i].pos + 1) + " " + (list[n-1-i].pos + 1));
        }
    }


    static class Card implements Comparable<Card>{
        int val;
        int pos;

        Card(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        @Override
        public int compareTo(Card o) {
            if(this.val > o.val)
                return 1;
            if(this.val < o.val)
                return -1;
            return 0;
        }
    }

}
