package edx.ALGS200x;

import java.util.Scanner;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
//        return lcs2(a, b, a.length - 1, b.length - 1);
        return lcs2_iter(a, b);
    }

    private static int lcs2_iter(int[] a, int[] b) {
        int[][] lcs = new int[a.length+1][b.length+1];
        for (int i = 0; i <= b.length; i++) {
            lcs[0][i] = 0;
        }
        for (int j = 0; j <= a.length; j++) {
            lcs[j][0] = 0;
        }
        for (int m = 1; m <= a.length; m++) {
            for (int n = 1; n <= b.length; n++) {
                if (a[m-1] == b[n-1]) {
                    lcs[m][n] = lcs[m-1][n-1] + 1;
                } else {
                    lcs[m][n] = Math.max(lcs[m-1][n], lcs[m][n-1]);
                }
            }
        }

        return lcs[a.length][b.length];
    }

    private static int lcs2(int[] a, int[] b, int aindex, int bindex) {
        if (aindex < 0 || bindex < 0) return 0;
        if (a[aindex] == b[bindex]) {
            return 1 + lcs2(a, b, aindex - 1, bindex - 1);
        } else {
            int count1 = lcs2(a, b, aindex, bindex - 1);
            int count2 = lcs2(a, b, aindex - 1, bindex);
            return Math.max(count1, count2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }

}
