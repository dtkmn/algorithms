package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortThePeopleTest {

    @Test
    void sortPeople_mergesort() {
        SortThePeople system = new SortThePeople();
        String[] ans1 = system.sortPeople_mergesort(
                new String[]{ "Mary", "John", "Emma" },
                new int[]{ 180, 165, 170 }
        );
        assertArrayEquals(new String[]{ "Mary", "Emma", "John" }, ans1);
    }
}