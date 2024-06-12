package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class InsertDeleteGetRandomO1 {

    // List is used to achieve insert and getRandom in constant time
    private List<Integer> list;
    private Map<Integer, Integer> maps;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        list = new ArrayList<>();
        maps = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (maps.containsKey(val)) return false;
        maps.put(val, list.size());
        return list.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (maps.containsKey(val)) {
            // Get index of remove value
            int pos = maps.get(val);
            // Get last element value for swap
            int lastElement = list.get(list.size() - 1);

            // Move last element to index of remove val
            list.set(pos, lastElement);
            // Update its index on map
            maps.put(lastElement, pos);

            // Remove last element from list
            list.remove(list.size() - 1);
            // Remove from map
            maps.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

    public static void main(String[] args) {
        // Init an empty set.
        InsertDeleteGetRandomO1 randomSet = new InsertDeleteGetRandomO1();
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
