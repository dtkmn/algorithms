package hackerrank.ThirtyDaysOfCodeJan2016;

import java.util.Scanner;

public class Day9 {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd=find_gcd(a,b);
        System.out.println(gcd);
    }
    static int find_gcd(int a, int b){
        if(a == b) return a;
        else if(a > b) return find_gcd(a-b, b);
        else return find_gcd(b-a, a);

//        return find_gcd(b,a%b);
//        if(a % b == 0) return b;
//        if(b % a == 0) return a;
//        return 1;
    }

}
