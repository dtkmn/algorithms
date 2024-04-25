package leetcode;

/**
 * <a href="https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/">...</a>
 *
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            unionFind.union(x, y);
        }
        return unionFind.count;
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
        int res = new NumberOfConnectedComponentsInAnUndirectedGraph().countComponents(5,
            new int[][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
            }
        );
        System.out.println(res);
    }

}
