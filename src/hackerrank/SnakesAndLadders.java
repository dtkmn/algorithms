package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 14/07/2015.
 *
 * Dijkstra’s Shortest Path Algorithm
 * Implementation of Min Priority Queue
 *
 */
public class SnakesAndLadders {

    private static int[] edgeTo = new int[101];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            // Get number of ladders
            int N = in.nextInt();
            for(int j=0; j<N; j++) {
                int a = in.nextInt();
                int b = in.nextInt();
                edgeTo[a] = b;
            }
            // Get number of snakes
            int M = in.nextInt();
            for(int k=0; k<M; k++) {
                int m = in.nextInt();
                int n = in.nextInt();
                edgeTo[m] = n;
            }
            int pos = 1;

        }
    }


}
