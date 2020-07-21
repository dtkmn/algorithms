package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/array-transformation/
 */
public class ArrayTransformation {

    public static List<Integer> transformArray(int[] arr) {
        boolean update = true;
        int[] copy = new int[arr.length];
        int len = arr.length;

        copy[0] = arr[0];
        copy[len - 1] = arr[len - 1];

        while (update) {
            update = false;
            for (int i = 1; i < arr.length - 1; i++) {
                int curr = arr[i];
                if (curr > arr[i - 1] && curr > arr[i + 1]) {
                    copy[i] = arr[i] - 1; update = true;
                }
                else if (curr < arr[i - 1] && curr < arr[i + 1]) {
                    copy[i] = arr[i] + 1; update = true;
                } else copy[i] = arr[i];
            }
            arr = Arrays.copyOf(copy, copy.length);
        }

        List<Integer> res = new ArrayList<>();
        for (int n: arr) res.add(n);

        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 2,1,2,1,1,2,2,1 };
        System.out.println(transformArray(input));
    }

}
