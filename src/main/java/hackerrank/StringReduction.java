package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 29/07/2015.
 */
public class StringReduction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i=0; i<n; i++) {
            int countA = 0, countB = 0, countC = 0;
            String input = in.next();
            int strLength = input.length();
            for(int j=0; j<strLength; j++) {
                char c = input.charAt(j);
                if(c == 'a') countA++;
                else if(c == 'b') countB++;
                else if(c == 'c') countC++;
            }
            if(countA == strLength || countB == strLength ||
                    countC == strLength) {
                System.out.println(strLength);
            } else if((countA%2 == 0 && countB%2 == 0 && countC%2 == 0) ||
                    (countA%2 != 0 && countB%2 != 0 && countC%2 != 0)) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }

}
