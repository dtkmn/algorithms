package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 26/08/2015.
 */
public class EquidistantString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();

        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        char[] ans = new char[firstArray.length];

        int diff = 0;
        for(int i=0; i<firstArray.length; i++) {
            if(firstArray[i] == secondArray[i]) {
                ans[i] = firstArray[i];
            } else {
                diff++;
                if(diff%2 == 0) {
                    ans[i] = firstArray[i];
                } else {
                    ans[i] = secondArray[i];
                }
            }
        }

        if(diff%2 == 0) {
            System.out.println(new String(ans));
        } else {
            System.out.println("impossible");
        }

    }
}