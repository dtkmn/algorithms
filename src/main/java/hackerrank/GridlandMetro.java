package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
}

public class GridlandMetro {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<Long, List<Node>> cells = new HashMap<>();
        for(int i=0; i<k; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            long row = Long.parseLong(line.nextToken());
            long c1 = Long.parseLong(line.nextToken());
            long c2 = Long.parseLong(line.nextToken());
            List<Node> nodeList = cells.get(row);

            if(nodeList == null || nodeList.size() == 0) {
                Node currentNode = new Node();
                currentNode.min = c1;
                currentNode.max = c2;
                nodeList = new ArrayList<>();
                nodeList.add(currentNode);
                cells.put(row, nodeList);
            } else {
                for(int j=0; j<nodeList.size(); j++) {
                    Node nn = nodeList.get(j);
                    if((j==0 && (c1 < nn.min && c2 < nn.min)) ||
                            (j==nodeList.size()-1 && (c1 > nn.max && c2 > nn.max))) {
                        Node newNode = new Node();
                        newNode.min = c1;
                        newNode.max = c2;
                        nodeList.add(newNode);
                        break;
                    } else {
                        if(c1 < nn.min) nn.min = c1;
                        if(c2 > nn.max) nn.max = c2;
                    }
                }
            }
        }
        long totalCells = n*m;
        for(Long l: cells.keySet()) {
            List<Node> nodeList = cells.get(l);
            for(Node nn: nodeList) {
                totalCells -= (nn.max - nn.min + 1);
            }
        }
        System.out.println(totalCells);
    }

}
