package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class HQ9PLUS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String program = in.next();
        char[] charArray = program.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            char c = charArray[i];
            if(c == 72 || c == 81 || c == 57) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }

}
