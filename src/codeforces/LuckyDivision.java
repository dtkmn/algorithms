package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class LuckyDivision {

    static boolean isLucky(int number) {
        while(number != 0) {
            if(number%10 == 4 || number%10 == 7) {
                number /= 10;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i=1; i<=num; i++) {
            if(isLucky(i) && (num%i==0 || num%i==0)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

}
