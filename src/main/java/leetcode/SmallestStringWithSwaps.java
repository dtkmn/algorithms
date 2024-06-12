package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/smallest-string-with-swaps/">...</a>
 *
 */
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind unionFind = new UnionFind(n);
        for (List<Integer> pair: pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            unionFind.union(x, y);
        }
        return unionFind.buffer(s);
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        String buffer(String s) {
            System.out.println(s);
            Map<Integer, List<Integer>> rootToNodes = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                int root = find(i);
                rootToNodes.putIfAbsent(root, new ArrayList<>());
                rootToNodes.get(root).add(i);
            }

            // We use Key to Nodes map to get the characters on each group
            Map<Integer, char[]> sMap = new HashMap<>();
            for (int key: rootToNodes.keySet()) {
                List<Integer> indexes = rootToNodes.get(key);
                char[] cs = new char[indexes.size()];
                int i = 0;
                for (int index: indexes) {
                    cs[i++] = s.charAt(index);
                }
                Arrays.sort(cs);
                sMap.put(key, cs);
            }

            char[] resChars = new char[s.length()];
            for (int key: rootToNodes.keySet()) {
                List<Integer> positions = rootToNodes.get(key);
                char[] cs = sMap.get(key);
                int i = 0;
                for (int pos: positions) {
                    resChars[pos] = cs[i++];
                }
            }
            return new String(resChars);
        }

        int find(int x) {
            while (x != parent[x]) x = parent[x];
            return x;
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }
    }



    public static void main(String[] args) {
//        String res = new SmallestStringWithSwaps().smallestStringWithSwaps(
//            "dcab",
//                List.of(
//                    List.of(0, 3),
//                    List.of(1, 2)
//                )
//        ); // bacd
//        System.out.println(res);

//        String res2 = new SmallestStringWithSwaps().smallestStringWithSwaps(
//                "dcab",
//                List.of(
//                    List.of(0, 3),
//                    List.of(1, 2),
//                    List.of(0, 2)
//                )
//        ); // bacd
//        System.out.println(res2);

        String res = new SmallestStringWithSwaps().smallestStringWithSwaps(
                "yhiihxbordwyjybyt",
                List.of(
                        List.of(9, 1),
                        List.of(5, 11),
                        List.of(9, 7),
                        List.of(2, 7),
                        List.of(14, 16),
                        List.of(6, 16),
                        List.of(0, 5),
                        List.of(12, 9),
                        List.of(6, 5),
                        List.of(9, 10),
                        List.of(4, 7),
                        List.of(3, 2),
                        List.of(10, 1),
                        List.of(3, 15),
                        List.of(12, 4),
                        List.of(10, 10),
                        List.of(15, 12)
                )
        ); // bdhhibtirjoxwyyyy
        System.out.println(res);
    }

}
