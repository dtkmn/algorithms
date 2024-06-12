package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 15/08/2015.
 */
public class ILoveUsername {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min = 0, max = 0, amazing = 0;
        for(int i=0; i<n; i++) {
            int m = in.nextInt();
            if(i == 0) {
                min = m;
                max = m;
            } else {
                if(m < min) {
                    min = m;
                    amazing++;
                } else if(m > max) {
                    max = m;
                    amazing++;
                }
            }
        }
        System.out.println(amazing);
    }

}
