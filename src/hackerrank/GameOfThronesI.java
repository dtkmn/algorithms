package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/08/2015.
 */
public class GameOfThronesI {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int len = input.length();
        int[] alpha = new int[26];
        for(int i=0; i<len; i++) {
            alpha[input.charAt(i)-97]++;
        }

        int countOdd = 0;
        for(int i=0; i<alpha.length; i++) {
            if(alpha[i]%2==1) {
                countOdd++;
            }
        }
        if(countOdd>1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }

}
