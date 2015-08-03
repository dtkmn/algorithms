package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class GukiZandContest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] students = new int[N];
        for(int i=0; i<N; i++) {
            students[i] = in.nextInt();
        }
        for(int j=0; j<N; j++) {
            int count = 0;
            for(int k=0; k<N; k++) {
                if(j != k) {
                    int t = students[j];
                    if (students[k] > t) {
                        count++;
                    }
                }
            }
            System.out.print((1+count) + " ");
        }

    }

}
