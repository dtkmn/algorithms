package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reorganize-string/">...</a>
 *
 */

public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString sys = new ReorganizeString();
        // Expected: aba
//        System.out.println(sys.reorganizeString("aab"));
//        System.out.println(sys.reorganizeString("aaab"));
        // Expected: hjhmhmhoyoypypyrcrcscsdtdtdwkwkgklvnvqvuexezj
        System.out.println(sys.reorganizeString("zrhmhyevkojpsegvwolkpystdnkyhcjrdvqtyhucxdcwm"));
    }

    public String reorganizeString(String s) {
        // Create count array to calculate the count on each character
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            // When the max count on specific character is larger than half of s length
            if (++count[c - 'a'] > s.length() / 2 + 1) return "";
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                pq.offer(new int[] { i + 'a', count[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            // When sb is zero length or the pop character not the same as previous -> last character on sb
            if (sb.isEmpty() || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.offer(first);
                }
            } else {
                // When the first poll character is the same as last inserted character, get the second one!
                int[] second = pq.poll();
                // When we are not able to get the second one but need that to finish the string, then return empty as requirement
                if (second == null) return "";
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            }
        }

        return sb.toString();
    }
}
