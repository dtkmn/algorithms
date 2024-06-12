package leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
    https://leetcode.com/problems/design-hashmap/
 */
public class DesignHitCounter {

    private int[] counter;
    private Queue<Integer> queue;
    public DesignHitCounter() {
        counter = new int[Integer.MAX_VALUE];
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        counter[timestamp]++;
        queue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        if (queue.isEmpty()) return 0;

        int frontTime = timestamp > 300? timestamp - 300 + 1: 1;
        while (queue.peek() < frontTime) queue.poll();
        return queue.size();
    }

    public static void main(String[] args) {

    }



}
