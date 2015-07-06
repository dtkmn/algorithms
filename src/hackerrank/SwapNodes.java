package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by datse on 6/07/2015.
 */
public class SwapNodes {

    static class Node {
        int data;
        Node left, right;
    }

    static void printInOrder(Node root) {
        if(root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    static int height(Node root) {
        if(root == null) return 0;
        height(root.left);
        height(root.right);
        return 1 + height(root.left);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        // Setup root node and make it as current
        Node root = new Node();
        root.data = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node[] arrayNodes = new Node[N];
        arrayNodes[0] = root;

        int count = 1;

        for(int i = 0; i<N; i++) {
            // Read a and b value in same row
            int left = in.nextInt();
            int right = in.nextInt();
            Node leftNode = null, rightNode = null;
            if(left != -1) {
                leftNode = new Node();
                leftNode.data = left;
                queue.add(leftNode);
            }
            if(right != -1) {
                rightNode = new Node();
                rightNode.data = right;
                queue.add(rightNode);
            }
            Node n = queue.remove();
            if(n != null) {
                n.left = leftNode;
                n.right = rightNode;
            }

        }



        // Get the height of tree? (optional?)


        // Swap start
        int swaps = in.nextInt();
        for(int i = 0; i<swaps; i++) {
            int depth = in.nextInt();

            Node current = root;
            Node right = root;
            for(int j = 0; j<depth; j++) {
                current = current.left;
            }
            // should be in correct depth and start to swap
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

        }
        // Swap end

        // Print inOrder tree
        printInOrder(root);
        System.out.println();
        System.out.println("Tree height: " + height(root));
    }
}
