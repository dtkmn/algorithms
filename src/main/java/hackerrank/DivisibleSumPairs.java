package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivisibleSumPairs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer first = new StringTokenizer(br.readLine());
        StringTokenizer list = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(first.nextToken());
        int k = Integer.parseInt(first.nextToken());
        int[] inputs = new int[n];
        for(int i=0; i<n; i++) {
            inputs[i] = Integer.parseInt(list.nextToken());
        }
        int match = 0;
        for(int x=0; x<n-1; x++) {
            for(int y=x+1; y<n; y++) {
                if((inputs[x] + inputs[y]) % k == 0) {
                    match++;
                }
            }
        }
        System.out.println(match);
    }

}
