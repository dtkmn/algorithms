package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxMin {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int unfairMin = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            if ((j + k - 1) < n) {
                for(int m = j; m<j+k ; m++) {
                    max = Math.max(list[m], max);
                    min = Math.min(list[m], min);
                }
                unfairMin = Math.min(unfairMin, max - min);
            }
        }
        System.out.println(unfairMin);
    }

}
