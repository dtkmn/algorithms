package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 23/08/2015.
 */
public class PriyankaAndToys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weights = new int[n];
        for(int i=0; i<n; i++) {
            weights[i] = in.nextInt();
        }
        Arrays.sort(weights);
        int bought = 1;
        int currentWeight = weights[0];
        for(int i=1; i<n; i++) {
            if(currentWeight+4 < weights[i]) {
                bought++;
                currentWeight = weights[i];
            }
        }
        System.out.println(bought);
    }

}
