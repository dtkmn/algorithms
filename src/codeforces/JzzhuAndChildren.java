package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class JzzhuAndChildren {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] students = new int[n+1];
        for(int i=1; i<=n; i++) {
            students[i] = in.nextInt();
        }
        int remainInQueue = n;
        int preRemove = -1, pos = 1;
        while(remainInQueue > 0) {
            if(students[pos] > 0) {
                students[pos] -= m;
                if(students[pos] <= 0) {
                    remainInQueue--;
                    preRemove = pos;
                }
            }
            if(pos + 1 > n) {
                pos = 1;
            } else {
                pos++;
            }

        }

        System.out.println(preRemove);
    }


}
