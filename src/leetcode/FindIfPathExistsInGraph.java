package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">...</a>
 *
 */
public class FindIfPathExistsInGraph {

    public boolean validPath_dfs(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        visited[source] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (curr == destination) return true;
            for (int next: graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
        return false;
    }

    public boolean validPath_unionfind(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            unionFind.union(from, to);
        }
        return unionFind.find(source) == unionFind.find(destination);
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootY] > rank[rootX]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                    rank[rootY]++;
                }
            }
        }
    }

    public static void main(String[] args) {
    }

}
