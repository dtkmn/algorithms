package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class Cakeminator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int[] rvalid = new int[r];
        int[] cvalid = new int[c];
        for(int i=0; i<r; i++) {
            String input = in.next();
            for(int j=0; j<c; j++) {
                if(input.charAt(j) == 'S') {
                    rvalid[i] = -1;
                    cvalid[j] = -1;
                }
            }
        }

        int num = 0;
        for(int m=0; m<r; m++) {
            for(int n=0; n<c; n++) {
                if (rvalid[m] == 0 || cvalid[n] == 0) {
                    num += 1;
                }
            }
        }

        System.out.println(num);
    }

}
