package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class InsertionSortP2 {

    public static void insertionSortPart2(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        int N = ar.length;
        for(int j=1; j<N; j++) {
            int t = ar[j];
            for(int k=j-1; k>=0; k--) {
                if(ar[k] > t) {
                    ar[k+1] = ar[k];
                    ar[k] = t;
                }
            }
            printArray(ar);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

}
