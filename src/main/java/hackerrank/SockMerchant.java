package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SockMerchant {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer row = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        for(int i=0; i<n; i++) {
            list[i] = Integer.parseInt(row.nextToken());
        }
        Arrays.sort(list);
        int count = 0;
        for(int j=0; j<n;) {
            if(j==n-1) break;
            if(list[j] == list[j+1]) {
                j+=2; count++;
            } else {
                j+=1;
            }
        }
        System.out.println(count);
    }

}
