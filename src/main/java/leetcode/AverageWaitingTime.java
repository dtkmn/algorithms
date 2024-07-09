package leetcode;

/**
 * <a href="https://leetcode.com/problems/average-waiting-time/">1701. Average Waiting Time</a>
 */
public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int curr = 0;
        double waiting = 0.0;
        for (int[] c: customers) {
            if (curr <= c[0]) {
                curr = c[0];
            }
            curr += c[1];
            waiting += curr - c[0];
        }
        return waiting / customers.length;
    }
}
