package hackerrank.ThirtyDaysOfCodeJan2016;

import java.util.Scanner;

public class Day11MoreReview {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i<6; i++) {
            for(int j=0; j<6; j++) {
                arr[i][j] = in.nextInt();
//                System.out.print(arr[i][j] + " ");
            }
//            System.out.println();
        }
//        System.out.println();
        int max = Integer.MIN_VALUE;
        for(int x=0; x<=3; x++) {
            for(int y=0; y<=3; y++) {
//                System.out.println("x => " + x + " y => " + y);
//                System.out.println(arr[x][y] + " " + arr[x][y+1] + " " + arr[x][y+2] +
//                        " " + arr[x+1][y+1] +
//                        " " + arr[x+2][y] + " " + arr[x+2][y+1] + " " + arr[x+2][y+2]);
                int sum =
                    arr[x][y] + arr[x][y+1] + arr[x][y+2] +
                    arr[x+1][y+1] +
                    arr[x+2][y] + arr[x+2][y+1] + arr[x+2][y+2];
//                System.out.println(sum);
                max = Math.max(max, sum);
            }
        }
//        System.out.println();
        System.out.println(max);
    }

}
