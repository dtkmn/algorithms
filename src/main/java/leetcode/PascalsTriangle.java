package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        int pre = -1;
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                output.add(l);
            } else {
                List<Integer> l = new ArrayList<>();
                List<Integer> preList = output.get(pre);
                // first item always 1
                l.add(1);
                for (int j = 1; j <= pre; j++) {
                    l.add(preList.get(j) + preList.get(j-1));
                }
                // last item always 1
                l.add(1);
                output.add(l);
            }
            pre++;
        }
        return output;
    }

    public List<List<Integer>> generate_2023(int numRows) {
        if (numRows == 0) return List.of();

        List<Integer> first = List.of(1);
        List<Integer> second = List.of(1,1);
        if (numRows == 1) return List.of(first);
        if (numRows == 2) return List.of(first, second);


        List<List<Integer>> ans = new ArrayList<>(List.of(first, second));
        List<Integer> prev = second;
        // Zero-index on row here
        for (int i = 2; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int n = 1; n < i; n++) {
                currentRow.add(prev.get(n - 1) + prev.get(n));
            }
            currentRow.add(1);
            ans.add(currentRow);
            prev = currentRow;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
            generate(5)
        );
    }

}
