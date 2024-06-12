package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KruskalMSTReallySpecialSubtree {

    static class Edge {
        int to;
        int weight;
    }

    static class Node {
        int num;
        int weight;
        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer first = new StringTokenizer(br.readLine());
        int numOfNodes = Integer.parseInt(first.nextToken());
        int numOfEdges = Integer.parseInt(first.nextToken());
        Map<Integer, Edge>[] nodesArray = new HashMap[numOfNodes+1];

        for(int j=0; j<numOfEdges; j++) {
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(edge.nextToken());
            int to = Integer.parseInt(edge.nextToken());
            int weight = Integer.parseInt(edge.nextToken());
            // It is undirected graph!
            Map<Integer, Edge> edgesForFrom = nodesArray[from];
            if(edgesForFrom == null) edgesForFrom = new HashMap<>();

            Map<Integer, Edge> edgesForTo = nodesArray[to];
            if(edgesForTo == null) edgesForTo = new HashMap<>();

            Edge edgeFromTo = edgesForFrom.get(to);
            Edge edgeToFrom = edgesForTo.get(from);

            if(edgeFromTo == null) {
                edgeFromTo = new Edge();
                edgeFromTo.to = to;
                edgeFromTo.weight = Integer.MAX_VALUE;
            }

            if(edgeToFrom == null) {
                edgeToFrom = new Edge();
                edgeToFrom.to = from;
                edgeToFrom.weight = Integer.MAX_VALUE;
            }

            int min = weight;
            min = Math.min(min, edgeFromTo.weight);
            min = Math.min(min, edgeToFrom.weight);

            edgeFromTo.weight = min;
            edgeToFrom.weight = min;

            edgesForFrom.put(to, edgeFromTo);
            nodesArray[from] = edgesForFrom;
            edgesForTo.put(from, edgeToFrom);
            nodesArray[to] = edgesForTo;

        }

        int start = Integer.parseInt(br.readLine());
        int[] dp = new int[numOfNodes+1];
        for(int d=0; d<dp.length; d++) {
            dp[d] = -1;
        }
        int[] pred = new int[numOfNodes+1];
        for(int e=0; e<pred.length; e++) {
            pred[e] = -1;
        }
        int[] visited = new int[numOfNodes+1];

        PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        nodeQueue.add(new Node(start, 0));
        dp[start] = 0;
        pred[start] = -1;
        while(!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            int num = node.num;
            if(visited[num] == 0) {
                Map<Integer, Edge> edgeList = nodesArray[num];
                if (edgeList != null) {
                    for (Integer num1 : edgeList.keySet()) {
                        Edge edge = edgeList.get(num1);
                        if(visited[num1] == 0) {
                            int currentWeight = dp[edge.to];
                            if (currentWeight == -1 || edge.weight < currentWeight) {
                                dp[edge.to] = edge.weight;
                                pred[edge.to] = num;
                            }
                            nodeQueue.add(new Node(edge.to, edge.weight));
                        }
                    }
                }
                visited[num] = 1;
            }
        }

        int total = 0;
        for(int m=1; m<dp.length; m++) {
            if(m!=start) total += dp[m];
        }
        System.out.println(total);


    }

}
