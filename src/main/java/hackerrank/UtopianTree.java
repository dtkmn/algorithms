package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class UtopianTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i=0; i<N; i++) {
            int height = 1;
            int cycle = in.nextInt();
            for(int j=1; j<=cycle; j++) {
                if(j % 2 == 0) {
                    height++;
                } else {
                    height = height * 2;
                }
            }
            System.out.println(height);
        }
    }

}
