package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/design-file-system/">...</a>
 */
public class DesignFileSystem2 {

    class Node {
        // Using HashMap instead to store own string like "foldername/"
        Map<String, Node> nodes;
        int value;
    }

    private Node root;
    public DesignFileSystem2() {
        root = new Node();
        root.nodes = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (path.length() <= 1) return false;
        Node current = root;
        String[] split = path.split("/");
        int pathLevel = split.length;
        int splitIndex = 1;
        while (current != null) {
            String folderName = split[splitIndex];
            if (pathLevel > 2) {
                if (!current.nodes.containsKey(folderName)) {
                    return false;
                }
                current = current.nodes.get(folderName);
                pathLevel--;
                splitIndex++;
            } else {
                if (current.nodes.containsKey(folderName)) {
                    return false;
                }
                Node newNode = new Node();
                newNode.nodes = new HashMap<>();
                newNode.value = value;
                current.nodes.put(folderName, newNode);
                return true;
            }
        }
        return false;
    }

    public int get(String path) {
        Node current = root;
        String[] folders = path.split("/");
        int i = 1;
        while (current != null) {
            if (!current.nodes.containsKey(folders[i])) return -1;
            if (i == folders.length - 1) return current.nodes.get(folders[i]).value;
            current = current.nodes.get(folders[i++]);
        }
        return -1;
    }

    public static void main(String[] args) {
        DesignFileSystem2 system = new DesignFileSystem2();
        System.out.println(system.createPath("/leet", 1));
        System.out.println(system.createPath("/leet/code", 2));
        System.out.println(system.get("/leet/code"));
        System.out.println(system.createPath("/c/d", 1));
        System.out.println(system.get("/c"));
    }
}
