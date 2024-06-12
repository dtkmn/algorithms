package leetcode;

/**
 *  <a href="https://leetcode.com/problems/design-file-system/">...</a>
 */
public class DesignFileSystem {

    class Node {
        Node[] nodes = new Node[27];
        int value;
    }

    private Node root;
    public DesignFileSystem() {
        root = new Node();
        root.nodes[26] = new Node(); // for '/'
    }

    public boolean createPath(String path, int value) {
        if (path.length() <= 1) return false;
        Node current = root;
//        for (int i = 0; i < path.length(); i++) {
//            char c = path.charAt(i);
//            if (i == 0 && c != '/') return false;
//            if (c == '/') {
//                // When it is not the root, need to check
//                if (current.nodes[26] == null) {
//                    // Parent path doesn't exist
//                    return false;
//                }
//                current = current.nodes[26];
//
//            } else {
//                if (current.nodes[c-'a'] == null) current.nodes[c-'a'] = new Node();
//                current = current.nodes[c-'a'];
//            }
//        }

        if (current.value != -1) return false; // Path already created before
        current.value = value;
        current.nodes[26] = new Node(); // Set the new node for '/' at the end so this folder is valid after
        return true;
    }

    public int get(String path) {
        Node current = root;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            int index = c == '/'? 26: c-'a';
            if (current.nodes[index] == null) return -1;
            current = current.nodes[index];
        }
        return current.value;
    }

    public static void main(String[] args) {

    }
}
