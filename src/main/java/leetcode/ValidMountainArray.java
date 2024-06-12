package leetcode;


/**
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class ValidMountainArray {

    // Time Compexity: O(N)
    // Space Complexity: O(1)
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        // already increasing or decreasing ?
        boolean in = false, de = false;
        int pre = A[0];
        for (int i = 1; i < A.length; i++) {
            if (pre == A[i]) return false;
            // when increasing...
            else if (pre < A[i]) {
                if (de) return false;
                // set increasing as true
                in = true;
            } else {
                // when decreasing
                // already increase ?
                if (!in)  return false;
                de = true;
            }
            pre = A[i];
        }
        // happened both ?
        return in && de;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[] { 0,3,2,1 }));
        System.out.println(validMountainArray(new int[] { 3,5,5 }));
    }

}
