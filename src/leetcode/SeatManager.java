package leetcode;

import java.util.BitSet;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/seat-reservation-manager/description/">...</a>
 */
public class SeatManager {

    private PriorityQueue<Integer> minHeap;
    private int marker;

    public SeatManager(int n) {
        minHeap = new PriorityQueue<>();
        marker = 1;
    }

    public int reserve() {
        if (minHeap.isEmpty()) return marker++;
        else {
            return minHeap.poll();
        }
    }

    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }

}


class SeatManager2 {
    BitSet bs;

    public SeatManager2(int n) {
        this.bs = new BitSet(n);
    }

    public int reserve() {
        int z = bs.nextClearBit(0);
        bs.set(z);
        return ++z;
    }

    public void unreserve(int x) {
        bs.clear(--x);
    }
}