package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class Chatroom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char[] charArray = input.toCharArray();

        int pos = 0;
        char[] hello = "hello".toCharArray();

        for(int i=0; i<charArray.length; i++) {
            if(charArray[i] == hello[pos]) {
                if(pos == 4) {
                    System.out.println("YES");
                    return;
                } else {
                    pos++;
                }
            }
        }
        System.out.println("NO");
    }

}
