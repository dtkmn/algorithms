package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class FoxAndSnake {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(i%2!=0) {
                    System.out.print("#");
                    if(j==m) System.out.print("\n");
                } else if(i%2==0 && i%4!=0 && j==m) {
                    System.out.println("#");
                } else if(i%2==0 && i%4==0 && j==1) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                    if(j==m) System.out.print("\n");
                }
            }
        }


    }

}
