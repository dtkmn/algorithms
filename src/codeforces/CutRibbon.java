package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/08/2015.
 */
public class CutRibbon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int[] abc = new int[3];
        abc[0] = in.nextInt();
        abc[1] = in.nextInt();
        abc[2] = in.nextInt();

        int[] max = new int[total+1];
        for(int i=0; i<max.length; i++) {
            max[i] = -1;
        }

        max[0] = 0;

        for(int i=1; i<=total; i++) {
            for(int j=0; j<abc.length; j++) {
                if(abc[j]<=i && max[i-abc[j]] != -1 && max[i-abc[j]]+1 > max[i]) {
                    max[i] = max[i-abc[j]] + 1;
                }
            }
        }
//        System.out.println(Arrays.toString(max));
        System.out.println(max[total]);

    }

}
