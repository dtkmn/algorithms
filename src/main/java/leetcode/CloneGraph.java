package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/clone-graph/description/">...</a>
 *
 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }

    Node dfs(Node curr, Map<Integer, Node> visited) {
        if (visited.containsKey(curr.val))
            return visited.get(curr.val);

        Node clone = new Node(curr.val, new ArrayList<>());
        visited.put(clone.val, clone);
        List<Node> cNeighbours = clone.neighbors;
        for (Node n: curr.neighbors) {
            cNeighbours.add(dfs(n, visited));
        }
        return clone;
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors = List.of(two, four);
        two.neighbors = List.of(one, three);
        three.neighbors = List.of(two, four);
        four.neighbors = List.of(one, three);
        cloneGraph.cloneGraph(one);
    }
}
