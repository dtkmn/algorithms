package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/diagonal-traverse/
 */
public class DiagonalTraverse {

    public static int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> mappings = new HashMap<>();
        int rowLength = mat.length;
        int colLength = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int key = i + j;
                List<Integer> l = mappings.getOrDefault(key, new ArrayList<>());
                l.add(mat[i][j]);
                mappings.put(key, l);
            }
        }
        int[] ans = new int[rowLength * colLength];
        int k = 0;
        int i = 0;
        while (mappings.containsKey(i)) {
            List<Integer> m = mappings.get(i);
            if (i % 2 == 0) {
//                for (int j = m.size() - 1; j >= 0; j--) {
//                    ans[k++] = m.get(j);
//                }
                while (!m.isEmpty()) {
                    ans[k++] = m.removeLast();
                }
            } else {
                for (int item: m) {
                    ans[k++] = item;
                }
            }
            i++;
        }
        return ans;
    }


    public static int[] findDiagonalOrder_BFS(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        int[] ans = new int[mat.length * mat[0].length];
        int level = 0, k = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int[] currentLevel = new int[levelSize];
            for (int i = 0; i < levelSize; i++) {
                int[] p = queue.poll();
                int row = p[0];
                int col = p[1];
                currentLevel[i] = mat[row][col];
                if (col == 0 && row + 1 < mat.length) {
                    queue.offer(new int[] {row + 1, col});
                }
                if (col + 1 < mat[row].length) {
                    queue.offer(new int[] {row, col + 1});
                }
            }
            if (level % 2 == 0) {
                for (int a: currentLevel) {
                    ans[k++] = a;
                }
            } else {
                for (int b = levelSize - 1; b >= 0; b--) {
                    ans[k++] = currentLevel[b];
                }
            }
            level++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] diagonalOrder = findDiagonalOrder_BFS(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println(
                Arrays.toString(diagonalOrder)
        );
//        int[] diagonalOrder = findDiagonalOrder(new int[][]{
//                {1, 2},
//                {3, 4}
//        });
//        System.out.println(
//                Arrays.toString(diagonalOrder)
//        );
    }

}
