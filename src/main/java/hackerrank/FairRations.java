package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FairRations {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer row = new StringTokenizer(br.readLine());
        int countOdd = 0;
        for(int i=0; i<n; i++) {
            int value = Integer.parseInt(row.nextToken());
            if(value%2 != 0) countOdd++;
            list[i] = value;
        }
        if(countOdd%2 != 0) System.out.println("NO");
        else {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(list[j]%2 != 0 && j+1<n) {
                    list[j]++; list[j+1]++;
                    count += 2;
                }
            }
            System.out.println(count);
        }
    }

}
