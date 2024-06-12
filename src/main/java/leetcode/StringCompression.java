package leetcode;

/*
   https://leetcode.com/problems/string-compression/
 */


import java.util.Arrays;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(
            compress2(new char[]{'a','a','b','b','c','c','c'})
        );
//        ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
        System.out.println(
            compress2(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'})
        );
//        ["a","a","a","b","b","a","a"]
        System.out.println(
            compress2(new char[]{'a','a','a','b','b','a','a'})
        );
    }

    // 0ms
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int compress2(char[] chars) {

        if (chars.length == 0) return 0;

        char pre = chars[0];
        int len = 1, count = 0, pos = 1;

        for (char c: chars) {
            if (c == pre) count++;
            else {
                // check current count for previous character
                if (count >= 10) {
                    len += 2;
                    chars[pos++] = (char) (count / 10 + '0');
                    chars[pos++] = (char) (count % 10 + '0');
                }
                else if (count > 1) {
                    len += 1;
                    chars[pos++] = (char) (count + '0');
                }
                // for new character (always single character)
                chars[pos++] = c;
                count = 1;
                len += 1;
            }
            pre = c;
        }

        if (count >= 10) {
            len += 2;
            chars[pos++] = (char) (count / 10 + '0');
            chars[pos] = (char) (count % 10 + '0');
        }
        else if (count > 1) {
            len += 1;
            chars[pos] = (char) (count + '0');
        }

        System.out.println(Arrays.toString(chars));

        return len;

    }

    // 1ms
    public static int compress(char[] chars) {

        int pre = -1, count = 0, currentPos = -1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == pre) count++;
            else {
                if (i != 0) {
                    if (count > 1) {
                        String vs = String.valueOf(count);
                        for(char c: vs.toCharArray()) {
                            chars[++currentPos] = c;
                        }
                    }
                }

                currentPos++;
                chars[currentPos] = chars[i];
                count = 1;
                pre = chars[i];
            }
        }

        if (count > 1) {
            String vs = String.valueOf(count);
            for(char c: vs.toCharArray()) {
                chars[++currentPos] = c;
            }
        }

        return currentPos+ 1;
    }

}
