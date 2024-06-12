package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sort-an-array/">...</a>
 */
public class SortAnArray {
    public static int[] heapArray;
    public static int heapSize;

    // Using separated array to create new heap
    public static void createheap(int[] arr) {
        heapArray = new int[arr.length + 1];
        for (int j : arr) {
            addElementToHeap(j);
        }
    }

    public static void heapify(int[] arr) {
        // Bottom-up heapify unordered array
        int heapSize = arr.length;
        // Loop through the array from the tail
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public static void heapify(int[] arr, int index) {
        int size = arr.length;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest);
        }
    }

    public static void addElementToHeap(int ele) {
        // Add mew element to the end of current array/heap
        heapArray[++heapSize] = ele;
        // Start comparing with its parent and swap if need continuously
        int index = heapSize;
        int parent = index / 2;
        while (index > 1 && heapArray[parent] < heapArray[index]) {
            int temp = heapArray[parent];
            heapArray[parent] = heapArray[index];
            heapArray[index] = temp;

            index = parent;
            parent = index / 2;
        }
    }

    public static void removeElementFromMaxHeap(int[] arr, int size) {
        // Swap the first and last item
        int temp = arr[size - 1];
        arr[size - 1] = arr[0];
        arr[0] = temp;

        size--;
        int index = 0;

        while (index <= size / 2 - 1) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int largest = index;
            if (left < size && arr[left] > arr[largest]) largest = left;
            if (right < size && arr[right] > arr[largest]) largest = right;
            if (largest != index) {
                int t = arr[largest];
                arr[largest] = arr[index];
                arr[index] = t;
                index = largest;
            } else break;
        }
    }

    public static int removeElementFromHeap(){

        if (heapSize < 1) return -1;

        int pop = heapArray[1];
        // Swap the first and the last item.
        // Last item is remained instead of removal for sorting in ascending order
        int temp = heapArray[heapSize];
        heapArray[heapSize] = heapArray[1];
        heapArray[1] = temp;

        // Start comparing with its child nodes and swap if smaller
        int index = 1;
        heapSize--;

        while (index <= heapSize / 2) {
            int left = index * 2;
            int right = index * 2 + 1;
            int largest = index;

            if (left <= heapSize && heapArray[left] > heapArray[largest]) {
                largest = left;
            }
            if (right <= heapSize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }

            if (largest != index) {
                int t = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = t;
                index = largest;
            } else break;
        }
        return pop;
    }




    public static void countingSort(int[] arr) {
        int min = arr[0], max = arr[0];
        int[] countMap = new int[200000];
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i] + 50000;
            countMap[pos]++;
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        int index = 0;
        for (int j = min; j <= max; j++) {
            int pos = j + 50000;
            if (countMap[pos] > 0) {
                int count = countMap[pos];
                while (count-- > 0) {
                    arr[index++] = j;
                }
            }
        }
    }



    public static void mergesort(int[] arr, int[] aux, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergesort(arr, aux, lo, mid);
            mergesort(arr, aux,mid + 1, hi);
            merge(arr, aux, lo, mid, hi);
        }
    }

    public static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {

        for (int a = lo; a <= hi; a++) {
            aux[a] = arr[a];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           arr[k] = aux[j++];
            else if (j > hi)            arr[k] = aux[i++];
            else if (aux[i] <= aux[j])  arr[k] = aux[i++];
            else                        arr[k] = aux[j++];
        }

    }



    public static int partition(int[] arr, int low, int high) {
        int k = low - 1;
        // Using last element as pivot
        int pivot = arr[high];
        for (int i = low; i <= high; i++) {
            if (arr[i] <= pivot) {
                k++;
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        // Location index on pivot
        return k;
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i]; // swap
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int prevIndex = i - 1; // previous index
            int currIndex = i;
            while (prevIndex >= 0 && arr[currIndex] < arr[prevIndex]) {
                int temp = arr[currIndex];
                arr[currIndex] = arr[prevIndex];
                arr[prevIndex] = temp;
                currIndex--; prevIndex--;
            }
        }
    }


    public static void main(String[] args) {
//        int[] input = new int[]{2,4,1,43,66,88,22,31};
        int[] input = new int[]{5,1,1,2,0,0,-1};
//        int[] input = new int[]{3,2,3,1,2,4,5,5,6};
//        createheap(input);
//        System.out.println(Arrays.toString(heapArray));
//        System.out.println(heapSize);
//        heapify(input);
//        System.out.println(Arrays.toString(input));
//
//        int size = input.length;
//        while (size > 1) {
//            removeElementFromMaxHeap(input, size--);
//        }

        countingSort(input);

        System.out.println(Arrays.toString(input));

//        while (heapSize > 1) {
//            removeElementFromHeap();
//        }
//        System.out.println(Arrays.toString(heapArray));
//
//        System.out.println(Arrays.toString(Arrays.copyOfRange(heapArray, 1, heapArray.length)));

//        int[] copied = Arrays.copyOf(input, input.length);
//        selectionSort(input);
////        quicksort(input, 0, input.length - 1);
//        System.out.println(Arrays.toString(input));
//
        int[] input2 = new int[]{2,1,2,1,1,2,2,1};
        quicksort(input2, 0, input2.length - 1);
        System.out.println(Arrays.toString(input2));
//
//        insertionSort(copied);
//        System.out.println(Arrays.toString(copied));
//
//        int[] inputForMergeSort = new int[]{2,4,1,43,66,9,88,22,31};
//        mergesort(inputForMergeSort, new int[inputForMergeSort.length], 0, inputForMergeSort.length - 1);
//        System.out.println(Arrays.toString(inputForMergeSort));
    }

}
