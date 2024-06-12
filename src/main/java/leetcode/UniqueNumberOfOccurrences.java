package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/unique-number-of-occurrences/">...</a>
 */
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value: arr) {
            countMap.put(value, 1 + countMap.getOrDefault(value, 0));
        }
        int s1 = countMap.size();
        HashSet<Integer> set = new HashSet<>(countMap.values());
        return s1 == set.size();
    }

    public static void main(String[] args) {

    }

}
