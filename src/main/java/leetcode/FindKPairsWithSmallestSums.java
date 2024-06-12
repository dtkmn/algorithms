package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">...</a>
 */
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int sum1 = o1[0] + o1[1];
            int sum2 = o2[0] + o2[1];
            return sum2 - sum1;
        });

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (pq.size() < k) pq.offer(new int[] { nums1[i], nums2[j] });
                else {
                    int[] poll = pq.peek();
                    if (poll[0] + poll[1] > nums1[i] + nums2[j]) {
                        pq.poll();
                        pq.offer(new int[] { nums1[i], nums2[j] });
                    }
                }
            }
        }

        for (int i = 0; i < k; i++) {
            int[] item = pq.poll();
            ans.add(List.of(item[0], item[1]));
        }
        return ans;
    }


    public List<List<Integer>> kSmallestPairsV2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int sum1 = o1[0] + o1[1];
            int sum2 = o2[0] + o2[1];
            return sum1 - sum2;
        });

        // Adding every element from nums1 and pair them with nums2[0]
        // The third item is the index of current nums2
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[] { nums1[i], nums2[0], 0});
        }




        while (k > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            ans.add(List.of(current[0], current[1]));
            k--;
            if (current[2] == nums2.length - 1) continue;
            pq.offer(new int[] { current[0], nums2[current[2] + 1], current[2] + 1});
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new FindKPairsWithSmallestSums().kSmallestPairs(
                new int[]{1, 2, 4, 5, 6},
                new int[]{3, 5, 7, 9},
                2
        );
        System.out.println(lists);
    }

}
