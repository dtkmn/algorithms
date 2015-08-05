package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 5/08/2015.
 */
public class IncARG {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String input = in.next();
        int count = 0;
        int forward = 1;    // add 1
        for(int i=0; i<n; i++) {
            char c = input.charAt(i);
            if(c == '1') {
                if(forward == 1) {
                    count++;
                    // foward unchange
                }
            } else if(c == '0') {
                if(forward == 1) {
                    forward = 0;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
