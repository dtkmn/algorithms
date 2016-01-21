package hackerrank.ThirtyDaysOfCodeJan2016;

import java.util.Scanner;

public class Day10BinaryNumbers {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int decimal = sc.nextInt();
            System.out.println(Math.log1p(decimal));
            System.out.println(Integer.toBinaryString(decimal));
        }

    }

}
