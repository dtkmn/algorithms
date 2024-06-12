package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class PashmakAndFlowers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] flowers = new long[N];
        for(int i=0; i<N; i++) {
            flowers[i] = in.nextInt();
        }
        Arrays.sort(flowers);
        long min = flowers[0];
        long max = flowers[N-1];
        long diff = max-min;

        if(diff == 0) {
            System.out.println(diff + " " + (1L*N*(N-1)/2));
            return;
        }

        long countMin = 0L, countMax = 0L;
        for(int i=0; i<N; i++) {
            if(flowers[i]==min)
                countMin++;
            else break;
        }
        for(int j=N-1; j>=0; j--) {
            if(flowers[j]==max)
                countMax++;
            else break;
        }
        System.out.println(diff + " " + countMin*countMax);

    }

}
