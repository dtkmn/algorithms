package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {

    private static final PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
                }
            }
    );
    public static int[][] kClosest(int[][] points, int k) {
        for (int[] point: points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) maxHeap.poll();
//            if (maxHeap.size() < k) maxHeap.offer(point);
//            else {
//                int d = point[0] * point[0] + point[1] * point[1];
//                int[] peek = maxHeap.peek();
//                int peekD = peek[0] * peek[0] + peek[1] * peek[1];
//                if (d < peekD) {
//                    maxHeap.poll();
//                    maxHeap.offer(point);
//                }
//            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{
                {1, 3},
                {-2, 2}
        }, 1)));
    }

}
