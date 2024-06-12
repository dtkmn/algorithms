package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 1/10/2015.
 */
public class KefaAndFirstSteps {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int pre = -1;
        int seq = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
            int current = in.nextInt();
            if(pre == -1) seq = 1;
            else if(pre != -1 && pre <= current) {
                seq++;
            } else {
                seq = 1;
            }
            max = Math.max(max, seq);
            pre = current;
        }
        System.out.println(max);
    }

}
