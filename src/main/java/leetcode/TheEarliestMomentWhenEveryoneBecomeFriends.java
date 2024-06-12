package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/">...</a>
 *
 */
public class TheEarliestMomentWhenEveryoneBecomeFriends {

    public int earliestAcq(int[][] logs, int n) {
        UnionFind unionFind = new UnionFind(n);
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        System.out.println(Arrays.toString(logs));
        for (int i = 0; i < logs.length; i++) {
            int timestamp = logs[i][0];
            int x = logs[i][1];
            int y = logs[i][2];
            unionFind.union(x, y);
            if (unionFind.count == 1) return timestamp;
        }
        return -1;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        UnionFind(int n) {
            count = n;
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

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }
    }

    public static void main(String[] args) {
        int res = new TheEarliestMomentWhenEveryoneBecomeFriends().earliestAcq(
            new int[][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
            },5
        );
        System.out.println(res);
    }

}
