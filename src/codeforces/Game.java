package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 25/07/2015.
 */
public class Game {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int k1 = in.nextInt();
        int k2 = in.nextInt();

        System.out.println(n1<=n2?"Second":"First");

    }

}
