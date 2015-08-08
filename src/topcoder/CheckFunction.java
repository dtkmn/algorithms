package topcoder;

import java.util.Scanner;

/**
 * Created by dtkmn on 8/08/2015.
 */
public class CheckFunction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(newFunction(input));
    }


    public static int newFunction(String code) {
        int[] count = {6,2,5,5,4,5,6,3,7,6};
        int sum = 0;
        for(int i=0; i<code.length(); i++) {
            char c = code.charAt(i);
            sum += count[Character.getNumericValue(c)];
        }
        return sum;
    }

}
