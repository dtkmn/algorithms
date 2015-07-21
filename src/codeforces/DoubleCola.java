package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class DoubleCola {

    public static void main(String[] args) {

        String[] initQueue = {"","Sheldon","Leonard","Penny","Rajesh","Howard"};

        Scanner in = new Scanner(System.in);
        int loc = in.nextInt();
        int n = 5;

        if(loc > 0 && loc <=5) {
            System.out.println(initQueue[loc]);
            return;
        }

        int i = 1;
        double currentTotal = (n*Math.pow(2,i) + n*Math.pow(2,i-1));
        while(loc > currentTotal) {
            i++;
            currentTotal += n*Math.pow(2,i);
        }

//        System.out.println(i);
        double rangeStart = 0.0, rangeEnd = 0.0;

        rangeStart = rangeStart(i);
        rangeEnd = (rangeStart(i) + n*Math.pow(2,i) - 1);
//        System.out.println("Start: " + rangeStart + " End: " + rangeEnd);

        double pos = loc - rangeStart + 1;
        int group = 1;
        while(pos > group*Math.pow(2, i)) {
            group++;
        }
//        System.out.println("GROUP: " + group);
        System.out.println( initQueue[group] );
    }

    static double rangeStart(int i) {
        if(i == 0) return 1;
        if(i == 1) return 6;
        return rangeStart(i-1) + 5 * Math.pow(2, i-1);
    }



}
