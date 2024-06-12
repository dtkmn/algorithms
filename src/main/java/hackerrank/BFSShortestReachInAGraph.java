package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BFSShortestReachInAGraph {

    public static class Graph {

        Set<Integer>[] edgeTo;

        public Graph(int size) {
            edgeTo = new Set[size];
        }

        public void addEdge(int first, int second) {
            Set<Integer> list = edgeTo[first];
            if(list == null) {
                list = new HashSet<>();
            }
            list.add(second);
            edgeTo[first] = list;

            Set<Integer> list2 = edgeTo[second];
            if(list2 == null) {
                list2 = new HashSet<>();
            }
            list2.add(first);
            edgeTo[second] = list2;

        }

        class Node {
            int id;
            int level;
            Node(int id, int level) {
                this.id = id;
                this.level = level;
            }
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] result = new int[edgeTo.length];
            ArrayDeque<Node> queueNode = new ArrayDeque<>();
            for(int i=0; i<result.length; i++) {
                if(i == startId) continue;
                queueNode.clear();
                Node node = new Node(startId, 0);
                queueNode.add(node);
                int count = 0;
                boolean[] visited = new boolean[result.length];

                while(!queueNode.isEmpty()) {
                    Node head = queueNode.pop();
                    if(!visited[head.id]) {
                        visited[head.id] = true;
                        if (head.id == i) {
                            result[i] = head.level * 6;
                            break;
                        } else {
                            if (edgeTo[head.id] != null) {
                                count++;
                                for (int ne : edgeTo[head.id]) {
                                    if (!visited[ne]) {
                                        Node node1 = new Node(ne, head.level + 1);
                                        queueNode.add(node1);
                                    }
                                }
                            }
                        }
                    }
                }
                if(result[i]==0) result[i] = -1;
            }
            return result;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int queries = Integer.parseInt(br.readLine());

        for (int t = 0; t < queries; t++) {
            // Create a graph of size n where each edge weight is 6:
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Graph graph = new Graph(n);
            int m = Integer.parseInt(st.nextToken());

            // read and set edges
            for (int i = 0; i < m; i++) {
                StringTokenizer row = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(row.nextToken()) - 1;
                int v = Integer.parseInt(row.nextToken()) - 1;
                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = Integer.parseInt(br.readLine()) - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
