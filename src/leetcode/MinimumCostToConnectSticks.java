package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */
public class MinimumCostToConnectSticks {

    public static int connectSticks(int[] sticks) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int stick: sticks) {
            queue.add(stick);
        }
        int total = 0;
        while (queue.size() > 1) {
            int localSum = queue.poll() + queue.poll();
            total += localSum;
            queue.add(localSum);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(connectSticks(new int[]{2,4,3}));
        System.out.println(connectSticks(new int[]{1,8,3,5}));
    }

}
