package leetcode;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/two-best-non-overlapping-events/
 *
 */

public class TwoBestNonOverlappingEvents {

    class Event {
        int startTime;
        int endTime;
        int value;
        Event(int startTime, int endTime, int value) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.value = value;
        }
    }

    private List<Event> eventList;
    private int[][] dp;

    private int ans;
    /**
     * events[i] = [startTimei, endTimei, valuei]
     * @param events
     * @return
     */
    public int maxTwoEvents(int[][] events) {
        this.eventList = new ArrayList<>();
        this.dp = new int[events.length + 1][3];
        for (int[] event: events) {
            eventList.add(new Event(event[0], event[1], event[2]));
        }
        eventList.sort((e1, e2) -> e1.startTime - e2.startTime);
        return schedule(0, 0, 0);
    }

    public int schedule(int currentEventIndex, int currentValue, int count) {

        if (currentEventIndex == eventList.size()) {
//            int finalVal =  count == 2? currentValue: 0;
//            ans = Math.max(ans, finalVal);
            return 0;
        }

        if (count == 2) {
            System.out.println("Count == 2: " + currentValue);
//            ans = Math.max(ans, currentValue);
            return 0;
        }

        if (dp[currentEventIndex][count] != 0) return dp[currentEventIndex][count];

        int skipValues = schedule(currentEventIndex + 1, currentValue, count);

        Event currentEvent = eventList.get(currentEventIndex);
        int scheduleValue = currentEvent.value + currentValue;
        int next = nextEvent(currentEventIndex + 1, currentEvent.endTime);
        if (next != -1) {
            scheduleValue += schedule(next, scheduleValue, count + 1);
        }
        dp[currentEventIndex][count] = Math.max(skipValues, scheduleValue);
        return dp[currentEventIndex][count];
    }

    private int nextEvent(int from, int start) {
        int lo = from, hi = eventList.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (eventList.get(mid).startTime > start) {
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return lo == eventList.size()? -1: lo;
    }

    public static void main(String[] args) {
        int maxTwoEvents = new TwoBestNonOverlappingEvents().maxTwoEvents(new int[][]{
                {1, 3, 2},
                {4, 5, 2},
                {2, 4, 3}
        });
        System.out.println(maxTwoEvents);

        int maxTwoEvents2 = new TwoBestNonOverlappingEvents().maxTwoEvents(new int[][]{
                {10, 83, 53},
                {63, 87, 45},
                {97, 100, 32},
                {51, 61, 16}
        });
        System.out.println(maxTwoEvents2);
    }

}
