package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class MaximumSubarray {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int N = in.nextInt();


            int bestsum = 0;
            int currentsum = 0;

            int contiguous = 0;
            int noncontiguous = 0;

            for(int j=0; j<N; j++) {
                int input = in.nextInt();

                if(input > 0) {
                    noncontiguous += input;
                }
//                contiguous += input;
                int val = currentsum + input;
                if(val > 0) {
                    currentsum = val;
                } else {
                    currentsum = 0;
                }

                if(currentsum > bestsum) {
                    bestsum = currentsum;
                }

            }
            System.out.println(bestsum + " " + noncontiguous);
        }

    }

}
