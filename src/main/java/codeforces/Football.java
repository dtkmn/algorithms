package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class Football {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char[] chars = input.toCharArray();
        char current = 'z';
        int count = 0;
        for(int i=0; i<chars.length; i++) {
            char c = chars[i];
            if(c == current) {
                count++;
            } else {
                count = 1;
            }
            current = c;

            if(count >= 7) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }

}
