package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class AlternatingChar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            String input = in.next();
            char[] chars = input.toCharArray();
            char first = chars[0];
            int del = 0;
            for(int j=1; j<chars.length; j++) {
                if(first == chars[j]) del++;
                else first = chars[j];
            }
            System.out.println(del);
        }
    }

}
