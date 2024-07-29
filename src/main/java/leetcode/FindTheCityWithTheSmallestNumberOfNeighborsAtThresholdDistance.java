package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/">1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance</a>
 *
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Create the array on each node to store the cost
        int[][] shortestMatrix = new int[n][n];
        int INF = (int) 1e9 + 7;
        // Set the default value as Integer.MAX_VALUE for dijkstra algorithm
        for (int[] shortest: shortestMatrix) {
            Arrays.fill(shortest, INF);
        }
        // Populate the adjacency list for this undirected weighted graph
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adjacencyList.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[] {to, weight});
            adjacencyList.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[] {from, weight});
        }

        // Running dijkstra algorithm on each node
        for (int i = 0; i < n; i++) {
            dijkstra(i, shortestMatrix[i], adjacencyList);
        }

        return findCity(n, distanceThreshold, shortestMatrix);
    }

    public int findTheCity_floydWarshall(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestMatrix = new int[n][n];
        int INF = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            // Prepopulate all values to the max
            Arrays.fill(shortestMatrix[i], INF);
            // Set to zero when src and dest are the same
            shortestMatrix[i][i] = 0;
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];
            // Bidirectional weighted graph
            shortestMatrix[from][to] = w;
            shortestMatrix[to][from] = w;
        }
        // Apply Floyd Warshall algorithm
        floydWarshall(shortestMatrix);

        // Once we have all the shortest path,
        // we can check each node and see how many cities it can reach,
        // and find the most isolated one
        return findCity(n, distanceThreshold, shortestMatrix);
    }

    private static int findCity(int n, int distanceThreshold, int[][] shortestMatrix) {
        int minCount = n;
        int ans = -1;
        for (int i = 0; i < shortestMatrix.length; i++) {
            int reachable = 0;
            for (int j = 0; j < shortestMatrix[i].length; j++) {
                if (i != j && shortestMatrix[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }
            if (minCount > reachable) {
                minCount = reachable;
                ans = i;
            }
        }
        return ans;
    }

    // Using Floyd Warshall algorithm when we want to find the shortest path on all nodes
    private void floydWarshall(int[][] matrix) {
        for (int inter = 0; inter < matrix.length; inter++) {
            for (int source = 0; source < matrix.length; source++) {
                for (int dest = 0; dest < matrix.length; dest++) {
                    if (matrix[source][dest] > matrix[source][inter] + matrix[inter][dest]) {
                        matrix[source][dest] = matrix[source][inter] + matrix[inter][dest];
                    }
                }
            }
        }
    }

    private void dijkstra(int source, int[] shortest, Map<Integer, List<int[]>> adjacencyList) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // Push the source first
        pq.add(new int[] { source, 0 });
        shortest[source] = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCity = current[0];
            int currentCost = current[1];
            if (shortest[currentCity] > currentCost) {
                continue;
            }
            if (adjacencyList.containsKey(currentCity)) {
                for (int[] neighbour : adjacencyList.get(currentCity)) {
                    int neighbourCity = neighbour[0];
                    int cost = neighbour[1];
                    if (shortest[neighbourCity] > currentCost + cost) {
                        shortest[neighbourCity] = currentCost + cost;
                        pq.add(new int[]{neighbourCity, shortest[neighbourCity]});
                    }
                }
            }
        }
    }

}
