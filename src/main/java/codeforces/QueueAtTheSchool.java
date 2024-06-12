package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class QueueAtTheSchool {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        String str = in.next();
        for(int i=0; i<t; i++) {
            str = str.replaceAll("BG", "GB");
        }
        System.out.println(str);
    }

}
