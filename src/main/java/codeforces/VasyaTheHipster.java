package codeforces;

import java.util.Scanner;

public class VasyaTheHipster {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int min = Math.min(a, b);
        if(a == b) {
            System.out.println(a + " " + 0);
        } else if(a == min) {
            System.out.println(a + " " + (b-a)/2);
        } else {
            System.out.println(b + " " + (a-b)/2);
        }
    }

}
