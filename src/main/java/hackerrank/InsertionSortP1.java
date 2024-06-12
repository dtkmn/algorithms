package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class InsertionSortP1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];
        for(int i=0; i< N; i++) {
            ar[i] = in.nextInt();
        }

        int last = ar[N-1];

        for(int j=N-2; j>=0; j--) {
            if(ar[j] > last) {
                ar[j+1] = ar[j];
            } else if(ar[j] <= last) {
                ar[j+1] = last;
                break;
            }

            printArray(ar);

            if(j==0 && last < ar[j]) {
                ar[j] = last;
            }
        }
        printArray(ar);
    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

}
