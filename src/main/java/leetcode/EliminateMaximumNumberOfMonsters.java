package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class EliminateMaximumNumberOfMonsters {

    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> times = new PriorityQueue<>(dist.length);
        for (int i = 0; i < dist.length; i++) {
            times.offer(1.0 * dist[i] / speed[i]);
        }
        int count = 0;
        while(!times.isEmpty()) {
            if (count >= times.poll()) break;
            count++;
        }
        return count;
    }

    public int eliminateMaximum_faster(int[] dist, int[] speed) {
        double[] times = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            times[i] = 1.0 * dist[i] / speed[i];
        }
        Arrays.sort(times);
        int count = 0;
        for (double time: times) {
            if (count >= time) break;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] dist = new int[] { 4,8,6,8,2,7,4 };
        int[] speed = new int[] { 1,3,3,1,10,1,1 };
        System.out.println(
            new EliminateMaximumNumberOfMonsters().eliminateMaximum_faster(dist, speed)
        );
    }

}