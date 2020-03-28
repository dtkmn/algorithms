package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 */
public class FindMedianFromDataStream {

    static class MedianFinder {

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            //default
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) maxHeap.add(num);
            else minHeap.add(num);
            // Make both priority queues balanced
            refresh();
        }

        private void refresh() {
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else return maxHeap.peek();
        }

    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

}
