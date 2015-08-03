package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class PresentFromLena {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int width = N*2+1;
        for(int i=0; i<=N*2; i++) {
            int l = Math.abs(Math.abs(i-N) - N);
            width = (N-l)*2;
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<width; j++) {
                sb.append(" ");
            }
            for(int j=0; j<=l*2; j++) {
                int m = Math.abs(Math.abs(j-l) - l);
                sb.append(m);
                if(j != l*2) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }

}
