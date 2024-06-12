package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">...</a>
 */
public class KthLargestElementInAStream {

    private PriorityQueue<Integer> heap;
    private int k;

    private int[] heapArray;
    private int heapSize;
    public KthLargestElementInAStream(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        this.heapArray = new int[k];

        for (int num: nums) {
//            heap.offer(num);
            addElementToHeap(num);
        }

//        while (heap.size() > k) heap.poll();
        // Construct min heap in place from provided array
//        for (int i = nums.length / 2 - 1; i >= 0; i--) {
//            heapify(nums, i);
//        }
    }

    public void addElementToHeap(int ele) {

        if (heapSize == 0) {
            heapArray[heapSize++] = ele;
            return;
        }

        if (heapSize == k) {
            if (ele > heapArray[0]) {
                removeElementFromHeap();
            } else return;
        }

        int index = heapSize;
        heapArray[index] = ele;
        int parent = (index - 1) / 2;
        while (parent != index && heapArray[parent] > heapArray[index]) {
            int temp = heapArray[parent];
            heapArray[parent] = heapArray[index];
            heapArray[index] = temp;
            index = parent;
            parent = (index - 1) / 2;
        }
        heapSize++;
    }

    public void removeElementFromHeap() {
        int pop = heapArray[0];
        int last = heapArray[heapSize - 1];
        heapArray[0] = heapArray[heapSize - 1];
        heapArray[heapSize - 1] = pop;

        int index = 0;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        heapSize--;
        while (index <= heapSize / 2 - 1) {
            if (left < heapSize && heapArray[left] < heapArray[smallest]) smallest = left;
            if (right < heapSize && heapArray[right] < heapArray[smallest]) smallest = right;
            if (smallest != index) {
                int temp = heapArray[smallest];
                heapArray[smallest] = heapArray[index];
                heapArray[index] = temp;
            } else break;
            index = smallest;
        }
    }

    public void heapify(int[] arr, int index) {
        int size = arr.length;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;

        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;

        if (index != largest) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest);
        }
    }

    public int add(int val) {
//        heap.offer(val);
//        while (heap.size() > k) heap.poll();
//        return heap.peek();
        addElementToHeap(val);
        return heapArray[0];
    }

    public static void main(String[] args) {
        KthLargestElementInAStream k = new KthLargestElementInAStream(3, new int[]{4,5,8,2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }

}
