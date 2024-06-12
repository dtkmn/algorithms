package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class DevuTheSingerAndChuruTheJoker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int length = in.nextInt();
        int sum = 0;
        int jokes = 0;
        jokes += (n-1)*2;
        for(int i=0; i<n; i++) {
           sum += in.nextInt();
        }
        sum += (n-1)*2*5;

        if(sum > length) {
            System.out.println(-1);
        } else {
            jokes += (length-sum)/5;
            System.out.println(jokes);
        }

    }

}
