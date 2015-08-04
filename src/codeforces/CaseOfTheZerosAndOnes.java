package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 4/08/2015.
 */
public class CaseOfTheZerosAndOnes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String input = in.next();

        boolean changes = true;
        while(changes) {
            changes = false;
            if(input.indexOf("10") >= 0) {
                input = input.replaceFirst("10", "");
                changes = true;
            } else if(input.indexOf("01") >= 0) {
                input = input.replaceFirst("01", "");
                changes = true;
            }
        }
        System.out.println(input.length());
    }

}
