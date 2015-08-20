package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class ApplemanAndToastman {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputs = new int[n];
        long sum = 0L;
        for(int i=0; i<n; i++) {
            inputs[i] = in.nextInt();
            sum += inputs[i];
        }
        Arrays.sort(inputs);
        long result = sum;
        for(int j=0; j<n-1; j++) {
            result += inputs[j] + (sum - inputs[j]);
            sum -= inputs[j];
        }
        System.out.println(result);
    }

//  10
//  8 10 2 5 6 2 4 7 2 1
//  376

}
