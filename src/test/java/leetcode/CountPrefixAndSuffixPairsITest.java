package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPrefixAndSuffixPairsITest {

    @Test
    void countPrefixSuffixPairs() {
        int ans1 = new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(
                new String[]{"a", "aba", "ababa", "aa"}
        );
        assertEquals(4, ans1);
        int ans2 = new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(
                new String[]{"pa", "papa", "ma", "mama"}
        );
        assertEquals(2, ans2);
    }

}