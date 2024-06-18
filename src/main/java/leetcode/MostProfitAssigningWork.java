package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/most-profit-assigning-work/">826. Most Profit Assigning Work</a>
 */
public class MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < profit.length; i++) {
            projects.add(new int[] { difficulty[i], profit[i] });
        }

        projects.sort((o1, o2) -> o1[0] - o2[0]);

        int max = 0;
        for (int[] key: projects) {
            max = Math.max(max, key[1]);
            key[1] = max;
            System.out.println(Arrays.toString(key));
        }

        Arrays.sort(worker);
        System.out.println(Arrays.toString(worker));

        int p = 0;
        int pos = projects.size() - 1;
        for (int i = worker.length - 1; i >= 0; i--) {
            while (pos >= 0) {
                if (worker[i] >= projects.get(pos)[0]) {
                    p += projects.get(pos)[1];
                    break;
                } else {
                    pos--;
                }
            }
        }
        return p;
    }

}
