package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumDistances {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int minD = Integer.MAX_VALUE;
        for (int j = 0; j < n-1; j++) {
            for (int k = j+1; k < n; k++) {
                if(list[j] == list[k]) {
                    minD = Math.min(Math.abs(j-k), minD);
                }
            }
        }

        System.out.println(minD==Integer.MAX_VALUE?-1:minD);
    }

}
