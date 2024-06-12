package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class AVeryBigSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long sum = 0;
        for(int i=0; i<N; i++) {
            long check = in.nextLong();
            sum += check;
        }
        System.out.println(Long.toString(sum, 10));
    }
}
