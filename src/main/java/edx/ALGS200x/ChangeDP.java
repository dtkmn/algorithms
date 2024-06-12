package edx.ALGS200x;

import java.util.Scanner;

public class ChangeDP {

    private static int getChange(int m) {
        int[] min = new int[m+1];
        int[] coins = new int[]{1,3,4};
        int count = 0;
        count += getChange(coins, m, min);
        return count;
    }

    private static int getChange(int[] coins, int m, int[] min) {
        if (m == 0) return 0;
        if (m == 1) return 1;
        if (m < 0) return Integer.MAX_VALUE - 1;
        if (min[m] != 0) return min[m];
        int count1 =  1 + getChange(coins, m - coins[0], min);
        int count3 =  1 + getChange(coins, m - coins[1], min);
        int count4 =  1 + getChange(coins, m - coins[2], min);
        min[m] = Math.min((Math.min(count1, count3)), count4);
        return min[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }

}
