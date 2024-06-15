package leetcode;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/ipo/">502. IPO</a>
 */
public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq1ByCapOrder = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq2ByProfitOrder = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));

        for (int i = 0; i < profits.length; i++) {
            if (w >= capital[i]) {
                pq2ByProfitOrder.add(new int[] { capital[i], profits[i] });
            } else {
                pq1ByCapOrder.add(new int[] { capital[i], profits[i] });
            }
        }

        int count = 0;
        while (k > count && !pq2ByProfitOrder.isEmpty()) {
            int[] project = pq2ByProfitOrder.poll();
            w += project[1];
            while (!pq1ByCapOrder.isEmpty() && pq1ByCapOrder.peek()[0] <= w) {
                pq2ByProfitOrder.add(pq1ByCapOrder.poll());
            }
            count++;
        }

        return w;
    }

}
