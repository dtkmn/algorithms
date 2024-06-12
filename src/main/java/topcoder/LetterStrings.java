package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class LetterStrings {

    public static void main(String[] args) {
        String[] s = {"-A-B-C-D", "--------EFGHI", "JKLMNOPQR", "---STU-VW-XYZ"};
        System.out.println(new LetterStrings().sum(s));
    }

    public int sum(String[] s) {
        int sum = 0;
        for(int i=0; i<s.length; i++) {
            String input = s[i];
            input = input.replaceAll("-", "");
            sum += input.length();
        }
        return sum;
    }

}
