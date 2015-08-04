package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 4/08/2015.
 */
public class ApplemanAndEasyTask {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 1) {
            String input = in.next();
            System.out.println("YES");
            return;
        }

        char[][] matrix = new char[n][n];
        for(int i=0; i<n; i++) {
            String input = in.next();
            for(int j=0; j<n; j++) {
                matrix[i][j] = input.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int count = 0;
                if(j-1>=0 && matrix[i][j-1] == 'o') count++;
                if(i-1>=0 && matrix[i-1][j] == 'o') count++;
                if(i+1<n && matrix[i+1][j] == 'o') count++;
                if(j+1<n && matrix[i][j+1] == 'o') count++;
                if(count!=0 && count%2 != 0) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }

}
