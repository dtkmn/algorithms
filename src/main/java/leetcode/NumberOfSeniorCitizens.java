package leetcode;


/**
 * <a href="https://leetcode.com/problems/number-of-senior-citizens">2678. Number of Senior Citizens</a>
 *
 */
public class NumberOfSeniorCitizens {

    public int countSeniors(String[] details) {
        int count = 0;
        for (String p: details) {
            if (10 * (p.charAt(11) - '0') + (p.charAt(12) - '0') > 60) {
                count++;
            }
        }
        return count;
    }

}
