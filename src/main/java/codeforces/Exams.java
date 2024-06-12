package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//http://codeforces.com/problemset/problem/479/C
public class Exams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            d1[i] = Integer.parseInt(st.nextToken());
            d2[i] = Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<n-1; j++) {
            for(int k=j+1; k<n; k++) {
                if(d1[j] > d1[k]) {
                    int t1 = d1[j];
                    int t2 = d2[j];
                    d1[j] = d1[k];
                    d2[j] = d2[k];
                    d1[k] = t1;
                    d2[k] = t2;
                } else if(d1[j] == d1[k]) {
                    if(d2[j] > d2[k]) {
                        int t1 = d1[j];
                        int t2 = d2[j];
                        d1[j] = d1[k];
                        d2[j] = d2[k];
                        d1[k] = t1;
                        d2[k] = t2;
                    }
                }
            }
        }

        int day=0;
        for(int m=0; m<n; m++) {
            if(day <= d2[m]) day = d2[m];
            else day = d1[m];
        }
        System.out.println(day);
    }

}
