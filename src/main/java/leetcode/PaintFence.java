package leetcode;


/**
 * <a href="https://leetcode.com/problems/paint-fence/">...</a>
 *
 */
public class PaintFence {

    private int globalCount;
    public int numWays(int n, int k) {
        dfs(-1,-1,0, n, k);
        return globalCount;
    }

    public void dfs(int prevprev, int prev, int pos, int n, int k) {
        if (pos == n) {
            globalCount++;
            return;
        }

        for (int i = 0; i < k; i++) {
            if (prev == i && prevprev == i) {
                continue;
            }
            dfs(prev, i,pos + 1, n, k);
        }

    }

    public static void main(String[] args) {
        System.out.println(
            new PaintFence().numWays(3 , 2)
        );
        System.out.println(
            new PaintFence().numWays(7 , 2)
        );
    }

}
