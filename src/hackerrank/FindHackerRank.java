package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/08/2015.
 */
public class FindHackerRank {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i=0; i<n; i++) {
            String word = in.nextLine();
            if(word.startsWith("hackerrank") && word.endsWith("hackerrank")) {
                System.out.println(0);
            } else if(word.startsWith("hackerrank")) {
                System.out.println(1);
            } else if(word.endsWith("hackerrank")) {
                System.out.println(2);
            } else {
                System.out.println(-1);
            }
        }
    }

}
