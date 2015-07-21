package codeforces;

import sun.tools.java.ScannerInputReader;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class BeautifulYear {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        while(!distinct(++year)) {}
        System.out.println(year);
    }

    static boolean distinct(int year) {
        String y = String.valueOf(year);
        boolean result = true;
        for(int i=0; i<y.length(); i++) {
            char c = y.charAt(i);
            String s = y.substring(0, i) + y.substring(i+1);
            if(s.indexOf(c) != -1) {
                result = false;
                break;
            }

        }
        return result;
    }

}
