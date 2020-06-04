package leetcode;


import java.util.Arrays;
import java.util.Comparator;

/**
 *  https://leetcode.com/problems/two-city-scheduling/
 */
public class TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {

        // Time Complexity: O(NlogN)
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o2[0] - o2[1]) - Math.abs(o1[0] - o1[1]);
            }
        });

        System.out.println(Arrays.deepToString(costs));
        // Time Complexity: O(N)
        int sum = 0, countA = 0, countB = 0, half = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i][0] <= costs[i][1]) {
                if (countA < half) {
                    sum += costs[i][0];
                    countA++;
                } else {
                    sum += costs[i][1];
                    countB++;
                }
            } else {
                if (countB < half) {
                    sum += costs[i][1];
                    countB++;
                } else {
                    sum += costs[i][0];
                    countA++;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // Input: [[10,20],[30,200],[400,50],[30,20]]
        // Output: 110
        System.out.println(twoCitySchedCost(new int[][] { {10,20},{30,200},{400,50},{30,20} }));

//        [259,770],[448,54],[926,667],[184,139],[840,118],[577,469]
        // 1859
        System.out.println(twoCitySchedCost(new int[][] { {259,770},{448,54},{926,667},{184,139},{840,118},{577,469} }));

    }

}
