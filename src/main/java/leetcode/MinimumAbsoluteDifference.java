package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference/">...</a>
 */
public class MinimumAbsoluteDifference {

    public static List<List<Integer>> countingSort(int[] arr) {
        int min = arr[0], max = arr[0];
        // First loop to find the min and max so we know the range
        for (int item: arr) {
            if (item < min) min = item;
            else if (item > max) max = item;
        }
        // Now we know the range...
        int[] countMap = new int[max - min + 1];
        int shift = -min;
        for (int j: arr) {
            countMap[j + shift]++;
        }

        List<List<Integer>> answers = new ArrayList<>();
        int minDiff = Math.abs(max - min);
        int prev = min;
        for (int i = min + 1; i <= max; i++) {
            if (countMap[i + shift] > 0) {
                if (Math.abs(i - prev) == minDiff) {
                    answers.add(Arrays.asList(prev, i));
                } else if (Math.abs(i - prev) < minDiff) {
                    answers.clear();
                    answers.add(Arrays.asList(prev, i));
                    minDiff = Math.abs(i - prev);
                }
                prev = i;
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,2,1,3};
        System.out.println(minimumAbsDifference(input));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        return countingSort(arr);
    }

}
