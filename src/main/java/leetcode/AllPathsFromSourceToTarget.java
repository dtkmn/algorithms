package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/description/">...</a>
 *
 */
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < graph.length; i++){
            g.putIfAbsent(i, new ArrayList<>());
            for (int node: graph[i]) {
                g.get(i).add(node);
            }
        }
        int s = 0;
        int d = graph.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> fromSource = new ArrayList<>();
        fromSource.add(s);
        stack.push(fromSource);
        while (!stack.isEmpty()) {
            List<Integer> cur = stack.pop();
            int lastNode = cur.getLast();
            if (lastNode == d) {
                ans.add(cur);
            } else {
                for (int neighbour: g.get(lastNode)) {
                    List<Integer> path = new ArrayList<>(cur);
                    path.add(neighbour);
                    stack.push(path);
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> ansDfs = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget_dfs(int[][] graph) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < graph.length; i++){
            g.putIfAbsent(i, new ArrayList<>());
            for (int node: graph[i]) {
                g.get(i).add(node);
            }
        }
        List<Integer> rootPath = new ArrayList<>();
        rootPath.add(0);
        dfs(rootPath, g, graph.length - 1);
        return ansDfs;
    }

    void dfs(List<Integer> path, Map<Integer, List<Integer>> graph, int destination) {
        int curr = path.getLast();
        if (curr == destination) {
            ansDfs.add(new ArrayList<>(path));
            return;
        }
        for (int neighbour: graph.get(curr)) {
//            List<Integer> p = new ArrayList<>(path);
            path.add(neighbour);
            dfs(path, graph, destination);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new AllPathsFromSourceToTarget().allPathsSourceTarget_dfs(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3},
                        new int[]{3},
                        new int[]{}
                }
        );
        for (List<Integer> path: lists) {
            System.out.println(path);
        }
    }
}
