package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 28/07/2015.
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a=0; a<T; a++) {

            int dollars = in.nextInt();
            int numFlavors = in.nextInt();
            int[] flavors = new int[numFlavors];
            for (int i = 0; i < flavors.length; i++) {
                flavors[i] = in.nextInt();
            }

            boolean found = false;
            for (int j = 0; j < numFlavors; j++) {
                for (int k = 0; k < numFlavors; k++) {
                    if (j != k) {
                        if (flavors[j] + flavors[k] == dollars) {
                            System.out.println((j+1) + " " + (k+1));
                            found = true;
                            break;
                        }
                    }
                }
                if(found) break;
            }
        }



    }

}
