package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 15/08/2015.
 */
public class Towers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] numbers = new int[1000+1];
        int min = 0, max = 0;
        for(int i=0; i<N; i++) {
            int num = in.nextInt();
            numbers[num]++;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int distinct = 0, largest = 0;
        for(int j=min; j<=max; j++) {
            if(numbers[j] > 0) {
                distinct++;
                largest = Math.max(largest, numbers[j]);
            }
        }
        System.out.println(largest + " " + distinct);
    }

}
