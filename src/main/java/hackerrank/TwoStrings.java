package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/08/2015.
 */
public class TwoStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            String A = in.next();
            String B = in.next();

            int[] stringA = new int[26];
            int[] stringB = new int[26];
            for(int j=0; j<A.length(); j++) {
                stringA[A.charAt(j)-97]++;
            }
            for(int j=0; j<B.length(); j++) {
                stringB[B.charAt(j)-97]++;
            }

            boolean found = false;
            for(int j=0; j<26; j++) {
                if(stringA[j] > 0 && stringB[j] > 0) {
                    found = true;
                    break;
                }
            }

            System.out.println(found?"YES":"NO");

        }
    }

}
