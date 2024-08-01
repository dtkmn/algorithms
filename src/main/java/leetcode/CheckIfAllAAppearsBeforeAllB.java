package leetcode;


/**
 * <a href="https://leetcode.com/problems/check-if-all-as-appears-before-all-bs">2124. Check if All A's Appears Before All B's</a>
 *
 */
public class CheckIfAllAAppearsBeforeAllB {

    public boolean checkString(String s) {
        int aIndex = -1, bIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bIndex = i;
            } else if (s.charAt(i) == 'a') {
                aIndex = i;
                if (bIndex != -1 && bIndex < aIndex) {
                    return false;
                }
            }
        }
        return true;
    }

}
