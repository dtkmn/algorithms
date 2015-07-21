package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class GameWIthSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count=0;
        while(n>0 && m>0) {
            m--;
            n--;
            count++;
        }
        System.out.println(count%2==0?"Malvika":"Akshat");
    }

}
