package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 25/07/2015.
 */
public class GravityFlip {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cubes = new int[n];
        for(int i=0; i<n; i++) {
            cubes[i] = in.nextInt();
        }

        for(int p=0; p<n-1; p++) {
            for(int q=p+1; q<n; q++) {
                if(cubes[p]>cubes[q]) {
                    int temp = cubes[p];
                    cubes[p] = cubes[q];
                    cubes[q] = temp;
                }
            }
            System.out.print(cubes[p] + " ");
        }
        System.out.println(cubes[n-1]);


    }

}
