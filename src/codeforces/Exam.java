package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 5/08/2015.
 */
public class Exam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if(n>=4) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    sb1.append(i).append(" ");
                } else {
                    sb2.append(i).append(" ");
                }
            }
            System.out.println(n);
            System.out.println(sb1.toString() + sb2.toString());
        } else if(n == 1 || n == 2){
            System.out.println(1);
            System.out.println(1);
        } else if(n == 3) {
            System.out.println(2);
            System.out.println(1 + " " + 3);
        }
    }

}
