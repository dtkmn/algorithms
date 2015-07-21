package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class LearnFromMath {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        for(int i=4; i<number-4; i++) {
            int other = number - i;
            if(isCompsite(other) && isCompsite(i)) {
                System.out.println(i + " " + other);
                return;
            }

        }
    }

    static boolean isCompsite(int num) {
        // 2 squareroot of num
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) {
                return true;
            }
        }
        return false;
    }




}
