package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 14/08/2015.
 */
public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] list = new int[N];
        for(int i=0; i<N; i++) {
            list[i] = in.nextInt();
        }
        Arrays.sort(list);
        System.out.println(N);
        int min = list[0];
        for(int i=0; i<N; i++) {
            if(min < list[i]) {
                System.out.println(N-i);
                min = list[i];
            }
        }

    }

}
