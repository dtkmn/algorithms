package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 14/08/2015.
 */
public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i=0; i<N; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            System.out.println((int)(Math.floor(Math.sqrt(end)) - Math.ceil(Math.sqrt(start))+1));
        }
    }

}
