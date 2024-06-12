package leetcode;


/*
    https://leetcode.com/problems/add-strings/
 */
public class AddStrings {

    // 2ms beats 96%
    // Time Complexity: O(Max(M,N))
    // Space Complexity: O(M+N)
    public static String addStrings(String num1, String num2) {
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();

        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = array1.length - 1, j = array2.length - 1; i >= 0 || j >= 0; i--, j--) {
            int localSum = carry;
            if (i >= 0) localSum += array1[i] - '0';
            if (j >= 0) localSum += array2[j] - '0';
            if (localSum >= 10) carry = 1; else carry = 0;
            int digit = localSum % 10;
            res.append(digit);
        }

        if (carry == 1) res.append(1);

        return res.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(addStrings("0", "0"));
        System.out.println(addStrings("9", "99"));
    }


}
