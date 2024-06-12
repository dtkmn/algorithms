package hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by dtkmn on 22/08/2015.
 */
public class TwoArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            Integer[] firstArray = new Integer[n];
            Integer[] secondArray = new Integer[n];
            for(int j=0; j<n; j++) {
                firstArray[j] = in.nextInt();
            }
            for(int j=0; j<n; j++) {
                secondArray[j] = in.nextInt();
            }

            Arrays.sort(firstArray);
            Arrays.sort(secondArray, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            boolean t = true;
            for(int p=0; p<n; p++) {
                if(firstArray[p] + secondArray[p] < k) {
                    t = false;
                    break;
                }
            }
            System.out.println(t?"YES":"NO");
        }
    }

}
