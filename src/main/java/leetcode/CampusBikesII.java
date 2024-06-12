package leetcode;

/**
 *  <a href="https://leetcode.com/problems/campus-bikes-ii/">...</a>
 */
public class CampusBikesII {

    private int ans;
    public int assignBikes(int[][] workers, int[][] bikes) {
        this.ans = Integer.MAX_VALUE;
        backtrack(0, workers, bikes, 0, new boolean[bikes.length]);
        return ans;
    }

    public void backtrack(int workerPos, int[][] workers, int[][] bikes, int currentDistance, boolean[] visitedBikes) {
        if (workerPos == workers.length) {
            ans = Math.min(ans, currentDistance);
            return;
        }
        for (int i = 0; i < bikes.length; i++) {
            // When bikes[i] not visited yet
            if (!visitedBikes[i]) {
                int dx = workers[workerPos][0];
                int dy = workers[workerPos][1];
                int bx = bikes[i][0];
                int by = bikes[i][1];
                int d = Math.abs(dx-bx) + Math.abs(dy-by);
                if (d + currentDistance >= ans) continue;
                visitedBikes[i] = true;
                backtrack(workerPos + 1, workers, bikes, currentDistance + d, visitedBikes);
                visitedBikes[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(
            new CampusBikesII().assignBikes(
                    new int[][] {
                            {0,0},
                            {2,1}
                    },
                    new int[][] {
                            {1,2},
                            {3,3}
                    }
            )
        );
    }

}
