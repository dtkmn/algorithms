package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 */
public class GroupAnagrams {

    // 6ms
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> store = new HashMap<>();

        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key =  new String(charArray);
            if (store.containsKey(key)) {
                List<String> list = store.get(key);
                list.add(str);
                store.put(key, list);
            } else {
                List<String> val = new ArrayList<>();
                val.add(str);
                store.put(key, val);
            }
        }

        return new ArrayList<>(store.values());

    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
