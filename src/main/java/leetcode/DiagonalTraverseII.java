package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/diagonal-traverse-ii/">...</a>
 */
public class DiagonalTraverseII {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int diagonal = row + col;
                if (!groups.containsKey(diagonal)) {
                    groups.put(diagonal, new ArrayList<Integer>());
                }

                groups.get(diagonal).add(nums.get(row).get(col));
                n++;
            }
        }

        int[] ans = new int[n];
        int i = 0;
        int curr = 0;

        while (groups.containsKey(curr)) {
            for (int num : groups.get(curr)) {
                ans[i] = num;
                i++;
            }

            curr++;
        }

        return ans;
    }

    public static int[] findDiagonalOrder_mine(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> mappings  = new HashMap<>();
        int count = 0;
        for (int row = 0; row < nums.size(); row++) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int key = col + row;
                List<Integer> list = mappings.getOrDefault(key, new ArrayList<>());
                list.add(nums.get(row).get(col));
                mappings.put(key, list);
                count++;
            }
        }

        int[] result = new int[count];
        int k = 0, j = 0;
        while (mappings.containsKey(k)) {
            List<Integer> items = mappings.get(k);
            for (int m = items.size() - 1; m >= 0; m--) {
                result[j++] = items.get(m);
            }
            k++;
        }
        return result;
    }

    public static int[] findDiagonalOrder_BFS(List<List<Integer>> nums) {
        List<Integer> ans = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int row = p[0];
            int col = p[1];
            ans.add(nums.get(row).get(col));
            // Actually only the first column need to check next row and add!
            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new int[] {row + 1, col});
            }
            if (col + 1 < nums.get(row).size()) {
                queue.offer(new int[] {row, col + 1});
            }
        }

        int[] result = new int[ans.size()];
        int k = 0;
        for (int item: ans) {
            result[k++] = item;
        }
        return result;
    }

        public static void main(String[] args) {
//        int[] diagonalOrder = findDiagonalOrder(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        });
//        System.out.println(
//                Arrays.toString(diagonalOrder)
//        );
//        int[] diagonalOrder = findDiagonalOrder_mine(new int[][]{
//                {1, 2},
//                {3, 4}
//        });
//        System.out.println(
//                Arrays.toString(diagonalOrder)
//        );
    }

}
