package hackerrank;

import java.util.Scanner;

/**
 * Created by datse on 29/07/2015.
 */
public class CravityMap {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        char[][] matrix = new char[size][size];
        for(int i=0; i<size; i++) {
            matrix[i] = in.next().toCharArray();
        }

        for(int m=1; m<size-1 ;m++) {
            for(int n=1; n<size-1; n++) {
                if( matrix[m][n] > matrix[m-1][n] &&
                    matrix[m][n] > matrix[m+1][n] &&
                        matrix[m][n] > matrix[m][n-1] &&
                        matrix[m][n] > matrix[m][n+1]) {
                    matrix[m][n] = 'X';
                }
            }
        }

        for(int p=0; p<size ;p++) {
            System.out.println(new String(matrix[p]));
        }

    }

}
