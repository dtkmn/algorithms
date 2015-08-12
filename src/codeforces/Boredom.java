package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 12/08/2015.
 */
public class Boredom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] seq = new int[n];

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            seq[i] = in.nextInt();
            maxValue = Math.max(seq[i], maxValue);
        }

        long[] max = new long[maxValue + 1];

        Arrays.sort(seq);

        max[0] = 0L;
        if (n >= 1) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (seq[i] == 1) count++;
                if (seq[i] > 1) break;
            }
            max[1] = count;
            int pre = 0;
            for (int j = 2; j <= maxValue; j++) {
                count = 0;
                for (int i = pre; i < n; i++) {
                    if (seq[i] == j) count++;
                    if (seq[i] > j){
                        pre = i;
                        break;
                    }
                }
                long temp = 1L * count * j;
                max[j] = Math.max(max[j - 1], max[j - 2] + temp);
            }
        }
        System.out.println(max[maxValue]);
    }

}
