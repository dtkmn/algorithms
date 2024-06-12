package leetcode;


/*
    https://leetcode.com/problems/add-digits/
 */
public class AddDigits {

    // Time Complexity: O(log num)
    // Space Complexity: O(1)
    public int addDigits(int num) {
        while (num > 9) {
            int next = 0;
            while (num > 0) {
                int mod = num % 10;
                next += mod;
                num  = num / 10;
            }
            num = next;
        }
        return num;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // Digital Root
    // https://brilliant.org/wiki/digital-root/
    public int addDigits_formula(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
        // return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {

    }


}
