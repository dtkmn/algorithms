package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for(int i=1; i<=N; i++) {
            String output = "";
            for(int j=i; j>0; j--) {
                output += "#";
            }
            System.out.printf("%" + N + "s\n", output);
        }
    }

}
