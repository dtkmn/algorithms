package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/min-cost-to-connect-all-points/">...</a>
 *
 */
public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < n - 1; i++) {
            int pt1X = points[i][0];
            int pt1Y = points[i][1];
            for (int next = i + 1; next < n; next++) {
                int pt2X = points[next][0];
                int pt2Y = points[next][1];
                int c = Math.abs(pt1X - pt2X) + Math.abs(pt1Y - pt2Y);
                pq.add(new int[] { i, next, c });
            }
        }

        UnionFind unionFind = new UnionFind(n);
        int cost = 0;
        int edgeUsed = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int x = edge[0];
            int y = edge[1];
            int c = edge[2];
            if (unionFind.union(x, y)) {
                cost += c;
                if (++edgeUsed == n - 1) break;
                System.out.println(cost + ": " + edgeUsed);
            }
        }
        return cost;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
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
            if (rootX == rootY) return false;
            if (rank[rootY] > rank[rootX]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] > rank[rootY]) {
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
         *  Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
         *  Output: 20
         */
        int cost = new MinCostToConnectAllPoints().minCostConnectPoints(
                new int[][]{
                        new int[]{0, 0},
                        new int[]{2, 2},
                        new int[]{3, 10},
                        new int[]{5, 2},
                        new int[]{7, 0},
                }
        );
        System.out.println(cost);
    }

}
