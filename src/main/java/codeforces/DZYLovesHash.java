package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 20/08/2015.
 */
public class DZYLovesHash {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int buckets = in.nextInt();
        int n = in.nextInt();
        int[] hashtable = new int[buckets];

        for(int i=0; i<buckets; i++) {
            hashtable[i] = -1;
        }

        for(int i=1; i<=n; i++) {
            int input = in.nextInt();
            if(hashtable[input%buckets] != -1) {
                System.out.println(i);
                return;
            } else {
                hashtable[input%buckets] = input;
            }
        }

        System.out.println(-1);

    }

}
