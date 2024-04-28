package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/">...</a>
 *
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String from = eq.get(0);
            String to = eq.get(1);
            double val = values[i];
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, val);
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(to).put(from, 1 / val);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String from = q.get(0);
            String to = q.get(1);

            if (!graph.containsKey(from) || !graph.containsKey(to)) ans[i] = -1.0;
            else if (from.equals(to)) ans[i] = 1.0;
            else {
                // Checking if from node available
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(graph, visited, from, to, 1);
            }
        }

        return ans;
    }

    public double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String current, String target, double product) {
        if (current.equals(target)) return product;
        visited.add(current);
        double p = -1.0;
        Map<String, Double> map = graph.get(current);
        if (map.isEmpty()) return p;
        else if (map.containsKey(target)) return product * map.get(target);
        else {
            for (String k: map.keySet()) {
                if (visited.contains(k)) continue;
                p = dfs(graph, visited, k, target, map.get(k) * product);
                if (p != -1.0) break;
            }
        }
        return p;
    }


    public double[] calcEquation_unionfind(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String from = eq.get(0);
            String to = eq.get(1);
            double val = values[i];
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, val);
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(to).put(from, 1 / val);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String from = q.get(0);
            String to = q.get(1);

            if (!graph.containsKey(from) || !graph.containsKey(to)) ans[i] = -1.0;
            else if (from.equals(to)) ans[i] = 1.0;
            else {
                // Checking if from node available
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(graph, visited, from, to, 1);
            }
        }

        return ans;
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
//        double[] ans = new EvaluateDivision().calcEquation(
//                List.of(
//                        List.of("a", "b"),
//                        List.of("b", "c")
//                ),
//                new double[]{
//                        2.0, 3.0
//                },
//                List.of(
//                        List.of("a", "c"),
//                        List.of("b", "a"),
//                        List.of("a", "e"),
//                        List.of("a", "a"),
//                        List.of("x", "x")
//                )
//        );
//        System.out.println(Arrays.toString(ans));

        double[] ans = new EvaluateDivision().calcEquation(
                List.of(
                    List.of("x1", "x2"),
                    List.of("x2", "x3"),
                    List.of("x3", "x4"),
                    List.of("x4", "x5")
                ),
                new double[]{
                    3.0, 4.0, 5.0, 6.0
                },
                List.of(
                    List.of("x1", "x5"),
                    List.of("x5", "x2"),
                    List.of("x2", "x4"),
                    List.of("x2", "x2"),
                    List.of("x2", "x9"),
                    List.of("x9", "x9")
                )
        );
        System.out.println(Arrays.toString(ans));
    }

}
