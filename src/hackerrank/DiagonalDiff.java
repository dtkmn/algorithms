package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class DiagonalDiff {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int leftToRightDown = 0;
        int leftToRightUp = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int input = in.nextInt();
                if(i+j+1 == N) {
                    leftToRightUp += input;
                }
                if(i == j) {
                    leftToRightDown += input;
                }
            }
        }
        System.out.println(Math.abs(leftToRightDown-leftToRightUp));
    }

}
