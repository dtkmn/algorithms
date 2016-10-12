package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HeapsFindTheRunningMedian {

    public static void rebalance(PriorityQueue<Integer> maxHeaps, PriorityQueue<Integer> minHeaps) {
        if(maxHeaps.size() - minHeaps.size() >= 2) {
            minHeaps.add(maxHeaps.poll());
        } else if(minHeaps.size() - maxHeaps.size() >= 2) {
            maxHeaps.add(minHeaps.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> maxHeaps, PriorityQueue<Integer> minHeaps) {
        if((maxHeaps.size() + minHeaps.size())%2 == 0) {
            return (maxHeaps.peek() + minHeaps.peek())/2.0;
        } else {
            return (double)maxHeaps.size()>minHeaps.size()?maxHeaps.peek():minHeaps.peek();
        }
    }

    public static void addToHeaps(int value, PriorityQueue<Integer> maxHeaps, PriorityQueue<Integer> minHeaps) {
        if(maxHeaps.isEmpty() || value < maxHeaps.peek()) {
            maxHeaps.add(value);
        } else {
            minHeaps.add(value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeaps = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeaps = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i=0; i<n; i++) {
            int v = Integer.parseInt(br.readLine());
            addToHeaps(v, maxHeaps, minHeaps);
            rebalance(maxHeaps, minHeaps);
            System.out.println(getMedian(maxHeaps, minHeaps));
        }

    }

}
