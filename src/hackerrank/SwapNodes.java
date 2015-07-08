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
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static void printInOrderWithSwap(Node root, int depth, final int swapDepth) {
        if(root == null) return;
        printInOrderWithSwap(root.left, depth + 1, swapDepth);
        if(depth == swapDepth) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
//            System.out.println("SWAP at node : " + root.data + ", with current depth " + depth + " : " + swapDepth);
        }
        printInOrderWithSwap(root.right, depth + 1, swapDepth);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        if(N <= 0) return;

        // Setup root node and make it as current
        Node root = new Node();
        root.data = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

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

        // Get height of tree
        int height = height(root);

        // Swap start
        int swaps = in.nextInt();
        for(int i = 0; i<swaps; i++) {
            int depth = in.nextInt();
            for(int j = depth; j < height; j+=depth) {
//                System.out.println("in depth: " + j);
                printInOrderWithSwap(root, 1, j);
            }
            printInOrder(root);
            System.out.println();
        }
    }
}
