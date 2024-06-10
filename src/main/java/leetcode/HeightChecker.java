package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/height-checker/">1051. Height Checker</a>
 */
public class HeightChecker {

    private void quicksort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivotIndex = partition(arr, lo, hi);
            quicksort(arr, lo, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int k = lo - 1;
        for (int i = lo; i <= hi; i++) {
            if (arr[i] <= pivot) {
                k++;
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return k;
    }

    public int heightChecker(int[] heights) {
        int[] copied = Arrays.copyOf(heights, heights.length);
//        quicksort(heights, 0, heights.length - 1);
        mergeSort(0, heights.length - 1, heights, new int[heights.length]);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copied[i]) {
                count++;
            }
        }
        return count;
    }

    private void mergeSort(int l, int r, int[] arr, int[] aux) {
        if (l < r) {
        int mid = l + (r - l) / 2;
        mergeSort(l, mid, arr, aux);
        mergeSort(mid + 1, r, arr, aux);
        merge(l, mid, r, arr, aux);
        }
    }

    private void merge(int lo, int mid, int hi, int[] arr, int[] aux) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

}
