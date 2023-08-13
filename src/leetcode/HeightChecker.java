package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/height-checker/">...</a>
 */
public class HeightChecker {

    public static void quicksort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivotIndex = partition(arr, lo, hi);
            quicksort(arr, lo, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
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

    public static int heightChecker(int[] heights) {
        int[] copied = Arrays.copyOf(heights, heights.length);

        quicksort(heights, 0, heights.length - 1);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copied[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,2,1,1,2,2,1};
        System.out.println(heightChecker(input));
    }

}
