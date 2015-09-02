package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 2/09/2015.
 */
public class SwapSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] list = new int[N];
        for(int i=0; i<N; i++) {
            list[i] = in.nextInt();
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N-1; i++) {
            int temp = list[i];
            int minPos = -1;
            int min = Integer.MAX_VALUE;
            for(int j = i; j < N; j++) {
                if(min > list[j]) {
                    minPos = j;
                    min = list[j];
                }
            }
            if(minPos != i) {
                // SWAP ITEM i AND j
                list[i] = list[minPos];
                list[minPos] = temp;
                sb.append(i + " " + minPos + '\n');
                count++;
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());

    }

}
