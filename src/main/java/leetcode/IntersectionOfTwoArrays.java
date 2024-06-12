package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays/">...</a>
 *
 *
 */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        // zero length
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};

        Set<Integer> set1 = new HashSet<>();
        for (int value : nums1) {
            set1.add(value);
        }
        Set<Integer> intersect = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                intersect.add(i);
            }
        }

        int[] output = new int[intersect.size()];
        int pos = 0;
        for (Integer integer : intersect) {
            output[pos++] = integer;
        }

        return output;
    }

    public static void main(String[] args) {
//        System.out.println(
//            Arrays.toString(
//                intersection(
//                    new int[]{1},
//                    new int[]{1,2}
//                )
//            )
//        );
        System.out.println(
            Arrays.toString(
                intersection(
                    new int[]{1,2},
                    new int[]{1,1}
                )
            )
        );
        System.out.println(
            Arrays.toString(
                intersection(
                    new int[]{4,9,5},
                    new int[]{9,4,9,8,4}
                )
            )
        );
    }

}
