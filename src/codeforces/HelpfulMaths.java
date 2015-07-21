package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class HelpfulMaths {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String[] strings = input.split("\\+");
        for(int i=0; i<strings.length-1; i++) {
            for(int j=i; j<strings.length; j++) {
                if(strings[i].compareTo(strings[j]) > 0) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }

        for(int i=0; i<strings.length; i++) {
            System.out.print(strings[i]);
            if(i != strings.length-1) {
                System.out.print("+");
            }
        }

    }

}
