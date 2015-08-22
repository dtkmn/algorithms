package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 23/08/2015.
 */
public class MarkAndToys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] prices = new int[N];
        for(int i=0; i<N; i++) {
            prices[i] = in.nextInt();
        }
        Arrays.sort(prices);

        int bought = 0;
        for(int i=0; i<N; i++) {
            if(K >= prices[i]) {
                K -= prices[i];
                bought++;
            }
        }
        System.out.println(bought);

    }

}
