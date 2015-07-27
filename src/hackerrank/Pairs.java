package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  https://www.hackerrank.com/challenges/pairs
 */
public class Pairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int diff = in.nextInt();
        int[] list = new int[N];
        for(int a=0; a<N; a++) {
            list[a] = in.nextInt();
        }

        Arrays.sort(list);

        int count = 0;
        for(int i=0; i<N; i++) {
            if(list[i] > diff) {
                for (int j = 0; j < i; j++) {
                    if (list[i] - list[j] == diff) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);

    }

}
