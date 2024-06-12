package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/the-kth-factor-of-n/">...</a>
 *
 */

public class TheKthFactorOfN {

    public int kthFactorV2(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
            if (count == k) return i;
        }
        return -1;
    }

    public int kthFactor(int n, int k) {
        // Max heaps here with size k
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int max = n;
        for (int i = 1; i < max; i++) {
            if (n % i == 0) {
                pq.offer(i);
                int b = n / i;
                if (i != b) pq.offer(b);
                max = b;
            }
        }
        int s = pq.size() - k;
        if (pq.size() < k) return -1;
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        TheKthFactorOfN factor = new TheKthFactorOfN();
//        System.out.println(factor.kthFactor(12, 3));
//        System.out.println(factor.kthFactor(7, 2));
//        System.out.println(factor.kthFactor(4, 4));
//        System.out.println(factor.kthFactor(2, 2));
        System.out.println(factor.kthFactor(24, 6));
    }

}
