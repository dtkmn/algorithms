package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class LuckyDivision {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num % 4 == 0 || num % 7 == 0) {
            System.out.println("YES");
        } else {
            char[] charArray = String.valueOf(num).toCharArray();
            for(int i=0; i<charArray.length; i++) {
                if(!(charArray[i] == 52 || charArray[i] == 55)) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
    }

}
