package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/621/A
public class WetSharkAndOddAndEven {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long firstOdd = -1, secondOdd = -1, sum = 0;
        for(int i=0; i<n; i++) {
            long num = Long.parseLong(st.nextToken());
            if(num%2 == 0) sum += num;
            else {
                if(firstOdd == -1) firstOdd = num;
                else if(secondOdd == -1) secondOdd = num;
                else {
                    long minOdd = Math.min(num, Math.min(firstOdd, secondOdd));
                    sum += (firstOdd + secondOdd + num - minOdd);
                    firstOdd = minOdd; secondOdd = -1;
                }
            }
        }
        if(firstOdd != -1 && secondOdd != -1) sum += firstOdd + secondOdd;
        System.out.println(sum);

    }

}
