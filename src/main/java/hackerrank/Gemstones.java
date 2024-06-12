package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 28/07/2015.
 */
public class Gemstones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] input = new String[N];
        int whichShort = -1;
        int length = 100;
        for(int i=0; i<N; i++) {
            input[i] = in.next();
            if(input[i].length() < length) {
                length = input[i].length();
                whichShort = i;
            }
        }
//        System.out.println(input[whichShort]);
        char[] cc = input[whichShort].toCharArray();
        Arrays.sort(cc);
//        System.out.println(new String(cc));
        String shortestString = new String(cc);
        int matchAll = 0;
        char past = ' ';
        for(int j=0; j<shortestString.length(); j++) {
            char c = shortestString.charAt(j);
            if(c == past) continue;
            int count = 0;
            for(int k=0; k<N; k++) {
                if(k != whichShort) {
                    if(input[k].indexOf(c) == -1) {
                        break;
                    } else {
                        count++;
                    }
                }
            }
            if(count == N-1) matchAll++;
            past = c;
        }

        System.out.println(matchAll);


    }

}
