package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/08/2015.
 */
public class RomaAndLuckyNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int result = n;
        for(int i=0; i<n; i++) {
            int roma = in.nextInt();
            String str = String.valueOf(roma);
            int count = 0;
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) == '4' || str.charAt(j) == '7') {
                    count++;
                }
            }
            if(count > k) result--;
        }
        System.out.println(result);
    }

}
