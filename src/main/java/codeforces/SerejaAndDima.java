package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 20/08/2015.
 */
public class SerejaAndDima {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputs = new int[n];
        for(int i=0; i<n; i++) {
            inputs[i] = in.nextInt();
        }
        // Sereja first, Dima second
        int serejaScore = 0, dimaScore = 0;
        int term = 1;
        int start = 0, end = n-1;
        while(start != end) {
            if(term%2!=0) {
                if(inputs[start] > inputs[end]) {
                    serejaScore += inputs[start];
                    start++;
                } else {
                    serejaScore += inputs[end];
                    end--;
                }
            } else {
                if(inputs[start] > inputs[end]) {
                    dimaScore += inputs[start];
                    start++;
                } else {
                    dimaScore += inputs[end];
                    end--;
                }
            }
            term++;
        }
        // last term
        if(term%2==0) {
            dimaScore += inputs[start];
        } else {
            serejaScore += inputs[start];
        }

        System.out.println(serejaScore + " " + dimaScore);

    }

}
