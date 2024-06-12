package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by dtkmn on 18/07/2015.
 */
public class TaumAndBday {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {

            long numB = in.nextInt();
            long numW = in.nextInt();
            long costB = in.nextInt();
            long costW = in.nextInt();
            long costConvert = in.nextInt();
            long price;

            int bCheaper = -1;
            if(costB < costW) {
                bCheaper = 1;
            } else if(costB > costW) {
                bCheaper = 0;
            }

            if(bCheaper == 1) {
                // should calculate basd on b
                // and check we should use W price or convert instead
                if(costW <= costB + costConvert) {
                    // Use W price
                    price = numB * costB + numW * costW;
                } else {
                    // should buy B for all and convert required number to W
                    price = (numB + numW) * costB + numW * costConvert;
                }
            } else {
                // when W is cheaper
                if(costB <= costW + costConvert) {
                    price = numB * costB + numW * costW;
                } else {
                    price = (numB + numW) * costW + numB * costConvert;
                }
            }

            System.out.println(price);


        }
    }

}
