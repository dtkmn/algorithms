package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">...</a>
 */
public class InsertDeleteGetRandomO1v2 {

    private Map<Integer, Integer> intMap;
    private List<Integer> intList;

    public InsertDeleteGetRandomO1v2() {
        intMap = new HashMap<>();
        intList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (intMap.containsKey(val)) return false;
        intMap.put(val, intList.size());
        intList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!intMap.containsKey(val)) return false;
        int index = intMap.get(val);
        intList.set(index, intList.getLast());
        intMap.put(intList.getLast(), index);
        intList.removeLast();
        intMap.remove(val);
        return true;
    }

    public int getRandom() {
        int size = intList.size();
        if (size == 0) return 0;
        int r = new Random().nextInt(intList.size());
        return intList.get(r);
    }

    public static void main(String[] args) {
        // Init an empty set.
        InsertDeleteGetRandomO1v2 randomSet = new InsertDeleteGetRandomO1v2();
//        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
//        System.out.println(randomSet.insert(1));
//        // Returns false as 2 does not exist in the set.
//        System.out.println(randomSet.remove(2));
//        // Inserts 2 to the set, returns true. Set now contains [1,2].
//        System.out.println(randomSet.insert(2));
//        // getRandom should return either 1 or 2 randomly.
//        System.out.println(randomSet.getRandom());
//        // Removes 1 from the set, returns true. Set now contains [2].
//        System.out.println(randomSet.remove(1));
//        // 2 was already in the set, so return false.
//        System.out.println(randomSet.insert(2));
//        // Since 2 is the only number in the set, getRandom always return 2.
//        System.out.println(randomSet.getRandom());

        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.getRandom());
    }

}
