package leetcode;


/*
    https://leetcode.com/problems/design-hashmap/
 */
public class DesignHashMap {

    private int[] map;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        map = new int[100000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // Using +1 here to support -1 return when key not existed
        map[key] = value + 1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // Using +1 above to support -1 here when key not existed
        return map[key] - 1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = 0;
    }

    public static void main(String[] args) {
        DesignHashMap hashMap = new DesignHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }



}
