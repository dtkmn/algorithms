package leetcode;

import java.util.Arrays;

public class SortAnArray_Practice {

    public void mergeSort(int[] array, int lo, int hi) {
        if (lo >= hi) return;
        // Locate the mid point to break the current array apart
        int mid = lo + (hi - lo) / 2;
        mergeSort(array, lo, mid);
        mergeSort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    public void merge(int[] array, int lo, int mid, int hi) {
        int[] aux = new int[array.length];
        for (int i = lo; i <= hi; i++) {
            aux[i] = array[i];
        }
        int i = lo, j = mid + 1;
        for (int m = lo; m <= hi; m++) {
            if (i > mid) array[m] = aux[j++];
            else if (j > hi) array[m] = aux[i++];
            else if (aux[i] >= aux[j]) array[m] = aux[j++];
            else array[m] = aux[i++];
        }
    }

    public void quicksort(int[] input, int lo, int hi) {
        if (lo > hi) return;
        int pivotIndex = partition(input, lo, hi);
        quicksort(input, lo, pivotIndex - 1);
        quicksort(input, pivotIndex + 1, hi);
    }

    public int partition(int[] input, int lo, int hi) {
        int pivot = input[hi];
        int k = lo - 1;
        for (int i = lo; i <= hi; i++) {
            if (input[i] <= pivot) {
                k++;
                int temp = input[i];
                input[i] = input[k];
                input[k] = temp;
            }
        }
        return k;
    }

    public static void main(String[] args) {
//        int[] input = new int[]{2,4,1,43,66,88,22,31};
        int[] input = new int[]{5,1,1,2,0,0,-1};
        new SortAnArray_Practice().mergeSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));

        int[] clone = input.clone();
        new SortAnArray_Practice().quicksort(clone, 0, clone.length - 1);
        System.out.println(Arrays.toString(clone));

    }


    public void mergeSort_08122023(int[] nums, int lo, int hi) {
        if (lo > hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort_08122023(nums, lo, mid);
        mergeSort_08122023(nums, mid + 1, hi);

    }

    public void merge_08122023(int[] nums, int lo, int mid, int hi) {
        int[] aux = new int[nums.length];
        for (int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }
        int i = lo, j = mid + 1;
        for (int m = lo; m <= hi; m++) {
            if (i > mid) nums[m] = aux[j++];
            else if (j > hi) nums[m] = aux[i++];
            else if (aux[i] >= aux[j]) nums[m] = aux[j++];
            else nums[m] = aux[i++];
        }
    }

    public void quicksort_08122023(int[] nums, int lo, int hi) {
        if (lo > hi) return;
        int pivotIndex = partition_08122023(nums, lo, hi);
        quicksort_08122023(nums, lo, pivotIndex - 1);
        quicksort_08122023(nums, pivotIndex + 1, hi);
    }

    public int partition_08122023(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int k = lo - 1;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] <= pivot) {
                k++;
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
        return k;
    }

}
