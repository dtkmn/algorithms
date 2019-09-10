package edx.ALGS200x;

import java.util.Scanner;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
//        return lcs3(a, b, c, a.length - 1, b.length - 1, c.length - 1);
        return lcs3_iter(a, b, c);
    }

    private static int lcs3_iter(int[] a, int[] b, int[] c) {
        int[][][] lcs = new int[a.length+1][b.length+1][c.length+1];
        for (int cc = 0; cc <= c.length; cc++) {
            for (int i = 0; i <= b.length; i++) {
                lcs[0][i][cc] = 0;
            }
        }
        for (int cc = 0; cc <= c.length; cc++) {
            for (int j = 0; j <= a.length; j++) {
                lcs[j][0][cc] = 0;
            }
        }

        for (int u = 1; u <= a.length; u++) {
            for (int v = 1; v <= b.length; v++) {
                for (int w = 1; w <= c.length; w++) {
                    if (a[u-1] == b[v-1] && b[v-1] == c[w-1]) {
                        lcs[u][v][w] = 1 + lcs[u-1][v-1][w-1];
                    } else {
                        lcs[u][v][w] = Math.max(Math.max(lcs[u-1][v][w], lcs[u][v-1][w]), lcs[u][v][w-1]);
                    }
                }
            }
        }

        return lcs[a.length][b.length][c.length];
    }

    private static int lcs3(int[] a, int[] b, int[] c, int aindex, int bindex, int cindex) {
        if (aindex < 0 || bindex < 0 || cindex < 0) return 0;
        if (a[aindex] == b[bindex] && b[bindex] == c[cindex] && a[aindex] == c[cindex]) {
            return 1 + lcs3(a, b, c, aindex - 1, bindex - 1, cindex - 1);
        } else {
            int count1 = lcs3(a, b, c, aindex, bindex - 1, cindex);
            int count2 = lcs3(a, b, c, aindex - 1, bindex, cindex);
            int count3 = lcs3(a, b, c, aindex, bindex, cindex - 1);
            return Math.max(Math.max(count1, count2), count3);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }

}
