package leetcode;

/**
 * <a href="https://leetcode.com/problems/graph-valid-tree/">...</a>
 *
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        int count = n;
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!unionFind.union(x, y)) return false;
            count--;
        }
        return count == 1;
    }

    class UnionFind {

        private int[] parent;
        private int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            while(x != parent[x]) x = parent[x];
            return x;
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // Already visited and with same root so cycle it is
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
        boolean res = new GraphValidTree().validTree(5,
            new int[][] {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
            }
        );
        System.out.println(res);
    }

}
