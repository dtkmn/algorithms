package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 0ms
    // Using 2 while loop to make the code clear for understanding and revisit
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    public Node copyRandomList(Node head) {
        // When input head is null, return null
        if (head == null) return null;

        // Space Complexity: O(n)
        Map<Node, Node> nodeMap = new HashMap<>();

        Node currentNode = head;
        // Loop through current linked list and recreate all the nodes with new instance
        // and put them in the map using oldNode / newNode mappings
        // Time Complexity: O(n)
        while (currentNode != null) {
            if (!nodeMap.containsKey(currentNode)) {
                nodeMap.put(currentNode, new Node(currentNode.val));
            }
            currentNode = currentNode.next;
        }

        // Start current node as head
        currentNode = head;
        // Loop through each node again
        // Time Complexity: O(n)
        while (currentNode != null) {
            Node newCurrent = nodeMap.get(currentNode);
            newCurrent.next = nodeMap.get(currentNode.next);
            newCurrent.random = nodeMap.get(currentNode.random);
            currentNode = currentNode.next;
        }

        // We know where is the new head node located
        return nodeMap.get(head);
    }

    public static void main(String[] args) {

    }

}
