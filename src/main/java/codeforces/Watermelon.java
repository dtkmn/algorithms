package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 20/07/2015.
 */
public class Watermelon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        System.out.println((w>2&&w%2==0)?"YES":"NO");
    }

}
