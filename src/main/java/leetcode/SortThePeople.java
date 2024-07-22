package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sort-the-people/">2418. Sort the People</a>
 */
public class SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> heightMap = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            heightMap.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        int j = 0, k = names.length - 1;
        while (k >= 0) {
            names[j++] = heightMap.get(heights[k--]);
        }
        return names;
    }

    public String[] sortPeople_mergesort(String[] names, int[] heights) {
        mergeSort(names, heights, 0, names.length - 1, new String[names.length], new int[heights.length]);
        return names;
    }

    private void mergeSort(String[] arr, int[] heights, int start, int end, String[] aux, int[] auxH) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, heights, start, mid, aux, auxH);
            mergeSort(arr, heights,mid + 1, end, aux, auxH);
            merge(arr, heights, start, mid, end, aux, auxH);
        }
    }

    private void merge(String[] names, int[] heights, int start, int mid, int end, String[] aux, int[] auxH) {
        for (int i = start; i <= end; i++) {
            aux[i] = names[i];
            auxH[i] = heights[i];
        }
        int m = start, n = mid + 1;
        for (int k = start; k <= end; k++) {
            if (m > mid) {
                names[k] = aux[n];
                heights[k] = auxH[n];
                n++;
            } else if (n > end) {
                names[k] = aux[m];
                heights[k] = auxH[m];
                m++;
            } else if (auxH[m] > auxH[n]) {
                names[k] = aux[m];
                heights[k] = auxH[m];
                m++;
            } else {
                names[k] = aux[n];
                heights[k] = auxH[n];
                n++;
            }
        }
    }

}
