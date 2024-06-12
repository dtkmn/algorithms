package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/design-graph-with-shortest-path-calculator/description/">...</a>
 *
 */

class Edge {
    int target;
    int weight;

    Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Edge{" +
                "target=" + target +
                ", weight=" + weight +
                '}';
    }
}

class Graph {
    // Save the nearby edges for each node
    Map<Integer, List<Edge>> graph = new HashMap<>();
    int[] costForNode;

    public Graph(int n, int[][] edges) {
        for (int[] edge: edges) {
            addEdge(edge);
        }
        costForNode = new int[n];
    }

    public void addEdge(int[] edge) {
        List<Edge> edgeList = graph.getOrDefault(edge[0], new ArrayList<>());
        edgeList.add(new Edge(edge[1], edge[2]));
        graph.put(edge[0], edgeList);
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<Edge> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Arrays.fill(costForNode, Integer.MAX_VALUE);
        costForNode[node1] = 0;

        // Start from the source with weight == 0
        minHeap.add(new Edge(node1, 0));
        while (!minHeap.isEmpty()) {
            var current = minHeap.poll();
            if (current.target == node2) return current.weight;

            for (Edge edge: graph.getOrDefault(current.target, new ArrayList<>())) {
                int newDistance = edge.weight + current.weight;
                if (newDistance < costForNode[edge.target]) {
                    costForNode[edge.target] = newDistance;
                    minHeap.add(new Edge(edge.target, newDistance));
                }
            }
        }

        return -1;
    }

}

public class DesignGraphWithShortestPathCalculator {



    public static void main(String[] args) {
        Graph graph = new Graph(4, new int[][]{
                {0, 2, 5},
                {0, 1, 2},
                {1, 2, 1},
                {3, 0, 3}
        });
        System.out.println(
            graph.shortestPath(3,2)
        );
    }

}
