package topcoder;

import java.util.Arrays;

/**
 * Created by datse on 11/08/2015.
 */
public class BadNeighbors {

    public static void main(String[] args) {
//        int[] donations = { 10, 3, 2, 5, 7, 8 };
        int[] donations = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
//        int[] donations = { 11, 15 };
//        int[] donations = { 7, 7, 7, 7, 7, 7, 7 };
//        int[] donations = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
//                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
//                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
        System.out.println(new BadNeighbors().maxDonations(donations));
    }

    public int maxDonations(int[] donations) {
        int l = donations.length;
        int[] max = new int[l];
        max[0] = donations[0];
        max[1] = donations[1];
        int maxNumber = Math.max(max[0], max[1]);
        for(int i=2; i<l; i++) {
            if(l%2 != 0 && i == l-1) {
                max[i] = max[i-2];
            } else {
                max[i] = donations[i] + max[i-2];
//            max[i] = Math.max(donations[i-1], donations[i]+donations[i-2]);
                maxNumber = Math.max(max[i], max[i-1]);
            }
        }
        System.out.println(Arrays.toString(max));
        return maxNumber;
    }

}
