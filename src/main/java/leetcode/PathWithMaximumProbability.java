package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/path-with-maximum-probability/">1514. Path with Maximum Probability</a>
 *
 s */

public class PathWithMaximumProbability {

    private static class Pair {
        private int to;
        private double p;
        Pair(int to, double p) {
            this.to = to;
            this.p = p;
        }
    }

    /**
     * Dijkstra's Algorithm Approach
     */
    public double maxProbabilityDijkstra(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            graph.computeIfAbsent(a, v -> new ArrayList<>()).add(new Pair(b, p));
            graph.computeIfAbsent(b, v -> new ArrayList<>()).add(new Pair(a, p));
        }
        double[] maxp = new double[n];
        maxp[start_node] = 1;   // The probability is 100% on start_node
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.p, o1.p));
        pq.add(new Pair(start_node, 1));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currTo = current.to;
            double currP = current.p;
            if (currTo == end_node) {   // Early Termination
                return currP;
            }
            if (graph.containsKey(currTo)) {
                for (Pair pair: graph.get(currTo)) {
                    if (pair.p * currP > maxp[pair.to]) {
                        maxp[pair.to] = pair.p * currP;
                        pq.add(new Pair(pair.to, maxp[pair.to]));
                    }
                }
            }
        }
        return 0;
    }

    /**
     * SPFA Approach
     */
    public double maxProbabilitySPFA(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            graph.computeIfAbsent(a, v -> new ArrayList<>()).add(new Pair(b, p));
            graph.computeIfAbsent(b, v -> new ArrayList<>()).add(new Pair(a, p));
        }
        double[] maxp = new double[n];
        maxp[start_node] = 1;   // The probability is 100% on start_node
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start_node, 1));
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int currTo = current.to;
            double currP = current.p;
            for (Pair pair: graph.getOrDefault(currTo, new ArrayList<>())) {
                if (pair.p * currP > maxp[pair.to]) {
                    maxp[pair.to] = pair.p * currP;
                    q.add(new Pair(pair.to, maxp[pair.to]));
                }
            }
        }
        return maxp[end_node];
    }

    /**
     * Bellman-Ford Algorithm Approach
     */
    public double maxProbabilityBellmanFord(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }
            if (!hasUpdate) {   // Early Termination
                break;
            }
        }
        return maxProb[end_node];
    }

}
