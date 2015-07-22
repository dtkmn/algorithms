package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class AntonAndLetteers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input = input.substring(1, input.length()-1);
        input = input.replaceAll(", ", "");
        int count = 0;
        while(input.length() > 0) {
            char c = input.charAt(0);
            if(input.substring(1).indexOf(c) == -1) {
                input = input.substring(1);
            } else {
                input = input.replaceAll(c + "", "");
            }
            count++;
        }
        System.out.println(count);

    }

}
