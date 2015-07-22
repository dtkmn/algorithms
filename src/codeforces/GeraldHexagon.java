package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class GeraldHexagon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        int max = 0;
        int moreThanOne = 0;
        for(int i=0; i<6; i++) {
            int l = in.nextInt();
            if(l>1) {
                moreThanOne++;
                sum += 2*l;
            } else {
                sum += l;
            }
//            max = l>max?l:max;
        }

        count = sum - moreThanOne;
//        if(sum % 2 != 0) {
//
//            count += (sum - 1)/2;
//
//        }
//        if(max > 1) {
//            count += Math.pow(2, max);
//        }
        System.out.println(count);
    }

}
