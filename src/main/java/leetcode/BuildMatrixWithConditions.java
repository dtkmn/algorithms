package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/build-a-matrix-with-conditions/">2392. Build a Matrix With Conditions</a>
 */
public class BuildMatrixWithConditions {

//    Input: k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
    public int[][] buildMatrix(
            int k,
            int[][] rowConditions,
            int[][] colConditions
    ) {
        int[] r = topologicalSort(rowConditions, k);
        int[] c = topologicalSort(colConditions, k);

        if (r.length == 0 || c.length == 0) return new int[0][0];
        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (r[i] == c[j]) {
                    matrix[i][j] = r[i];
                }
            }
        }
        return matrix;
    }

    public int[] topologicalSort(int[][] conditions, int k) {
        int[] indegree = new int[k + 1];
        Map<Integer, List<Integer>> preToPost = new HashMap<>();
        for (int[] c: conditions) {
            int pre = c[0];
            int post = c[1];
            indegree[post]++;
            List<Integer> list = preToPost.computeIfAbsent(pre, p -> new ArrayList<>());
            list.add(post);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] sort = new int[k];
        int pos = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sort[pos++] = poll;
            if (preToPost.containsKey(poll)) {
                for (int n : preToPost.get(poll)) {
                    if (--indegree[n] == 0) {
                        queue.offer(n);
                    }
                }
            }
        }
        return pos != 0? sort: new int[0];
    }

}
