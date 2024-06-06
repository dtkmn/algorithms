package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/hand-of-straights/">846. Hand of Straights</a>
 */
public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int size = hand.length;
        if (size % groupSize != 0) return false;
        Arrays.sort(hand);
        int numOfGroup = size / groupSize;
        int[] qs = new int[numOfGroup];
        Arrays.fill(qs, -1);
        int[] count = new int[numOfGroup];
        int startRow = 0;
        for (int value : hand) {
            int currRow = startRow;
            while (currRow < qs.length) {
                if (count[currRow] == groupSize) {
                    startRow++;
                } else if (qs[currRow] == -1 || qs[currRow] + 1 == value) {
                    qs[currRow] = value;
                    count[currRow]++;
                    break;
                }
                currRow++;
            }
            if (currRow == qs.length) return false;
        }
        return true;
    }

}
