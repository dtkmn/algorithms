package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 24/08/2015.
 */
public class PashaAndPixels {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int move = in.nextInt();

        int[][] matrix = new int[rows+1][cols+1];

        for(int i=0; i<move; i++) {
            int row = in.nextInt();
            int col = in.nextInt();

            if(row > rows || col > cols) {
                continue;
            }

            matrix[row][col] = 1;

//            for(int ii=0; ii<=rows; ii++) {
//                System.out.println(Arrays.toString(matrix[ii]));
//            }
//            System.out.println();

            if(row-1>=1 && col-1>=1) {
                if(matrix[row][col-1] == 1 &&
                    matrix[row-1][col] == 1 &&
                    matrix[row-1][col-1] == 1) {
                    System.out.println(i+1);
                    return;
                }
            }
            if(row-1>=1 && row+1<=rows && col+1<=cols) {
                if(matrix[row][col+1] == 1 &&
                        matrix[row-1][col] == 1 &&
                        matrix[row+1][col+1] == 1) {
                    System.out.println(i+1);
                    return;
                }
            }
            if(row+1<=rows && row-1>=1 && col-1>=1) {
                if(matrix[row][col-1] == 1 &&
                        matrix[row-1][col-1] == 1 &&
                        matrix[row+1][col] == 1) {
                    System.out.println(i+1);
                    return;
                }
            }
            if(row+1<=rows && col+1<=cols) {
                if(matrix[row][col+1] == 1 &&
                        matrix[row+1][col+1] == 1 &&
                        matrix[row+1][col] == 1) {
                    System.out.println(i+1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

}
