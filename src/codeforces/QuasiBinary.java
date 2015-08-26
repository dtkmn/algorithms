package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 21/08/2015.
 */
public class QuasiBinary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        // 10^6 = 1000000
        int[] abc = {1, 10, 11, 100, 101, 110, 111, 1000, 1001, 1010, 1011, 1100, 1101, 1111,
                        10000, 10001, 10010, 10011, 10100, 10101, 10110, 10111, 11000, 11001,
                        11010, 11011, 11100, 11101, 11110, 11111, 100000, 100001, 100010,
                        100011, 100100, 100101, 100110, 100111, 101000, 101001, 101010,
                        101011, 101100, 101101, 101110, 101111, 110000, 110001, 110010,
                        110011, 110100, 110101, 110110, 110111, 111000, 111001, 111010,
                        111011, 111100, 111101, 111110, 111111, 1000000};
        int[] min = new int[input+1];
        int[] coins = new int[input+1];

        for(int i=0; i<min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        min[0] = 0;
        for(int i=1; i<=input; i++) {
            for(int j=0; j<abc.length; j++) {
                if(abc[j]<=i && min[i-abc[j]] != Integer.MAX_VALUE && min[i-abc[j]]+1 < min[i]) {
                    min[i] = min[i-abc[j]] + 1;
                    coins[i] = abc[j];
                }
            }
        }

//        System.out.println(Arrays.toString(min));
//        System.out.println(Arrays.toString(coins));

        System.out.println(min[input]);

        int test = input;
        while(min[test] != 0) {
            System.out.print(coins[test] + " ");
            test = test - coins[test];
        }

    }

}
