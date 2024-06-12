package leetcode;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-earnings-from-taxi/">...</a>
 *
 */

public class MaximumEarningsFromTaxi {

    class Ride {
        int start;
        int end;
        int tip;
    }

    private List<Ride> list;
    private long[] dp;
    public long maxTaxiEarnings(int n, int[][] rides) {
        list = new ArrayList<>();
        dp = new long[rides.length + 1];
        for (int[] r: rides) {
            Ride ri = new Ride();
            ri.start = r[0];
            ri.end = r[1];
            ri.tip = r[2];
            list.add(ri);
        }
        list.sort(new Comparator<Ride>() {
            @Override
            public int compare(Ride r1, Ride r2) {
                return r1.start - r2.start;
            }
        });

        return schedule(0, 0);
    }

    private long schedule(int currentRideIndex, long earning) {
        if (currentRideIndex == list.size()) {
            return earning;
        }
        if (dp[currentRideIndex] != 0) return dp[currentRideIndex];
        long skipEarning = schedule(currentRideIndex + 1, earning);
        Ride currentRide = list.get(currentRideIndex);
        long scheduleEarning = (currentRide.end - currentRide.start + currentRide.tip) + earning;
        int nextIndex = nextRide(currentRideIndex + 1, currentRide.end);
        if (nextIndex != -1) {
            scheduleEarning += schedule(nextIndex, scheduleEarning);
        }
        dp[currentRideIndex] = Math.max(skipEarning, scheduleEarning);
        return dp[currentRideIndex];
    }

    private int nextRide(int from, int end) {
        int lo = from, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid).start >= end) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo == list.size()? -1: lo;
    }

    public static void main(String[] args) {
        long earnings = new MaximumEarningsFromTaxi().maxTaxiEarnings(
                5,
                new int[][]{
                        {2, 5, 4},
                        {1, 5, 1}
                }
        );
        System.out.println(earnings);
    }

}
