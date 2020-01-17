package leetcode;


import java.util.ArrayList;
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

    public static void main(String[] args) {
        System.out.println(
            generate(5)
        );
    }

}
