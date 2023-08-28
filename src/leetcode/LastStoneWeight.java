package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight/">...</a>
 */
public class LastStoneWeight {

    private PriorityQueue<Integer> heap;

    public LastStoneWeight() {
        this.heap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public int lastStoneWeight(int[] stones) {
        for (int stone: stones) heap.offer(stone);
        if (heap.size() == 1) return heap.peek();
        while (heap.size() > 1) {
            int pop = heap.poll(), peek = heap.poll();
            if (pop != peek) {
                heap.offer(pop - peek);
            }
        }
        return heap.isEmpty() ? 0: heap.peek();
    }

    public static void main(String[] args) {
        LastStoneWeight stone = new LastStoneWeight();
        System.out.println(stone.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

}
