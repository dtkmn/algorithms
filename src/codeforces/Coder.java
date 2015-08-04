package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 4/08/2015.
 */
public class Coder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n % 2 == 0) {
            System.out.println((int)Math.pow(n, 2)/2);
        } else {
            System.out.println((int)(Math.pow(n, 2) + 1) / 2);
        }
        StringBuilder sbOdd = new StringBuilder(), sbEven = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                if(sbEven.length() == 0) {
                    for(int j=0; j<n; j++) {
                        if(j % 2 == 0) {
                            sbEven.append('C');
                        } else {
                            sbEven.append('.');
                        }
                    }
                }
                sb = sbEven;
            } else {
                if(sbOdd.length() == 0) {
                    for (int j = 0; j < n; j++) {
                        if (j % 2 == 0) {
                            sbOdd.append('.');
                        } else {
                            sbOdd.append('C');
                        }
                    }
                }
                sb = sbOdd;
            }
            System.out.println(sb.toString());
        }

    }

}
