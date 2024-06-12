package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">...</a>
 */
public class TopKFrequentElements {

    static class CountValue {

        int key;
        int count;

        public CountValue(int key, int count) {
            this.key = key;
            this.count = count;
        }

    }

    // 10ms
    public static List<Integer> topKFrequentOld(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<CountValue> countList = new ArrayList<>();
        for (int key: countMap.keySet()) {
            countList.add(new CountValue(key, countMap.get(key)));
        }

        Collections.sort(countList, new Comparator<CountValue>() {
            @Override
            public int compare(CountValue o1, CountValue o2) {
                return o2.count - o1.count;
            }
        });

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(countList.get(i).key);
        }

        return result;

    }

    // 9ms
    public static List<Integer> topKFrequentWithPriorityQueue(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o2.getValue().compareTo(o1.getValue()) == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        queue.addAll(countMap.entrySet());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }

        return result;

    }

    public static int[] topKFrequent(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) min = nums[i];
            if (max < nums[i]) max = nums[i];
        }
        int[] countMap = new int[max - min + 1];
        int shift = -min;
        for (int item: nums) {
            countMap[item + shift]++;
        }
        // Create new heap array with value from min to max
        int[] heap = new int[max - min + 1];
        int value = min;
        for (int v = 0; v < heap.length; v++) {
            heap[v] = value++;
        }

        // Construct as Max heap by comparing count map value
        for (int j = heap.length / 2 - 1; j >= 0; j--) {
            heapify(heap, j, countMap, shift);
        }
//        System.out.println(Arrays.toString(countMap));
        System.out.println(Arrays.toString(heap));
//        return Arrays.copyOfRange(heap, 0, k);
        int[] result = new int[k];
        int heapSize = heap.length;
        for (int t = 0; t < k; t++) {
            result[t] = removeFromHeap(heap, heapSize--, countMap, shift);
//            System.out.println(Arrays.toString(heap));
            System.out.println(result[t]);
        }
        return result;
    }

    public static void heapify(int[] arr, int index, int[] countMap, int shift) {
        int size = arr.length;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;

        if (left < size && countMap[arr[left] + shift] > countMap[arr[largest] + shift]) largest = left;
        if (right < size && countMap[arr[right] + shift] > countMap[arr[largest] + shift]) largest = right;

        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, countMap, shift);
        }
    }

    public static int removeFromHeap(int[] heap, int size, int[] countMap, int shift) {
        int pop = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = pop;
        size--;

        int index = 0;
        while (index <= size / 2 - 1) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int largest = index;
            if (left < size && countMap[heap[left] + shift] > countMap[heap[largest] + shift]) largest = left;
            if (right < size && countMap[heap[right] + shift] > countMap[heap[largest] + shift]) largest = right;

            if (largest != index) {
                int temp = heap[index];
                heap[index] = heap[largest];
                heap[largest] = temp;
                index = largest;
            } else break;
        }
        return pop;
    }


    public static void main(String[] args) {
//        System.out.println(topKFrequentWithPriorityQueue(new int[]{1,1,1,2,2,3}, 2));
//        System.out.println(topKFrequentWithPriorityQueue(new int[]{1}, 1));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println();
//        System.out.println(Arrays.toString(topKFrequent(new int[]{5,3,1,1,1,3,73,1}, 2)));
    }


    // New approach not using any built-in function


}
