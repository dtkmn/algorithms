package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class IQTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int countOdd = 0, countEven = 0;
        int lastOdd = -1, lastEven = -1;
        for(int i=1; i<=n; i++) {
            int a = in.nextInt();
            if(a%2==0) {
                lastEven = i;
                countEven++;
            } else {
                lastOdd = i;
                countOdd++;
            }
        }
        if(countEven == 1) {
            System.out.println(lastEven);
        } else {
            System.out.println(lastOdd);
        }


    }

}
