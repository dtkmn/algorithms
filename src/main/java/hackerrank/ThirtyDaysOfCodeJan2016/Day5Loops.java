package hackerrank.ThirtyDaysOfCodeJan2016;

import java.util.Scanner;

public class Day5Loops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int N = in.nextInt();
            // a+20b,a+20b+21b,......,a+20b+21b+...+2N−1b
            int sum = a;
            for(int j=0; j<N; j++) {
                sum += Math.pow(2, j) * b;
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

}
