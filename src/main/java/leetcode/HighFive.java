package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  https://leetcode.com/problems/high-five/
 *
 */
public class HighFive {

    // 3ms
    public static int[][] highFive2(int[][] items) {

        // Time Complexity: O(NlogN) N == items length
        // Sort by 'student id' and 'scores'
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        int pre = -1, sum = 0, count = 0;

        // Space Complexity: O(Number of students)
        // or not count since it is for output
        List<int[]> res = new ArrayList<>();

        // Time Complexity: O(N)
        for (int i = 0; i < items.length; i++) {
            int[] pair = items[i];
            if (pair[0] == pre) {
                if (count < 5) sum += pair[1];
                count++;
            } else {
                if (pre != -1) res.add(new int[] { pre, sum/5 });
                pre = pair[0];
                sum = pair[1];
                count = 1;
            }
        }
        res.add(new int[] { pre, sum/5 });

        return res.toArray(new int[res.size()][]);
    }

    // 10ms
    public int[][] highFive(int[][] items) {

        Map<Integer, PriorityQueue<Integer>> studentPQ = new HashMap<>();

        for (int[] pair: items) {
            int studentId = pair[0];
            int studentScore = pair[1];

            if (!studentPQ.containsKey(studentId)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(studentScore);
                studentPQ.put(studentId, pq);
            } else {
                PriorityQueue<Integer> pq = studentPQ.get(studentId);
                if (pq.size() < 5) pq.add(studentScore);
                else {
                    if (pq.peek() < studentScore) {
                        pq.poll();
                        pq.add(studentScore);
                    }
                }
                studentPQ.put(studentId, pq);
            }
        }

        int[][] res = new int[studentPQ.size()][2];
        int count = 0;
        for (int id: studentPQ.keySet()) {
            PriorityQueue<Integer> pq = studentPQ.get(id);
            int total = 0;
            while (!pq.isEmpty()) {
                total += pq.poll();
            }
            int[] item = new int[] { id, total / 5 };
            res[count++] = item;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(highFive2(new int[][] {
            {1, 91}, {1, 92} , {2, 93}, {2, 97}, {1,60}, {2,77},
            {1, 65}, {1, 87}, {1, 100}, {2,100}, {2,76}
        })));
    }

}
