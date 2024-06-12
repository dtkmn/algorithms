package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/optimize-water-distribution-in-a-village/">...</a>
 *
 */
public class OptimizeWaterDistributionInAVillage {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < wells.length; i++) {
            pq.add(new int[] { 0, i + 1, wells[i] });
        }
        for (int i = 0; i < pipes.length; i++) {
            int from = pipes[i][0];
            int to = pipes[i][1];
            int cost = pipes[i][2];
            pq.add(new int[] { from, to, cost });
        }

        UnionFind unionFind = new UnionFind(n + 1);
        int cost = 0;
        int edgeUsed = 0;
        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            int x = e[0];
            int y = e[1];
            int c = e[2];
            if (unionFind.union(x, y)) {
                cost += c;
                if (++edgeUsed == n) break;
            }
        }
        return cost;
    }

    class UnionFind {

        int[] parent;
        int[] rank;

        UnionFind(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            while (x != parent[x]) x = parent[x];
            return x;
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            System.out.println(rootX + ": " + rootY);
            if (rootX == rootY) return false;
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }

    }



    public static void main(String[] args) {
        /**
         *  Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
         *  Output: 3
         */
        int cost = new OptimizeWaterDistributionInAVillage().minCostToSupplyWater(
                3,
                new int[]{1, 2, 2},
                new int[][]{
                    new int[]{1, 2, 1},
                    new int[]{2, 3, 1}
                }
        );
        System.out.println(cost);
    }

}
